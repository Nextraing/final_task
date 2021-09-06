package utils;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

import static utils.Log.LOG;

public class DriverConfiguration {

    private static final RandomChoice RANDOM_CHOICE = new RandomChoice();

    public static void getChromeConfiguration() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-features=VizDisplayCompositor");
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    public static void getOperaConfiguration() {

        Configuration.browser = "opera";
        Configuration.startMaximized = true;
    }

    public static void getFirefoxConfiguration() {

        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
    }

    public static void getAnyConfiguration() {

        switch (RANDOM_CHOICE.getNumber(1, 3)) {
            default:
            case 1:
                LOG.info("Start with Chrome browser.");
                getChromeConfiguration();
                break;
            case 2:
                LOG.info("Start with FireFox browser.");
                getFirefoxConfiguration();
                break;
            case 3:
                LOG.info("Start with Opera browser.");
                getOperaConfiguration();
                break;
        }
    }
}
