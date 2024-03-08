package com.example;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginMethods extends BaseMethods {

    @Step("Write OTP code")
    public void writeOTP()  {
        String otpXpath = "(//*[@resource-id='com.togg.trugoapp.preprod:id/otpEditText'])[1]//android.widget.EditText";
        String otp = getOtp();

        System.out.println("Current OTP Code = " + otp);
        WebElement codeArea = driver.findElement(By.xpath(otpXpath));
        codeArea.click();
        codeArea.sendKeys(otp);
    }

    public String getOtp() {
        String message = createWebElement("SMSEXPLORER").getText();

        String[] parts = message.split("\\s+");
        for (String part : parts) {
            if (part.matches("\\d{4}")) return part;
        }
        return null;
    }
}
