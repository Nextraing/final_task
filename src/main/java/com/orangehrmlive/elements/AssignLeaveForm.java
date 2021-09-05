package com.orangehrmlive.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AssignLeaveForm {

    private final SelenideElement employeeNameField = $("#assignleave_txtEmployee_empName");
    private final SelenideElement leaveTypeDropBox = $("#assignleave_txtLeaveType");
    private final SelenideElement leaveBalanceField = $("#assignleave_leaveBalance");
    private final SelenideElement fromDateField = $("#assignleave_txtFromDate");
    private final SelenideElement toDateField = $("#assignleave_txtToDate");
    private final SelenideElement commentField = $("#assignleave_txtComment");
    private final SelenideElement assignButton = $("#assignBtn");

    public SelenideElement getEmployeeNameField() {

        return employeeNameField;
    }

    public SelenideElement getLeaveTypeDropBox() {

        return leaveTypeDropBox;
    }

    public SelenideElement getLeaveBalanceField() {

        return leaveBalanceField;
    }

    public SelenideElement getFromDateField() {

        return fromDateField;
    }

    public SelenideElement getToDateField() {

        return toDateField;
    }

    public SelenideElement getCommentField() {

        return commentField;
    }

    public SelenideElement getAssignButton() {

        return assignButton;
    }
}
