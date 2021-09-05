package com.orangehrmlive.pages;

import com.codeborne.selenide.Condition;
import com.orangehrmlive.elements.AssignLeaveForm;
import io.qameta.allure.Step;
import utils.PropertiesLoader;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.Log.LOG;

public class AssignLeavePage {

    private final PropertiesLoader propertiesLoader = new PropertiesLoader();
    private final AssignLeaveForm assignLeaveForm = new AssignLeaveForm();

    public String getUrl() {

        return propertiesLoader.getAssignLeavePageProperty();
    }

    @Step("Open Assign Leave page.")
    public void openPage() {

        LOG.info("Open {} page.", getUrl());
        open(getUrl());
    }

    @Step("Fill employee name '{name}'.")
    public void fillEmployeeName(String name) {

        LOG.info("Fill employee name {}.", name);
        assignLeaveForm.getEmployeeNameField().setValue(name);
    }

    @Step("Fill leave type '{type}'.")
    public void fillLeaveType(String type) {

        LOG.info("Fill leave type {}.", type);
        assignLeaveForm.getLeaveTypeDropBox().selectOptionByValue(type);
    }

    @Step("Fill from date leave: {date}.")
    public void fillFromDateLeave(String date) {

        LOG.info("Fill from date leave: {}.", date);
        assignLeaveForm.getFromDateField().setValue(date).pressEnter();
    }

    @Step("Fill to date leave: {date}.")
    public void fillToDateLeave(String date) {

        LOG.info("Fill to date leave: {}.", date);
        assignLeaveForm.getToDateField().setValue(date).pressEnter();
    }

    @Step("Fill comment.")
    public void fillComment(String comment) {

        LOG.info("Fill comment: {}.", comment);
        assignLeaveForm.getCommentField().setValue(comment);
    }

    @Step("Click Assign button.")
    public void clickAssignButton() {

        LOG.info("Click Assign button.");
        assignLeaveForm.getAssignButton().click();
    }

    @Step("Confirm Leave Assignment.")
    public void confirmLeaveAssignment() {

        LOG.info("Confirm Leave Assignment.");
        $("#confirmOkButton").shouldBe(Condition.visible).click();
    }
}
