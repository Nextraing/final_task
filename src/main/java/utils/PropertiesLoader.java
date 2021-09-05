package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static utils.Log.LOG;

public class PropertiesLoader {

    private final Properties properties = new Properties();

    private static final String LOGIN_PAGE_PROPERTY = "site.login";
    private static final String LOGOUT_PAGE_PROPERTY = "site.logout";
    private static final String MAIN_PAGE_PROPERTY = "site.address";
    private static final String ADMIN_PAGE_PROPERTY = "site.admin";
    private static final String VIEW_JOB_TITLE_LIST_PAGE_PROPERTY = "site.viewJobTitleList";
    private static final String PIM_PAGE_PROPERTY = "site.pim";
    private static final String DASHBOARD_PAGE_PROPERTY = "site.dashboard";
    private static final String RECRUITMENT_PAGE_PROPERTY = "site.recruitment";
    private static final String ASSIGN_LEAVE_PAGE_PROPERTY = "site.assignLeave";
    private static final String VIEW_LEAVE_LIST_PAGE_PROPERTY = "site.viewLeaveList";
    private static final String VIEW_LEAVE_MY_LIST_PAGE_PROPERTY = "site.viewMyLeaveList";
    private static final String APPLY_LEAVE_PAGE_PROPERTY = "site.applyLeave";
    private static final String VIEW_EMPLOYEE_TIMESHEET_PAGE_PROPERTY = "site.viewEmployeeTimesheet";
    private static final String VIEW_MY_TIMESHEET_PAGE_PROPERTY = "site.viewMyTimesheet";

    public String getMainPageProperty() {

        try {
            properties.load(new FileInputStream("./src/main/resources/properties/site.properties"));

        } catch (IOException ioException) {

            LOG.error("Problem with file: ", ioException);
        }

        return properties.getProperty(MAIN_PAGE_PROPERTY);
    }

    public String getLoginPageProperty() {

        return getMainPageProperty() + properties.getProperty(LOGIN_PAGE_PROPERTY);
    }

    public String getLogoutProperty() {

        getMainPageProperty();

        return properties.getProperty(LOGOUT_PAGE_PROPERTY);
    }

    public String getAdminPageProperty() {

        return getMainPageProperty() + properties.getProperty(ADMIN_PAGE_PROPERTY);
    }

    public String getViewJobTitleListPageProperty() {

        return getMainPageProperty() + properties.getProperty(VIEW_JOB_TITLE_LIST_PAGE_PROPERTY);
    }

    public String getAssignLeavePageProperty() {

        return getMainPageProperty() + properties.getProperty(ASSIGN_LEAVE_PAGE_PROPERTY);
    }

    public String getAssignLeaveProperty() {

        getMainPageProperty();

        return properties.getProperty(ASSIGN_LEAVE_PAGE_PROPERTY);
    }

    public String getViewLeaveListPageProperty() {

        return getMainPageProperty() + properties.getProperty(VIEW_LEAVE_LIST_PAGE_PROPERTY);
    }

    public String getViewLeaveListProperty() {

        getMainPageProperty();

        return properties.getProperty(VIEW_LEAVE_LIST_PAGE_PROPERTY);
    }

    public String getViewMyLeaveListProperty() {

        getMainPageProperty();

        return properties.getProperty(VIEW_LEAVE_MY_LIST_PAGE_PROPERTY);
    }

    public String getApplyLeaveProperty() {

        getMainPageProperty();

        return properties.getProperty(APPLY_LEAVE_PAGE_PROPERTY);
    }

    public String getViewEmployeeTimesheetProperty() {

        getMainPageProperty();

        return properties.getProperty(VIEW_EMPLOYEE_TIMESHEET_PAGE_PROPERTY);
    }

    public String getMyEmployeeTimesheetProperty() {

        getMainPageProperty();

        return properties.getProperty(VIEW_MY_TIMESHEET_PAGE_PROPERTY);
    }

    public String getPIMPageProperty() {

        return getMainPageProperty() + properties.getProperty(PIM_PAGE_PROPERTY);
    }

    public String getDashboardPageProperty() {

        return getMainPageProperty() + properties.getProperty(DASHBOARD_PAGE_PROPERTY);
    }

    public String getRecruitmentPageProperty() {

        return getMainPageProperty() + properties.getProperty(RECRUITMENT_PAGE_PROPERTY);
    }


    public String getUserProperty(String propertyName) {

        try {
            properties.load(new FileInputStream("./src/main/resources/properties/user.properties"));

        } catch (IOException ioException) {

            LOG.error("Problem with file: ", ioException);
        }

        return properties.getProperty(propertyName);
    }

    public String getCandidateProperty(String propertyName) {

        try {
            properties.load(new FileInputStream("./src/main/resources/properties/candidate.properties"));

        } catch (IOException ioException) {

            LOG.error("Problem with file: ", ioException);
        }

        return properties.getProperty(propertyName);
    }
}
