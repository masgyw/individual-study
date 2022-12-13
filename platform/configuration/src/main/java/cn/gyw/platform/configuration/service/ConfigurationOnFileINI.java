package cn.gyw.platform.configuration.service;

import cn.gyw.platform.configuration.exception.ConfigurationException;
import org.apache.commons.configuration2.INIConfiguration;
import org.apache.commons.configuration2.SubnodeConfiguration;
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
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 基于本地.ini配置文件的配置服务实现
 */
public class ConfigurationOnFileINI extends AbstractConfigurationService {

    private static final long serialVersionUID = 2166333706628099132L;

    private static final Logger log = LoggerFactory.getLogger(ConfigurationOnFileINI.class);

    private ReloadingFileBasedConfigurationBuilder<INIConfiguration> builder = null;

    private static final String CONFIG_FILE = "CONFIGURATION.INI";
    private INIConfiguration configuration = null;

    private Lock lock = new ReentrantLock();

    public ConfigurationOnFileINI() {
        Path filePath = Paths.get(String.join(File.separator, System.getProperty("user.home"), CONFIG_FILE));
        log.info("Using configuration file :{}", filePath);
        try {
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
            Parameters params = new Parameters();
            this.builder = new ReloadingFileBasedConfigurationBuilder<>(INIConfiguration.class)
                    .configure(params.fileBased().setFile(filePath.toFile()));
            this.builder.addEventListener(ConfigurationBuilderEvent.RESET, new ConfigurationOnFileINI.BuilderChangeListener());
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
        section = section.replaceAll("\\.", "..");
        key = key.replaceAll("\\.", "..");
        return Objects.nonNull(this.configuration) ? this.configuration.getString(section + "." + key) : null;
    }

    @Override
    protected String doGetValue(String section, String key, String defaultValue) {
        String value = this.doGetValue(section, key);
        return Objects.nonNull(value) ? value : defaultValue;
    }

    @Override
    protected void doSetValue(String section, String key, String value) throws ConfigurationException {
        section = section.replaceAll("\\.", "..");
        key = key.replaceAll("\\.", "..");
        this.configuration.setProperty(section + "." + key, value);
        this.doSave();
    }

    @Override
    protected void doRemoveEntry(String section, String key) throws ConfigurationException {
        section = section.replaceAll("\\.", "..");
        key = key.replaceAll("\\.", "..");
        this.configuration.clearProperty(section + "." + key);
        this.doSave();
    }

    @Override
    protected boolean doContainsEntry(String section, String key) {
        section = section.replaceAll("\\.", "..");
        key = key.replaceAll("\\.", "..");
        return Objects.nonNull(this.configuration) && this.configuration.containsKey(section + "." + key);
    }

    @Override
    protected Map<String, String> doGetSection(String section) {
        section = section.replaceAll("\\.", "..");
        if (Objects.isNull(this.configuration)) {
            return null;
        }
        SubnodeConfiguration fields = this.configuration.getSection(section);
        if (Objects.isNull(fields)) {
            return null;
        }
        Map<String, String> configMap = new HashMap<>();
        for (Iterator<String> iterator = fields.getKeys(); iterator.hasNext(); ) {
            String key = iterator.next();
            String val = fields.getString(key);
            configMap.put(key.replaceAll("\\.\\.", "."), val);
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
        this.configuration.clearTree(section.replaceAll("\\.", ".."));
        this.doSave();
    }

    @Override
    protected boolean doContainsSection(String section) {
        section = section.replaceAll("\\.", "..");
        return Objects.nonNull(this.configuration)
                && this.configuration.getSections().contains(section);
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
            if (type.equals("RESET")) {
                lock.lock();
                try {
                    INIConfiguration newConfig = builder.getConfiguration();
                    // backup original config, and reset
                    INIConfiguration oldConfig = (INIConfiguration) configuration.clone();
                    ConfigurationOnFileINI.this.configuration = newConfig;
                    List<String> oldSections = sortSections(oldConfig);
                    List<String> newSections = sortSections(newConfig);

                    int len = Math.min(oldSections.size(), newSections.size());
                    for (int i = 0; i < len; i++) {
                        String oldSection = preHandleSection(oldSections.get(i));
                        String newSection = preHandleSection(newSections.get(i));
                        log.info("Old section :{} >> new Section :{}", oldSection, newSection);
                        if (oldSection == null) {

                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }

        private List<String> sortSections(INIConfiguration config) {
            List<String> sections = new ArrayList<>(config.getSections());
            Collections.sort(sections);
            return sections;
        }

        private String preHandleSection(String section) {
            return section.replaceAll("\\.\\.", ".");
        }
    }
}
