package base;

import com.thoughtworks.gauge.Step;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MailVerifications {
    private final String endpoint = "https://script.google.com/macros/s/AKfycbzUH7uthGFmijZmTtHiuNfLKLe2f0QRCGr68tctiL9TqMCV_GAy-lpxWBPsKnKtNW5e/exec";

    public String getEmailVerificationLink() {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
            String response = result.toString();
            int startIndex = response.indexOf("http");
            if(startIndex != -1) {
                return response.substring(startIndex);
            }
            return "Link bulunamadı.";

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Step("Verify email")
    public static void openLinkInBrowser() throws InterruptedException {
        MailVerifications mv = new MailVerifications();
        String verificationLink = mv.getEmailVerificationLink();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(verificationLink);
        Thread.sleep(5000);
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        openLinkInBrowser();
    }
}