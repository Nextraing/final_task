package com.orangehrmlive.pages;

import com.orangehrmlive.elements.LeaveListSearchForm;
import com.orangehrmlive.elements.SearchResultTable;
import io.qameta.allure.Step;
import utils.PropertiesLoader;

import static com.codeborne.selenide.Selenide.open;
import static utils.Log.LOG;

public class LeaveListPage {

    private final PropertiesLoader propertiesLoader = new PropertiesLoader();
    private final LeaveListSearchForm leaveListSearchForm = new LeaveListSearchForm();
    private final SearchResultTable searchResultTable = new SearchResultTable();

    public String getUrl() {

        return propertiesLoader.getViewLeaveListPageProperty();
    }

    @Step("Open Leave List page.")
    public void openPage() {

        LOG.info("Open {} page.", getUrl());
        open(getUrl());
    }

    @Step("Fill From date field: {date}.")
    public void fillFromDateField(String date) {

        LOG.info("Fill From date field: {}.", date);
        leaveListSearchForm.getFromDateField().setValue(date).pressEnter();
    }

    @Step("Fill To date field: {date}.")
    public void fillToDateField(String date) {

        LOG.info("Fill To date field: {}.", date);
        leaveListSearchForm.getToDateField().setValue(date).pressEnter();
    }

    @Step("Select 'All' check leave status.")
    public void selectAllCheckLeaveStatus() {

        LOG.info("Select 'All' check leave status.");
        leaveListSearchForm.getAllCheckLeaveStatus().click();
    }

    @Step("Click on Search button.")
    public void clickOnSearchButton() {

        LOG.info("Click on Search button.");
        leaveListSearchForm.getSearchButton().click();
    }

    @Step("Check if the employee name '{name}' and dates is on the list.")
    public boolean isEmployeeNameAndDatesInList(String name, String fromDate, String toDate) {

        LOG.info("Check if the employee '{}' with dates '{} - {}' is on the list.", name, fromDate, toDate);

        boolean isNameInList = false;
        boolean isDateMatch = false;

        for (int i = 0; i < searchResultTable.getResultsSize(); i++) {

            isNameInList = searchResultTable.getSearchResults()
                    .get(i)
                    .$(" td[class='left']:nth-child(2) a")
                    .getText()
                    .equals(name);

            isDateMatch = searchResultTable.getSearchResults()
                    .get(i)
                    .$(" td[class='left']:nth-child(1) a")
                    .getText()
                    .equals(fromDate + " to " + toDate);

            if (isNameInList & isDateMatch) {
                break;
            }
        }

        LOG.info("Is employee on the list: {}", (isNameInList & isDateMatch));
        return (isNameInList & isDateMatch);
    }
}
