package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;

    public static void loadConfig() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("testdata/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not load config.properties file");
        }
    }

    public static String getProperty(String key) {
        if (prop == null) {
            loadConfig();
        }
        return prop.getProperty(key);
    }

}
