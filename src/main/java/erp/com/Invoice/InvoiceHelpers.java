package erp.com.Invoice;

import erp.com.helpers.TranslationHelpers;

public class InvoiceHelpers {
    private static String invoiceStandard = "$.invoicesCommon.chip.standard";
    private static String invoiceInstalment = "$.invoicesCommon.chip.installment";
    private static String invoiceCashSale = "$.invoicesCommon.chip.cashSale";

    public static String getInvoiceStandard() {
        return TranslationHelpers.getTranslation(invoiceStandard);
    }

    public static String getInvoiceInstalment() {
        return TranslationHelpers.getTranslation(invoiceInstalment);
    }

    public static String getInvoiceCashSale() {
        return TranslationHelpers.getTranslation(invoiceCashSale);
    }

    public static String getInvoiceType(String invoiceType) {
        switch (invoiceType.trim().toUpperCase()) {
            case "STANDARD":
                return getInvoiceStandard();
            case "INSTALMENT":
                return getInvoiceInstalment();
            case "CASHSALE":
                return getInvoiceCashSale();
            default:
                return "";
        }
    }
}
