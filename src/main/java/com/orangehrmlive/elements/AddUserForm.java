package com.orangehrmlive.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AddUserForm {

    private final SelenideElement userRoleField = $("#systemUser_userType");
    private final SelenideElement employeeNameField = $("#systemUser_employeeName_empName");
    private final SelenideElement userNameField = $("#systemUser_userName");
    private final SelenideElement statusField = $("#systemUser_status");
    private final SelenideElement passwordField = $("#systemUser_password");
    private final SelenideElement confirmPasswordField = $("#systemUser_confirmPassword");
    private final SelenideElement saveButton = $("#btnSave");
    private final SelenideElement cancelButton = $("#btnCancel");

    public SelenideElement getUserRoleField() {

        return userRoleField;
    }

    public SelenideElement getEmployeeNameField() {

        return employeeNameField;
    }

    public SelenideElement getUserNameField() {

        return userNameField;
    }

    public SelenideElement getStatusField() {

        return statusField;
    }

    public SelenideElement getPasswordField() {

        return passwordField;
    }

    public SelenideElement getConfirmPasswordField() {

        return confirmPasswordField;
    }

    public SelenideElement getSaveButton() {

        return saveButton;
    }

    public SelenideElement getCancelButton() {

        return cancelButton;
    }

    public void selectUserRole(String roleValue) {

        getUserRoleField().selectOptionByValue(roleValue);
    }

    public void addEmployeeName(String name) {

        getEmployeeNameField().setValue(name).pressTab();
    }

    public void addUserName(String username) {

        getUserNameField().sendKeys(username);
    }

    public void selectStatus(String statusValue) {

        getStatusField().selectOptionByValue(statusValue);
    }

    public void addPassword(String password) {

        getPasswordField().sendKeys(password);
    }

    public void addConfirmPassword(String password) {

        getConfirmPasswordField().sendKeys(password);
    }

    public void clickSaveButton() {

        getSaveButton().click();
    }
}
