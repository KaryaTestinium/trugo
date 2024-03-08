package com.example;

import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SettingsMethods extends BaseMethods {

    @Step("Created  <invoice> invoice click <actions> button")
    public void loginWriteText(String invoice, String actions) {
        String path = "//*[contains(@text , '" + invoice + "')]/..//*[contains(@resource-id, '" + actions + "')]";
        WebElement element = findElementWithRetry(path, 2);
        element.click();
    }

    @Step("Switch button click <buttonName> make status <status>")
    public void clickSwitchButton(String buttonName, Boolean status) {
        String path = "//*[contains(@text, '" + buttonName + "')]../android.widget.Switch";
        WebElement element = findElementWithRetry(path, 2);
        boolean switchStatus = Boolean.parseBoolean(element.getAttribute("checked"));
        if (switchStatus != status) {
            element.click();
        } else {
            Logger.info("Switch status is already as expected");
        }
    }

    @Step("Check switch status <buttonName> must be <status>")
    public void getSwitchButtonAttribute(String buttonName, Boolean status) {
        String path = "//*[contains(@text, '" + buttonName + "')]../android.widget.Switch";
        Boolean switchStatus = Boolean.valueOf(findElementWithRetry(path, 2).getAttribute("checked"));
        assert switchStatus.equals(status) : "Switch status is not as expected";
    }

    @Step("Check switch clickable status <buttonName> must be <status>")
    public void checkClickableSwitch(String buttonName, String status) {
        String path = "//*[contains(@text, '" + buttonName + "')]../android.widget.Switch";
        Boolean switchStatus = Boolean.valueOf(findElementWithRetry(path, 2).getAttribute("clickable"));
        Boolean checkStatus = !status.toLowerCase().equals("disabled");

        Assert.assertNotEquals(switchStatus, checkStatus, "Switch clickable status is not as expected");
    }


}
