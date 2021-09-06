import org.junit.jupiter.api.*;
import utils.DriverConfiguration;

import static com.codeborne.selenide.Selenide.open;
import static utils.Log.LOG;

public class SetupOrangeHRMliveTests {

    @BeforeAll
    static void beforeAll() {

        LOG.info("--------------------------------------------------");
        DriverConfiguration.getAnyConfiguration();
        open();
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

        LOG.info("--------------------------------------------------");
    }

}
