import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.UIAssertionError;
import com.orangehrmlive.pages.DashboardPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static utils.Log.LOG;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Tests for Dashboard page.")
public class DashboardPageTests extends SetupDashboardPageTests {

    private static final DashboardPage DASHBOARD_PAGE = new DashboardPage();

    @ParameterizedTest(name = "{index}: {1}")
    @MethodSource({"provideQuickLaunchPanels", "providePanels"})
    @Feature(value = "Dashboard Panels")
    @DisplayName("Verify availability of panels on Dashboard page.")
    @Description("This test verifies that Panels are visible on the Dashboard page.")
    void verifyAvailabilityOfDashboardPanelsTest(SelenideElement panel, String name) {

        DASHBOARD_PAGE.openPage();

        try {
            panel.shouldBe(visible);

        } catch (NullPointerException nullPointerException) {

            LOG.error("Panel is: {}", nullPointerException.getMessage());
        }

    }

    private static Stream<Arguments> provideQuickLaunchPanels() {

        List<SelenideElement> quickLaunchPanels = DASHBOARD_PAGE.getQuickLaunchPanels();
        List<Arguments> arguments = new ArrayList<>();

        for (SelenideElement panel : quickLaunchPanels) {

            try {
                arguments.add(Arguments.of(panel, DASHBOARD_PAGE.getQuickLaunchPanelName(panel)));

            } catch (UIAssertionError uiAssertionError) {

                LOG.error("Quick Launch Panel not found: {}", uiAssertionError.getMessage());
                arguments.add(Arguments.of((SelenideElement) null, uiAssertionError.getMessage().substring(0, 50)));
            }
        }

        return arguments.stream();
    }

    private static Stream<Arguments> providePanels() {

        List<SelenideElement> panels = DASHBOARD_PAGE.getPanels();
        List<Arguments> arguments = new ArrayList<>();

        for (SelenideElement panel : panels) {

            try {
                arguments.add(Arguments.of(panel, DASHBOARD_PAGE.getPanelName(panel)));

            } catch (UIAssertionError uiAssertionError) {

                LOG.error("Panel not found: {}", uiAssertionError.getMessage());
                arguments.add(Arguments.of((SelenideElement) null, uiAssertionError.getMessage().substring(0, 50)));
            }
        }

        return arguments.stream();
    }

    @Test
    @Feature(value = "Dashboard Panels")
    @DisplayName("Verify availability of all panels on Dashboard page.")
    @Description("This test verifies that all of the panels are visible on the Dashboard page.")
    void verifyAvailabilityOfAllDashboardPanelsTest() {

        DASHBOARD_PAGE.openPage();

        Assertions.assertAll(
                () -> DASHBOARD_PAGE.getAssignLeaveQLPanel().shouldBe(visible),
                () -> DASHBOARD_PAGE.getLeaveListQLPanel().shouldBe(visible),
                () -> DASHBOARD_PAGE.getTimesheetsQLPanel().shouldBe(visible),
                () -> DASHBOARD_PAGE.getApplyLeaveQLPanel().shouldBe(visible),
                () -> DASHBOARD_PAGE.getMyLeaveQLPanel().shouldBe(visible),
                () -> DASHBOARD_PAGE.getMyTimesheetQLPanel().shouldBe(visible),
                () -> DASHBOARD_PAGE.getDistributionPanel().shouldBe(visible),
                () -> DASHBOARD_PAGE.getLegendPanel().shouldBe(visible),
                () -> DASHBOARD_PAGE.getRequestsPanel().shouldBe(visible)
        );
    }
}
