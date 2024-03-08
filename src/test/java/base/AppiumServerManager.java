package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppiumServerManager {

    private static final String APPIUM_COMMAND = "cmd /c start appium --address 127.0.0.1 --port 4723 --allow-cors ";
    private static final String KILL_NODE_COMMAND = "taskkill /f /im node.exe";

    public static void startAppiumServer() {
        if (!isAppiumServerRunning()) {
            try {
                Runtime.getRuntime().exec(APPIUM_COMMAND);
                Thread.sleep(5000);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void stopAppiumServer() {
        try {
            Runtime.getRuntime().exec(KILL_NODE_COMMAND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isAppiumServerRunning() {
        boolean isRunning = false;
        try {
            Process process = Runtime.getRuntime().exec("tasklist /fi \"imagename eq node.exe\"");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("node.exe")) {
                    isRunning = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isRunning;
    }
}
