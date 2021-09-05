import com.orangehrmlive.elements.BrandingElement;
import com.orangehrmlive.pages.DashboardPage;
import com.orangehrmlive.pages.LoginPage;
import org.junit.jupiter.api.*;
import users.User;
import utils.DriverConfiguration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static utils.Log.LOG;

public class SetupDashboardPageTests {

    private static final DashboardPage DASHBOARD_PAGE = new DashboardPage();
    private static final LoginPage LOGIN_PAGE = new LoginPage();
    private static final BrandingElement BRANDING_ELEMENT = new BrandingElement();
    private static final User USER = new User();

    @BeforeAll
    static void beforeAll() {

        LOG.info("----------Tests for Dashboard page.----------");
        DriverConfiguration.getOperaConfiguration();
        open();
        LOGIN_PAGE.openPage();
        LOGIN_PAGE.login(USER);

        webdriver().shouldHave(url(DASHBOARD_PAGE.getUrl()));
    }

    @BeforeEach
    void setUp(TestInfo testInfo) {

        LOG.info("_____ Start of '{}' test. _____", testInfo.getDisplayName());
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {

        LOG.info("_____ Finish of '{}' test. _____", testInfo.getDisplayName());
    }

    @AfterAll
    static void afterAll() {

        BRANDING_ELEMENT.logout();
        webdriver().shouldHave(url(LOGIN_PAGE.getUrl()));
        LOG.info("----------End of tests for Dashboard page.----------");
    }
}
