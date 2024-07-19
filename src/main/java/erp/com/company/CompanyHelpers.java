package erp.com.company;

import erp.com.helpers.TranslationHelpers;

public class CompanyHelpers {
    public static String getTypeOfDemoCompany(String language) {
        return TranslationHelpers.getTranslation("$.company.listPage.text.demo");
    }

    public static String getTypeOfRealCompany(String language) {
        return TranslationHelpers.getTranslation("$.company.listPage.text.real");
    }

    public static String getTypeCompany(String companyType, String language) {
        if (companyType.toUpperCase().equals("REAL")) {
            return getTypeOfRealCompany(language);
        } else {
            return getTypeOfDemoCompany(language);
        }

    }


}
