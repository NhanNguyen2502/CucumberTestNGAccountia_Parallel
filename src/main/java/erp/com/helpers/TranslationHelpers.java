package erp.com.helpers;

import com.jayway.jsonpath.JsonPath;
import erp.com.constants.ConstantGlobal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TranslationHelpers {
    private static BufferedReader bufferedReader;
    private static String lines;
    private static StringBuffer lineBuffer;
    private static String linkFile;

    public static void loadAllTranslation(String language) {
        String fileUrl = SystemHelpers.getCurrentDir() + "src/test/java/resources/en_GB.json";
        switch (language) {
            case "English" -> {
                fileUrl = SystemHelpers.getCurrentDir() + "src/test/resources/en_GB.json";
            }
            case "Arabic" -> {
                fileUrl = SystemHelpers.getCurrentDir() + "src/test/resources/ar.json";

            }
            case "Kurdish - Badini" -> {
                fileUrl = SystemHelpers.getCurrentDir() + "src/test/resources/ku_BA.json";
            }
            case "Kurdish - Sorani" -> {
                fileUrl = SystemHelpers.getCurrentDir() + "src/test/resources/ku_CKB.json";
            }
            default -> fileUrl = SystemHelpers.getCurrentDir() + "src/test/resources/en_GB.json";
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(fileUrl));
            lineBuffer = new StringBuffer();
            while ((lines = bufferedReader.readLine()) != null) {
                lineBuffer.append(lines);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTranslation(String key) {
        try {
            if (lineBuffer.isEmpty()) {
                loadAllTranslation(ConstantGlobal.LANGUAGE_ENGLISH);
            }
            return JsonPath.read(lineBuffer.toString(), key);
        } catch (Exception e) {
            return "Key not found";
        }
    }


    public static String getTranslation12(String language, String key) {
        String text = null;
        String fileUrl = SystemHelpers.getCurrentDir() + "src/test/java/resources/en_GB.json";
        switch (language) {
            case "English" -> {
                fileUrl = SystemHelpers.getCurrentDir() + "src/test/resources/en_GB.json";
            }
            case "Arabic" -> {
                fileUrl = SystemHelpers.getCurrentDir() + "src/test/resources/ar.json";

            }
            case "Kurdish - Badini" -> {
                fileUrl = SystemHelpers.getCurrentDir() + "src/test/resources/ku_BA.json";
            }
            case "Kurdish - Sorani" -> {
                fileUrl = SystemHelpers.getCurrentDir() + "src/test/resources/ku_CKB.json";
            }
            default -> fileUrl = SystemHelpers.getCurrentDir() + "src/test/resources/en_GB.json";
        }

        //Read the file
        try {
            bufferedReader = new BufferedReader(new FileReader(fileUrl));
            lineBuffer = new StringBuffer();
            while ((lines = bufferedReader.readLine()) != null) {
                lineBuffer.append(lines);
            }
            text = JsonPath.read(lineBuffer.toString(), key);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

}
