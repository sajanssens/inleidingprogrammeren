package jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyProperties {

    private MyProperties() { }

    static Properties prop = new Properties();

    static {
        try (InputStream file = MyProperties.class.getClassLoader().getResourceAsStream("database.properties")) {
            prop.load(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }

}

