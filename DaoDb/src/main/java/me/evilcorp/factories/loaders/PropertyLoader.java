package me.evilcorp.factories.loaders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by ekzotech on 09.12.16.
 */
public class PropertyLoader {
    private static final String IOC_CONFIG_FILE_PATH;

    private static Properties properties;

    static {
        IOC_CONFIG_FILE_PATH = "/home/ekzotech/Projects/javaItis/DaoDb/src/main/resources/ioc.properties";
        properties = new Properties();
        try {
            properties.load(new FileInputStream(IOC_CONFIG_FILE_PATH));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
