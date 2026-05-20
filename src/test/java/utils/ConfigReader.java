package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;

    static {

        try {

            FileInputStream file =
                    new FileInputStream(
                            "src/test/resources/config.properties"
                    );

            properties = new Properties();

            properties.load(file);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    // Get Browser Name
    public static String getBrowser() {

        return properties.getProperty("browser");
    }

    // Get Base URL
    public static String getBaseUrl() {

        return properties.getProperty("baseUrl");
    }

    // Get Timeout
    public static int getTimeout() {

        return Integer.parseInt(
                properties.getProperty("timeout")
        );
    }
}