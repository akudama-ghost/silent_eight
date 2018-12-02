package pageObjects;

public enum SilentEightSingleDecisionTree implements PageObject{
    BUTTON_EDIT_ASSIGNMENTS	("//button[text()='Edit Assignments']"),
    LIST_OF_DEACTIVATE_BUTTONS("//button[@class='deactivate']");
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
