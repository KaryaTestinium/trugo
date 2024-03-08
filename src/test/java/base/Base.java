package base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.ExecutionContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


public class Base extends AppiumServerManager {
    public static AppiumDriver driver;
    Logger logger = Logger.getLogger(String.valueOf(Base.class));


    @BeforeScenario

    public void beforeScenario(ExecutionContext context) throws IOException {
        startAppiumServer();
        Faker faker = new Faker();

        Faker generator = new Faker();
        generator.generateUserCSV();
        logger.info("------------------------------------- New User Information Generated -------------------------------------------");

        logger.info("------------------------------------- Scenario is starting -------------------------------------------");

        var capabilities = getDesiredCapabilities();

        URI appiumServerURI = URI.create("http://127.0.0.1:4723");
        URL appiumServerURL = appiumServerURI.toURL();
        System.out.println(capabilities);
        driver = new AndroidDriver(appiumServerURL, capabilities);
    }

    private static DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //otomatik olarak device name ve platform version alınacak
        try {
            File xmlFile = new File("deviceProperties/S23.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("capability");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String name = element.getAttribute("name");
                String value = element.getTextContent().trim();

                capabilities.setCapability(name, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return capabilities;
    }


    @AfterScenario
    public void afterScenario(){
        logger.info("------------------------------------- Scenario is ending -------------------------------------------");
//        stopAppiumServer();
        driver.quit();
    }
}
