package pageObjects;

public class DynamicObjects {

    public static String getXPathOfEditAssignmentsSectionTitle(String key) {
        return "//div[text()='" + key + "']/../../../h3";
    }

    public static String getXPathOfEditAssignmentsItem(String key) {
        return "//div[text()='" + key + "']";
    }

    public static String getXPathOfEditAssignmentsActionButtonForKey(String key, String button) {
        return "//div[text()='" + key + "']/..//button[@class='" + button + "']";
    }
}
