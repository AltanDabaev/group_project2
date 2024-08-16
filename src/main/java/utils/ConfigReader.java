package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String readProperty(String property) {
       return new ConfigReader().getPropertyFromFile(property);
    }

    private String getPropertyFromFile(String property) {
        Properties prop;
        FileInputStream fileInput;

        try {
            fileInput = new FileInputStream("config.properties");
            prop = new Properties();
            prop.load(fileInput);

            if (prop.getProperty(property) == null) {
                try {
                    fileInput = new FileInputStream("config-local.properties");
                    prop = new Properties();
                    prop.load(fileInput);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return prop.getProperty(property);
    }

    public static String readProperty(String filePath, String property) {
        Properties prop = null;
        try {
            FileInputStream fileInput = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(fileInput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(property);
    }
}