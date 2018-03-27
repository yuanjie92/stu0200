package com.train.common.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Config {

    private static final String FILENAME = "project.properties";
    private static final Properties PROPERTIES = new Properties();
    private static InputStream inputStream = null;

    static {
        inputStream = Config.class.getClassLoader().getResourceAsStream(FILENAME);
        try {
            PROPERTIES.load(new InputStreamReader(inputStream, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addProperty(String key, String value) {
        PROPERTIES.getProperty(key);
    }

    public static boolean remove(String key) {
        boolean flag = false;
        if (PROPERTIES.containsKey(key)) {
            PROPERTIES.remove(key);
            flag = true;
        }
        return flag;
    }

    public static Map<String, Object> getAllProperties() {
        Map<String, Object> map = new HashMap<String, Object>();
        Set<Object> set = PROPERTIES.keySet();
        for (Iterator<Object> iter = set.iterator(); iter.hasNext(); ) {
            String key = (String) iter.next();
            map.put(key, PROPERTIES.get(key));
        }
        return map;
    }

    public static String getProperty(String key, String defaultValue) {
        if (PROPERTIES.containsKey(key)) {
            return PROPERTIES.getProperty(key);
        }
        return defaultValue;
    }

    public static int getProperty(String key, int defaultValue) {
        if (PROPERTIES.containsKey(key)) {
            return Integer.parseInt(PROPERTIES.getProperty(key));
        }
        return defaultValue;
    }

    public static long getProperty(String key, long defaultValue) {
        if (PROPERTIES.containsKey(key)) {
            return Long.parseLong(PROPERTIES.getProperty(key));
        }
        return defaultValue;
    }

    public static boolean getProperty(String key, boolean defaultValue) {
        if (PROPERTIES.containsKey(key)) {
            return Boolean.getBoolean(PROPERTIES.getProperty(key));
        }
        return defaultValue;
    }

    public static double getProperty(String key, double defaultValue) {
        if (PROPERTIES.containsKey(key)) {
            return Double.parseDouble(PROPERTIES.getProperty(key));
        }
        return defaultValue;
    }

    public static String getStringProperty(String key) {
        return getProperty(key, null);
    }

    public static int getIntProperty(String key) {
        return getProperty(key, 0);
    }

    public static double getDoubleProperty(String key) {
        return getProperty(key, 0.0d);
    }

    public static boolean getProperty(String key) {
        return getProperty(key, false);
    }

}
