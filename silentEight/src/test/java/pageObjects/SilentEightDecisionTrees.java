package pageObjects;

public enum SilentEightDecisionTrees implements PageObject{
    LIST_OF_AVAILABLE_DECISION_TREES("//span[contains(text(), 'Available')]/../../..//tbody/tr/td"),
    LIST_OF_DECISION_TREES_IN_USE("//span[contains(text(), 'In Use')]/../../..//tbody/tr/td"),
    COPY_DECISION_TREE_IN_USE(
            "//span[contains(text(), 'In Use')]/../../..//tbody/tr/td/button[contains(text(), 'Copy')]"),
    NAME_OF_DECISION_TREE_TO_COPY("//div[@class='popup-window is-active']//b[@class='decision-tree-name']"),
    NAME_OF_NEW_COPY_OF_DECISION_TREE("//div[@class='popup-window is-active']//input"),
    SUBMIT_COPYING_PROCESS_BUTTON("//div[@class='popup-window is-active']//button[contains(text(), 'Copy')]");
    private String xPath;

    SilentEightDecisionTrees(String xPath) {
        this.xPath = xPath;
    }

    public String getXpath() {
        return this.xPath;
    }

    public void setXpath(String xPath) {
        this.xPath = xPath;
    }
}
