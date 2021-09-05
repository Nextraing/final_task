import com.orangehrmlive.elements.BrandingElement;
import com.orangehrmlive.pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import users.Candidate;
import users.User;

import java.io.File;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Tests for https://opensource-demo.orangehrmlive.com")
public class OrangeHRMliveTests extends SetupOrangeHRMliveTests {

    private final User user = new User();
    private final Candidate candidate = new Candidate();

    private final LoginPage loginPage = new LoginPage();
    private final AdminPage adminPage = new AdminPage();
    private final JobTitlesPage jobTitlesPage = new JobTitlesPage();
    private final AssignLeavePage assignLeavePage = new AssignLeavePage();
    private final LeaveListPage leaveListPage = new LeaveListPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final RecruitmentPage recruitmentPage = new RecruitmentPage();
    private final PIMPage pimPage = new PIMPage();
    private final BrandingElement brandingElement = new BrandingElement();

    @Test
    @Order(1)
    @Feature(value = "Login")
    @DisplayName("Login")
    @Description("This test verifies that User can login the site.")
    void loginTest() {

        loginPage.openPage();
        loginPage.login(user);

        webdriver().shouldHave(url(dashboardPage.getUrl()));
    }

    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(strings = {"AQA Engineer", "Super AQA Engineer", "Extraterrestrial AQA Engineer"})
    @Order(2)
    @Feature(value = "Job Title")
    @DisplayName("Add three Job Titles")
    @Description("This test verifies that User can add three Job Titles.")
    void addThreeJobTitlesTest(String jobTitle) {

        String jobDescription = "Using automated testing tools to run tests " +
                "on the software being developed and report on the results.";

        jobTitlesPage.openPage();
        jobTitlesPage.clickAddButton();
        jobTitlesPage.fillJobTitle(jobTitle);
        jobTitlesPage.fillJobDescription(jobDescription);
        jobTitlesPage.fillJobSpecification(new File("src/main/resources/specification.txt").getAbsolutePath());
        jobTitlesPage.fillNote("Note");
        jobTitlesPage.clickSaveButton();

        assertTrue(jobTitlesPage.isJobTitleAndDescriptionInList(jobTitle, jobDescription),
                "Job Title is not added or something wrong with the data.");
    }

    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(strings = {"AQA Engineer", "Super AQA Engineer", "Extraterrestrial AQA Engineer"})
    @Order(3)
    @Feature(value = "Job Title")
    @DisplayName("Delete three Job Titles")
    @Description("This test verifies that User can delete three Job Titles.")
    void deleteThreeJobTitlesTest(String jobTitle) {

        String jobDescription = "Using automated testing tools to run tests " +
                "on the software being developed and report on the results.";

        jobTitlesPage.openPage();
        jobTitlesPage.deleteJobTitle(jobTitle, jobDescription);

        assertFalse(jobTitlesPage.isJobTitleAndDescriptionInList(jobTitle, jobDescription),
                "Job Title is not deleted or something wrong with the data.");
    }

    @Test
    @Order(4)
    @Feature(value = "User")
    @DisplayName("Add user")
    @Description("This test verifies the ability to add a user.")
    void addUserTest() {

        String employeeName = "Jordan Mathews";
        String username = "BossJr";

        adminPage.openPage();
        adminPage.clickAddButton();
        adminPage.selectUserRole("2");
        adminPage.fillEmployeeName(employeeName);
        adminPage.fillUserName(username);
        adminPage.selectStatus("1");
        adminPage.fillPassword("JsOwReDhAtNaM!211");
        adminPage.fillConfirmPassword("JsOwReDhAtNaM!211");
        adminPage.clickSaveButton();
        adminPage.openPage();
        adminPage.fillEmployeeNameToSearchForm(employeeName);
        adminPage.clickSearchButton();

        assertTrue(adminPage.isUserWithEmployeeNameInList(username, employeeName),
                "Username has already exist or something wrong with the data.");
    }

    @Test
    @Order(5)
    @Feature(value = "User")
    @DisplayName("Delete user")
    @Description("This test verifies the ability to delete a user.")
    void deleteUserTest() {

        String employeeName = "Jordan Mathews";
        String username = "BossJr";

        adminPage.openPage();
        adminPage.fillUsernameToSearchForm(username);
        adminPage.clickSearchButton();
        adminPage.deleteUser(username, employeeName);

        assertFalse(adminPage.isUserWithEmployeeNameInList(username, employeeName),
                "No such username on the list or something wrong with the data.");
    }

    @ParameterizedTest(name = "{index}: {0}")
    @CsvFileSource(resources = "/assignLeaveData.csv", numLinesToSkip = 1)
    @Order(6)
    @Feature(value = "Leave")
    @DisplayName("Add assign leave")
    @Description("This test verifies that Employee can assign leave.")
    void addAssignLeaveTest(ArgumentsAccessor arguments) {

        assignLeavePage.openPage();
        assignLeavePage.fillEmployeeName(arguments.getString(0));
        assignLeavePage.fillLeaveType(arguments.getString(1));
        assignLeavePage.fillFromDateLeave(arguments.getString(2));
        assignLeavePage.fillToDateLeave(arguments.getString(3));
        assignLeavePage.fillComment(arguments.getString(4));
        assignLeavePage.clickAssignButton();
        assignLeavePage.confirmLeaveAssignment();

        leaveListPage.openPage();
        leaveListPage.fillFromDateField(arguments.getString(2));
        leaveListPage.fillToDateField(arguments.getString(3));
        leaveListPage.selectAllCheckLeaveStatus();
        leaveListPage.clickOnSearchButton();

        assertTrue(leaveListPage.isEmployeeNameAndDatesInList(arguments.getString(0),
                arguments.getString(2), arguments.getString(3)),
                "The leave was not assigned or something wrong with the data.");
    }

    @Test
    @Order(6)
    @Feature(value = "Recruitment")
    @DisplayName("Add candidate")
    @Description("This test verifies that User can add new candidate.")
    void addCandidateTest() {

        recruitmentPage.openPage();
        recruitmentPage.clickAddButton();
        recruitmentPage.fillAddCandidateForm(candidate);
        recruitmentPage.fillAnyJobVacancy();
        recruitmentPage.fillKeywords(candidate.getFirstName() + "," + candidate.getLastName());
        recruitmentPage.fillComment("Comment");
        recruitmentPage.fillApplicationDate();
        recruitmentPage.consentToKeepData();
        recruitmentPage.save();

        recruitmentPage.getBackButton().shouldBe(enabled);
    }

    @Test
    @Order(6)
    @Feature(value = "Recruitment")
    @DisplayName("Verify that date should be less than current date.")
    @Description("This test verifies that the date Error appears when Date of application is more than current.")
    void verifyDateTest() {

        recruitmentPage.openPage();
        recruitmentPage.clickAddButton();
        recruitmentPage.fillAnyApplicationDate();
        recruitmentPage.save();

        if (recruitmentPage.isDateLessOrEqualsThanCurrent(recruitmentPage.getApplicationDateFieldValue())) {

            recruitmentPage.getApplicationDateError().shouldNotBe(visible);

        } else {
            recruitmentPage.getApplicationDateError().shouldBe(visible);
        }
    }

    @Test
    @Order(6)
    @Feature(value = "PIM")
    @DisplayName("Verify that form details of any employee with Sub Unit 'Sales' are disabled.")
    @Description("This test verifies that form details of any employee with Sub Unit 'Sales' are disabled.")
    void verifyEmployeeDetailsTest() {

        pimPage.openPage();
        pimPage.clickSubUnitBox();
        pimPage.findAndClickOnSubUnit("Sales");
        pimPage.clickSearchButton();
        pimPage.clickOnAnyResultLine();

        pimPage.getAllPersonalDetails().forEach(detail -> detail.shouldBe(disabled));
    }

    @Test
    @Order(100)
    @Feature(value = "Logout")
    @DisplayName("Logout")
    @Description("This test verifies that User can logout the site.")
    void logoutTest() {

        brandingElement.logout();

        webdriver().shouldHave(url(loginPage.getUrl()));
    }
}
