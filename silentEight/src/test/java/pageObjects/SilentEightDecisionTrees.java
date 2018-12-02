package pageObjects;

public enum SilentEightDecisionTrees implements PageObject{
    LIST_OF_DECISION_TREES("//tbody/tr/td");
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
