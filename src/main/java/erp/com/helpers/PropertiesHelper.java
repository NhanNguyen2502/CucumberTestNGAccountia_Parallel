package erp.com.helpers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;

public class PropertiesHelper {
    private static Properties properties;
    private static String linkFile;
    private static FileInputStream file;
    private static FileOutputStream fileOut;
    private static String relPropertiesFilePathDefault = "src/test/resources/Configs.properties";

    public static Properties loadAllFile() {
        LinkedList<String> files = new LinkedList<>();
        files.add("src/test/resources/Configs.properties");
        files.add("src/test/java/resources/DataTest.properties");
        try {
            properties = new Properties();
            for (String f : files) {
                Properties tempProp = new Properties();
                linkFile = SystemHelpers.getCurrentDir() + f;
                file = new FileInputStream(linkFile);
                tempProp.load(file);
                properties.putAll(tempProp);
            }
            return properties;
        } catch (IOException ioe) {
            return new Properties();
        }
    }

    public static void setFile(String relPropertiesFilePath) {
        properties = new Properties();
        try {
            linkFile = SystemHelpers.getCurrentDir() + relPropertiesFilePath;
            file = new FileInputStream(linkFile);
            properties.load(file);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setDefaultFile() {
        properties = new Properties();
        try {
            linkFile = SystemHelpers.getCurrentDir() + relPropertiesFilePathDefault;
            file = new FileInputStream(linkFile);
            properties.load(file);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        String keyval = null;
        try {
            if (file == null) {
                properties = new Properties();
                linkFile = SystemHelpers.getCurrentDir() + relPropertiesFilePathDefault;
                file = new FileInputStream(linkFile);
                properties.load(file);
                file.close();
            }
            // Lấy giá trị từ file đã Set
            keyval = properties.getProperty(key);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return keyval;
    }

    public static void setValue(String key, String keyValue) {
        try {
            if (file == null) {
                properties = new Properties();
                file = new FileInputStream(SystemHelpers.getCurrentDir() + relPropertiesFilePathDefault);
                properties.load(file);
                file.close();
                fileOut = new FileOutputStream(SystemHelpers.getCurrentDir() + relPropertiesFilePathDefault);
            }
            //Ghi vào cùng file Prop với file lấy ra
            fileOut = new FileOutputStream(linkFile);
            System.out.println(linkFile);
            properties.setProperty(key, keyValue);
            properties.store(fileOut, "Set new value in properties file");
            System.out.println("Set new value successfully");
            fileOut.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getLanguageToTest() {
        PropertiesHelper.loadAllFile();
        return PropertiesHelper.getValue("language");
    }

}
