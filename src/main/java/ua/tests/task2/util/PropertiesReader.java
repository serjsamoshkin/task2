package ua.tests.task2.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesReader {

    private static volatile Map<String, String> pairs;

    public static Map<String, String> getPropertiesMap(String path) {

        Map<String, String> localInstance = pairs;
        if (localInstance == null) {
            synchronized (PropertiesReader.class) {
                localInstance = pairs;
                if (localInstance == null) {
                    pairs = localInstance = new HashMap<>();
                    Properties props = new Properties();
                    String resourceName = path;
                    ClassLoader loader = Thread.currentThread().getContextClassLoader();

                    try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {

                        props.load(resourceStream);

                        Enumeration<String> enums = (Enumeration<String>) props.propertyNames();
                        while (enums.hasMoreElements()) {
                            String key = enums.nextElement();
                            String value = props.getProperty(key);
                            pairs.put(key, value);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        return pairs;
    }
}
