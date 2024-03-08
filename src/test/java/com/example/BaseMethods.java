package com.example;

import base.Base;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

public class BaseMethods extends Base {

    Logger logger = Logger.getLogger(String.valueOf(BaseMethods.class));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

    @Step({"Find element <ElementName>", "Check element existence <ElementName>"})
    public WebElement createWebElement(String ElementName) {
        String xpathTemplate;
        if (ElementName.toLowerCase().contains("xpath.")) {
            xpathTemplate = ElementName.replaceAll("xpath", "");
        } else {
            xpathTemplate = "//*[contains(@resource-id,'" + ElementName + "') or contains(@text ,'" + ElementName + "')]";
        }

        System.out.println(xpathTemplate);

        WebElement mainElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathTemplate)));
        Assert.assertNotNull(mainElement, "Element is not found: %s".formatted(ElementName));
        logger.info(mainElement.getText());
        logger.info("Element is found: %s".formatted(ElementName));

        return mainElement;
    }

    @Step("Check element existence <ElementName> must be <status>")
    public void checkElementVisibility(String ElementName, String status) {
        WebElement mainElement = createWebElement(ElementName);
        boolean shouldBeVisible = status.equalsIgnoreCase("true") || status.equalsIgnoreCase("visible");
        Assert.assertEquals(mainElement.isDisplayed(), shouldBeVisible, "Element visibility mismatch: %s".formatted(ElementName));
    }

    @Step("Click element <ElementName>")
    public void clickElement(String ElementName) {
        createWebElement(ElementName).click();
        logger.info("Clicked on the element: %s".formatted(ElementName));
    }

    @Step("Click element  with Xpath <path>")
    public void clickElementWithXpath(String path) {
        WebElement mainElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
        Assert.assertNotNull(mainElement, "Element is not found: ");
        mainElement.click();
        logger.info("Clicked on the element: ");
    }


    @Step("Write text <text> to this element <ElementName>")
    public void writeTextToInputArea(String text, String ElementName) {
        WebElement element = createWebElement(ElementName);
        if (!element.getText().isEmpty()) element.clear();
        element.click();
        element.sendKeys(text);
    }

    @Step("Sout <text>")
    public void sout(String text) {
        System.out.println(text);
    }

    @Step("Click button <ElementName>")
    public void clickButton(String ElementName) {
        createWebElement(ElementName).click();
        logger.info("Clicked on the button: %s".formatted(ElementName));
    }

    @Step("Component Input Write Text <text> to this element <ElementName>")
    public void loginWriteText(String text , String ElementName) {
        String path = "//*[contains(@text , '" + ElementName + "')]/..//android.widget.EditText";
        WebElement element = findElementWithRetry(path, 2);
        if (!element.getText().isEmpty()) element.clear();
        element.click();
        element.sendKeys(text);
        driver.navigate().back();
    }

    @Step("Click button for form <ElementName>")
    public void clickButtonForm(String ElementName) {
        String path = "//*[contains(@text , '" + ElementName + "')]/..//android.widget.EditText";
        WebElement element = findElementWithRetry(path, 15);
        element.click();
        logger.info(String.format("Clicked on the button: %s", ElementName));
    }

    @Step("Select <ElementName> from dropdown")
    public void clickDropdownButton(String ElementName) {
        String path = "//*[contains(@text , '" + ElementName + "')]";
        WebElement element = findElementWithRetry(path, 15);
        element.click();
        logger.info(String.format("Clicked on the button: %s", ElementName));
    }

    public WebElement findElementWithRetry(String path, int retries) {
        logger.info(path);
        for (int i = 0; i < retries; i++) {
            try {
                WebElement element = new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
                logger.info("-------------------------------" + element + "-----------------------------------");
                if (element != null) {
                    return element;
                }
            } catch (TimeoutException e) {
                swipe();
                logger.info("Element not found, retrying...");
            }
        }
        throw new NoSuchElementException("Element not found after " + retries + " retries.");
    }


    @Step("Wait <time> Seconds")
    public void waitTime(int time) throws InterruptedException {
        Thread.sleep(time * 1000L);
    }

    @Step("Swipe")
    public void swipe() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endY = (int) (size.getHeight() * 0.25);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 0);

        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(scroll));
    }


}