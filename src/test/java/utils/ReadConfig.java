package utils;

import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {


    public static String getConfigData(String configFilePath, String configDataKey) {

        try {

            Properties prop = new Properties();
            File file = new File(configFilePath);
            FileInputStream fis = new FileInputStream(file);
            prop.load(fis);
            return prop.getProperty(configDataKey);
        } catch (Exception e) {
            System.out.println("Cannot read " + configDataKey + configFilePath);
            Assert.fail("Cannot read " + configDataKey + " from Test Data file, Exception: " + e.getMessage());
            return e.getMessage();
        }

    }

}