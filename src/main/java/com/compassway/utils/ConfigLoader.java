package com.compassway.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private static final Properties properties;
    private static final Properties credentials;

    static {
        try (FileInputStream fis = new FileInputStream("src/main/resources/WebDriverConfig.properties")) {
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config properties file.", e);
        }

        try (FileInputStream fis = new FileInputStream("src/main/resources/credentials.properties")) {
            credentials = new Properties();
            credentials.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config properties file.", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public static String getCredentials(String key) {
        return credentials.getProperty(key);
    }
}