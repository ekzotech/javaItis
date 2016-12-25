package me.evilcorp.factory.loader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by ekzotech on 29.11.16.
 */
public class PropertyLoader {
    private static final String IOC_CONFIG_FILE_PATH;
    private static final String DB_CONFIG_FILE_PATH;
    private static Properties properties;

    static {
        IOC_CONFIG_FILE_PATH = "/home/ekzotech/Projects/javaItis/lesson7/dao-jdbc/src/main/resources/config.properties";
        DB_CONFIG_FILE_PATH = "/home/ekzotech/Projects/javaItis/lesson7/dao-jdbc/src/main/resources/db/db.properties";
        properties = new Properties();
    }

    public static void loadIocConfig() { load(IOC_CONFIG_FILE_PATH); }
    public static void loadDbConfig() { load(DB_CONFIG_FILE_PATH); }
    public static String getProperty(String key) { return properties.getProperty(key); }

    public static void load(String config) {
        try (FileInputStream stream = new FileInputStream(config)){
            properties.load(stream);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
