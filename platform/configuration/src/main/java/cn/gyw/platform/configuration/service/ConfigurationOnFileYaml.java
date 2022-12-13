package cn.gyw.platform.configuration.service;

import cn.gyw.platform.configuration.exception.ConfigurationException;
import org.apache.commons.configuration2.YAMLConfiguration;
import org.apache.commons.configuration2.builder.ConfigurationBuilderEvent;
import org.apache.commons.configuration2.builder.ReloadingFileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.event.EventListener;
import org.apache.commons.configuration2.reloading.PeriodicReloadingTrigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author
 * @desc 基于本地.yml配置文件的配置服务实现
 * @createdTime 2022/5/21
 */
public class ConfigurationOnFileYaml extends AbstractConfigurationService {

    private static final Logger log = LoggerFactory.getLogger(ConfigurationOnFileYaml.class);

    private static final String SPLIT = ".";
    private static final String CONFIG_FILE = "CONFIGURATION.yml";

    private ReloadingFileBasedConfigurationBuilder<YAMLConfiguration> builder = null;

    private YAMLConfiguration configuration = null;

    private Lock lock = new ReentrantLock();

    public ConfigurationOnFileYaml() {
        Path filePath = Paths.get(String.join(File.separator, System.getProperty("user.home"), CONFIG_FILE));
        log.info("Using configuration file :{}", filePath);
        try {
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
            Parameters params = new Parameters();
            this.builder = new ReloadingFileBasedConfigurationBuilder<>(YAMLConfiguration.class)
                    .configure(params.fileBased().setFile(filePath.toFile()));
            this.builder.addEventListener(ConfigurationBuilderEvent.RESET, new ConfigurationOnFileYaml.BuilderChangeListener());
            this.configuration = this.builder.getConfiguration();
            // hot reload
            PeriodicReloadingTrigger trigger = new PeriodicReloadingTrigger(this.builder.getReloadingController(), null, 60L, TimeUnit.SECONDS, Executors.newScheduledThreadPool(1));
            trigger.start();
        } catch (Exception e) {
            log.error("error :", e);
        }
    }

    @Override
    protected String doGetValue(String section, String key) {
        return this.configuration.getString(section + SPLIT + key);
    }

    @Override
    protected String doGetValue(String section, String key, String defaultValue) {
        return this.configuration.getString(section + SPLIT + key, defaultValue);
    }

    @Override
    protected void doSetValue(String section, String key, String value) throws ConfigurationException {
        this.configuration.setProperty(section + SPLIT + key, value);
        this.doSave();
    }

    @Override
    protected void doRemoveEntry(String section, String key) throws ConfigurationException {
        this.configuration.clearProperty(section + SPLIT + key);
        this.doSave();
    }

    @Override
    protected boolean doContainsEntry(String section, String key) {
        return this.configuration.containsKey(section + SPLIT + key);
    }

    @Override
    protected Map<String, String> doGetSection(String section) {
        Iterator<String> iterator = this.configuration.getKeys(section);
        if (Objects.isNull(iterator)) {
            return null;
        }
        Map<String, String> configMap = new HashMap<>();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String val = this.configuration.getString(key);
            configMap.put(key, val);
        }
        return configMap;
    }

    @Override
    protected void doSetSection(String section, Map<String, String> map) throws ConfigurationException {
        this.doRemoveSection(section);
        if (Objects.isNull(map)) {
            log.warn("Section data is null");
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.doSetValue(section, entry.getKey(), entry.getValue());
        }
        this.doSave();
    }

    @Override
    protected void doRemoveSection(String section) throws ConfigurationException {
        this.configuration.clearTree(section);
        this.doSave();
    }

    @Override
    protected boolean doContainsSection(String section) {
        return this.configuration.getKeys(section).hasNext();
    }

    private void doSave() throws ConfigurationException {
        try {
            this.builder.save();
        } catch (Exception e) {
            throw new ConfigurationException(e);
        }
    }

    private class BuilderChangeListener implements EventListener<ConfigurationBuilderEvent> {

        @Override
        public void onEvent(ConfigurationBuilderEvent event) {
            String type = event.getEventType().getName();
            log.info("Event type [{}]", type);
            System.out.println(event);
            if (type.equals("RESET")) {
                lock.lock();
                try {
                    YAMLConfiguration newConfig = builder.getConfiguration();
                    // backup original config, and reset
                    YAMLConfiguration oldConfig = (YAMLConfiguration) configuration.clone();
                    ConfigurationOnFileYaml.this.configuration = newConfig;

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

}
