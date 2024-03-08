package base;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

public class Swipe {
    private final AppiumDriver driver;
    private final PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

    public Swipe(AppiumDriver driver) {
        this.driver = driver;
    }

    public void swipe(SwipeDirection direction) {
        WebElement ele = getWebElement(direction);
        int[] start = getStartPoint(ele, direction);
        int[] end = getEndPoint(ele, direction);

        Sequence dragNDrop = new Sequence(finger, 1);
        dragNDrop.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), start[0], start[1]));
        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), end[0], end[1]));
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(dragNDrop));
    }

    private WebElement getWebElement(SwipeDirection direction) {
        if (driver instanceof AndroidDriver) {
            return driver.findElement(AppiumBy.xpath("ANDROID_GEN_LOCATOR"));
        } else if (driver instanceof IOSDriver && (direction == SwipeDirection.SWIPE_RIGHT || direction == SwipeDirection.SWIPE_LEFT)) {
            return driver.findElement(AppiumBy.xpath("IOS_GEN_LOCATOR_02"));
        } else {
            return driver.findElement(AppiumBy.accessibilityId("IOS_GEN_LOCATOR"));
        }
    }

    private int[] getStartPoint(WebElement ele, SwipeDirection direction) {
        int x = ele.getRect().x + (ele.getSize().width / 2);
        int y = (direction == SwipeDirection.SWIPE_DOWN || direction == SwipeDirection.SWIPE_UP) ? ele.getRect().y + (ele.getSize().height * 3 / 4) : ele.getRect().y + (ele.getSize().height / 2);
        return new int[]{x, y};
    }

    private int[] getEndPoint(WebElement ele, SwipeDirection direction) {
        int x = ele.getRect().x + (ele.getSize().width / 2);
        int y = (direction == SwipeDirection.SWIPE_DOWN) ? ele.getRect().y + (ele.getSize().height * 3 / 4) : ele.getRect().y + (ele.getSize().height / 4);
        return new int[]{x, y};
    }

    public enum SwipeDirection {
        SWIPE_RIGHT,
        SWIPE_LEFT,
        SWIPE_DOWN,
        SWIPE_UP
    }
}
