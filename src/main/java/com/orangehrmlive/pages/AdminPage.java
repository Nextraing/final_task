package com.orangehrmlive.pages;

import com.codeborne.selenide.Condition;
import com.orangehrmlive.elements.AddUserForm;
import com.orangehrmlive.elements.SearchForm;
import com.orangehrmlive.elements.SearchResultTable;
import io.qameta.allure.Step;
import utils.PropertiesLoader;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.Log.LOG;

public class AdminPage {

    private final PropertiesLoader propertiesLoader = new PropertiesLoader();
    private final SearchForm searchForm = new SearchForm();
    private final SearchResultTable searchResultTable = new SearchResultTable();
    private final AddUserForm addUserForm = new AddUserForm();

    private static String LINE_CHECKBOX_ID;

    public String getUrl() {

        return propertiesLoader.getAdminPageProperty();
    }

    @Step("Open Admin page.")
    public void openPage() {

        LOG.info("Open {} page.", getUrl());
        open(getUrl());
    }

    @Step("Click Add button")
    public void clickAddButton() {

        LOG.info("Click Add button.");
        searchResultTable.clickAddButton();
    }

    @Step("Select User role '{roleValue}'")
    public void selectUserRole(String roleValue) {

        LOG.info("Select User role '{}'.", roleValue);
        addUserForm.selectUserRole(roleValue);
    }

    @Step("Fill Employee name '{name}'.")
    public void fillEmployeeName(String name) {

        LOG.info("Fill Employee name '{}'.", name);
        addUserForm.addEmployeeName(name);
    }

    @Step("Fill Username '{username}'.")
    public void fillUserName(String username) {

        LOG.info("Fill Username '{}'.", username);
        addUserForm.addUserName(username);
    }

    @Step("Select Status '{statusValue}'.")
    public void selectStatus(String statusValue) {

        LOG.info("Select Status '{}'.", statusValue);
        addUserForm.selectStatus(statusValue);
    }

    @Step("Fill password '{password}'.")
    public void fillPassword(String password) {

        LOG.info("Fill password '{}'.", password);
        addUserForm.addPassword(password);
    }

    @Step("Fill confirm password '{password}'.")
    public void fillConfirmPassword(String password) {

        LOG.info("Fill confirm password '{}'.", password);
        addUserForm.addConfirmPassword(password);
    }

    @Step("Click Save button.")
    public void clickSaveButton() {

        LOG.info("Click Save button.");
        addUserForm.clickSaveButton();
    }

    @Step("Check if the User '{username}' with employee name '{employeeName}' is on the list.")
    public boolean isUserWithEmployeeNameInList(String username, String employeeName) {

        LOG.info("Check if the User '{}' with employee name '{}' is on the list.", username, employeeName);

        boolean isUsernameInList = false;
        boolean isEmployeeNameInList = false;

        for (int i = 0; i < searchResultTable.getResultsSize(); i++) {

            isUsernameInList = searchResultTable.getSearchResults()
                    .get(i)
                    .$(" td[class='left']:nth-child(2) a")
                    .getText()
                    .equals(username);

            isEmployeeNameInList = searchResultTable.getSearchResults()
                    .get(i)
                    .$(" td[class='left']:nth-child(4)")
                    .getText()
                    .equals(employeeName);

            if (isUsernameInList & isEmployeeNameInList) {

                LINE_CHECKBOX_ID = "#" + searchResultTable.getSearchResults()
                        .get(i)
                        .$(" td input")
                        .getAttribute("id");
                LOG.info("User checkbox ID is: {}. ", LINE_CHECKBOX_ID);
                break;
            }
        }

        LOG.info("Is the User on the list: {}", (isUsernameInList & isEmployeeNameInList));
        return (isUsernameInList & isEmployeeNameInList);
    }

    @Step("Fill Username '{name}' to search form.")
    public void fillUsernameToSearchForm(String name) {

        LOG.info("Fill Username '{}' to search form.", name);
        searchForm.getUsernameField().sendKeys(name);
    }

    @Step("Fill Employee name '{name}' to search form.")
    public void fillEmployeeNameToSearchForm(String name) {

        LOG.info("Fill Employee name '{}' to search form.", name);
        searchForm.getEmployeeNameField().sendKeys(name);
    }

    @Step("Delete User '{username}'.")
    public void deleteUser(String username, String employeeName) {

        if (isUserWithEmployeeNameInList(username, employeeName)) {

            $(LINE_CHECKBOX_ID).click();
            clickDeleteButton();
            confirmJobTitleDeletion();
        }
    }

    @Step("Click Delete button.")
    public void clickDeleteButton() {

        LOG.info("Click Delete button.");
        searchResultTable.getDeleteButton().click();
    }

    @Step("Confirm User deletion.")
    public void confirmJobTitleDeletion() {

        LOG.info("Confirm User deletion.");
        $("#dialogDeleteBtn").shouldBe(Condition.visible).click();
    }

    @Step("Click Search button")
    public void clickSearchButton() {

        LOG.info("Click Search button.");
        searchForm.clickSearchButton();
    }
}
