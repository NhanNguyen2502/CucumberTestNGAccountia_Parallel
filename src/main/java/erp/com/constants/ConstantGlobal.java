package erp.com.constants;

import erp.com.helpers.PropertiesHelper;

public class ConstantGlobal {
    static {
        PropertiesHelper.loadAllFile();
    }

    public final static String LOCATE =  PropertiesHelper.getValue("LOCATE");
    public final static String BROWSER = PropertiesHelper.getValue("BROWSER");
    public final static boolean HEADLESS = Boolean.parseBoolean(PropertiesHelper.getValue("HEADLESS"));
    public final static String URL = PropertiesHelper.getValue("URL");
    public final static String COMPANY_TYPE = PropertiesHelper.getValue("COMPANY_TYPE");
    public final static String USERNAME = PropertiesHelper.getValue("USERNAME");
    public final static String PASSWORD = PropertiesHelper.getValue("PASSWORD");
    public final static long STEP_TIME = Long.parseLong(PropertiesHelper.getValue("STEP_TIME"));
    public final static long EXPLICIT_TIMEOUT = Long.parseLong(PropertiesHelper.getValue("EXPLICIT_TIMEOUT"));
    public final static long PAGE_LOAD_TIMEOUT = Long.parseLong(PropertiesHelper.getValue("PAGE_LOAD_TIMEOUT"));
    public final static long PAGE_LOAD_TIMEOUT_FOR_CLICK = Long.parseLong(PropertiesHelper.getValue("PAGE_LOAD_TIMEOUT_FOR_CLICK"));
    public final static String  LANGUAGE_ENGLISH =  PropertiesHelper.getValue("LANGUAGE_ENGLISH");
    public final static String  LANGUAGE_ARABIC =  PropertiesHelper.getValue("LANGUAGE_ARABIC");
    public final static String  LANGUAGE_KURDISH_BADINI =  PropertiesHelper.getValue("LANGUAGE_KURDISH_BADINI");
    public final static String  LANGUAGE_KURDISH_SORANI =  PropertiesHelper.getValue("LANGUAGE_KURDISH_SORANI");
    public final static String ENV = PropertiesHelper.getValue("ENV");
    public final static String SCREENSHOT_FAIL = PropertiesHelper.getValue("SCREENSHOT_FAIL");
    public final static String SCREENSHOT_PASS = PropertiesHelper.getValue("SCREENSHOT_PASS");
    public final static String SCREENSHOT_STEP = PropertiesHelper.getValue("SCREENSHOT_STEP");
    public final static String RECORD_VIDEO = PropertiesHelper.getValue("RECORD_VIDEO");
    public final static String RECORD_VIDEO_PATH = PropertiesHelper.getValue("RECORD_VIDEO_PATH");
    public final static String EXTENT_REPORT_PATH = PropertiesHelper.getValue("EXTENT_REPORT_PATH");
    public final static String AUTHOR = PropertiesHelper.getValue("AUTHOR");
}
