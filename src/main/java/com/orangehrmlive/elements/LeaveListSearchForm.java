package com.orangehrmlive.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LeaveListSearchForm {

    private final SelenideElement fromDateField = $("#calFromDate");
    private final SelenideElement toDateField = $("#calToDate");
    private final SelenideElement allCheckLeaveStatus = $("#leaveList_chkSearchFilter_checkboxgroup_allcheck");
    private final SelenideElement searchButton = $("#btnSearch");

    public SelenideElement getFromDateField() {

        return fromDateField;
    }

    public SelenideElement getToDateField() {

        return toDateField;
    }

    public SelenideElement getAllCheckLeaveStatus() {

        return allCheckLeaveStatus;
    }

    public SelenideElement getSearchButton() {

        return searchButton;
    }
}
