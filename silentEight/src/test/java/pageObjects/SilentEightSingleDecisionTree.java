package pageObjects;

public enum SilentEightSingleDecisionTree implements PageObject {
    BUTTON_EDIT_ASSIGNMENTS("//button[text()='Edit Assignments']"),
    BUTTON_SAVE_EDIT_ASSIGNMENTS("//button[@id='saveButton']"),
    ERROR_MESSAGE_AFTER_EDIT_ASSIGNMENTS("//div[contains(@class, 'message error is-active')]");


    private String xPath;

    SilentEightSingleDecisionTree(String xPath) {
        this.xPath = xPath;
    }

    public String getXpath() {
        return this.xPath;
    }

    public void setXpath(String xPath) {
        this.xPath = xPath;
    }
}
