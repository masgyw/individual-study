package cn.gyw.platform.configuration.service;

import cn.gyw.platform.configuration.interfaces.IConfigurationEntryListener;
import cn.gyw.platform.configuration.interfaces.IConfigurationSectionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Configuration 注册器
 */
public abstract class ConfigurationRegistry {

    private static final Logger log = LoggerFactory.getLogger(ConfigurationRegistry.class);

    private static Map<String, Set<IConfigurationEntryListener>> entryListeners = new HashMap<>();
    private static Map<String, Set<IConfigurationSectionListener>> sectionListeners = new HashMap<>();

    private static final String SEPARATOR = ".";
    private static final Lock lock = new ReentrantLock();

    /**
     * 注册 section 域监听器
     *
     * @param section
     * @param listener
     */
    public static void registerSectionListener(String section, IConfigurationSectionListener listener) {
        if (Objects.nonNull(listener)) {
            lock.lock();
            try {
                if (!sectionListeners.containsKey(section)) {
                    sectionListeners.put(section, new HashSet<>());
                }
                sectionListeners.get(section).add(listener);
            } finally {
                lock.unlock();
            }
        }
    }

    public static void registerEntryListener(String section, String parameterKey, IConfigurationEntryListener listener) {
        if (Objects.nonNull(listener)) {
            String keyName = section + SEPARATOR + parameterKey;
            lock.lock();
            try {
                if (!entryListeners.containsKey(section)) {
                    entryListeners.put(keyName, new HashSet<>());
                }
                entryListeners.get(section).add(listener);
            } finally {
                lock.unlock();
            }
        }
    }

    public static void unregisterSectionListener(String section, IConfigurationSectionListener listener) {
        Set<IConfigurationSectionListener> listeners = sectionListeners.get(section);
        if (Objects.nonNull(listeners) && listeners.size() > 0) {
            listeners.remove(listener);
        }
    }

    public static void unregisterEntryListener(String section, String parameterKey, IConfigurationEntryListener listener) {
        String keyName = section + SEPARATOR + parameterKey;
        Set<IConfigurationEntryListener> listeners = entryListeners.get(keyName);
        if (Objects.nonNull(listeners) && listeners.size() > 0) {
            listeners.remove(listener);
        }
    }

    protected static void notifySectionListeners(String section, Method method) {
        Optional.ofNullable(sectionListeners.get(section))
                .ifPresent(set -> set.forEach((listener -> {
                    try {
                        method.invoke(listener, section);
                    } catch (Exception e) {
                        log.error("Invoke section listener method error :", e);
                    }
                })));
    }

    protected static void notifyEntryListeners(String section, String parameterKey, Method method) {
        String keyName = section + SEPARATOR + parameterKey;
        Optional.ofNullable(entryListeners.get(keyName))
                .ifPresent(set -> set.forEach((listener -> {
                    try {
                        method.invoke(listener, section, parameterKey);
                    } catch (Exception e) {
                        log.error("Invoke entry listener method error :", e);
                    }
                })));
    }
}
