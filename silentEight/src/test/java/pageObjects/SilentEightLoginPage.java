package pageObjects;

public enum SilentEightLoginPage implements PageObject{
    INPUT_LOGIN	("//input[@id='username']"),
    INPUT_PASSWORD("//input[@id='password']"),
    INPUT_SUBMIT("//input[@name='submit']");
    private String xPath;

    SilentEightLoginPage(String xPath) {
        this.xPath = xPath;
    }

    public String getXpath() {
        return this.xPath;
    }

    public void setXpath(String xPath) {
        this.xPath = xPath;
    }
}
