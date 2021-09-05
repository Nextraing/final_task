package com.orangehrmlive.pages;

import com.codeborne.selenide.ElementsCollection;
import com.orangehrmlive.elements.PersonalDetailsForm;
import com.orangehrmlive.elements.SearchForm;
import com.orangehrmlive.elements.SearchResultTable;
import io.qameta.allure.Step;
import utils.PropertiesLoader;
import utils.RandomChoice;

import static com.codeborne.selenide.Selenide.open;
import static utils.Log.LOG;

public class PIMPage {

    private final PropertiesLoader propertiesLoader = new PropertiesLoader();
    private final SearchForm searchForm = new SearchForm();
    private final SearchResultTable searchResultTable = new SearchResultTable();
    private final PersonalDetailsForm personalDetailsForm = new PersonalDetailsForm();
    private final RandomChoice randomChoice = new RandomChoice();

    public String getUrl() {

        return propertiesLoader.getPIMPageProperty();
    }

    @Step("Open PIM page.")
    public void openPage() {

        LOG.info("Open {} page.", getUrl());
        open(getUrl());
    }

    @Step("Click on Sub Unit dropbox.")
    public void clickSubUnitBox() {

        LOG.info("Click on Sub Unit dropbox.");
        searchForm.clickSubUnitBox();
    }

    @Step("Click on Search button.")
    public void clickSearchButton() {

        LOG.info("Click on Search button.");
        searchForm.clickSearchButton();
    }

    @Step("Find and click on Sub Unit '{subUnitName}'.")
    public void findAndClickOnSubUnit(String subUnitName) {

        LOG.info("Find and click on Sub Unit '{}'.", subUnitName);
        try {
            searchForm.getSubUnitCollection()
                    .stream()
                    .filter(subUnit -> subUnit.getText().trim().toLowerCase().equals(subUnitName.toLowerCase()))
                    .findAny()
                    .orElseThrow(() -> new Exception("SubUnit not found: " + subUnitName))
                    .click();

        } catch (Exception e) {

            LOG.error("{}", e.getMessage());
        }
    }

    @Step("Click on any result line.")
    public void clickOnAnyResultLine() {

        searchResultTable.clickOnResultLine(randomChoice.getNumber(0, searchResultTable.getResultsSize() - 1));
    }

    @Step("Get all personal details.")
    public ElementsCollection getAllPersonalDetails() {

        LOG.info("Get all personal details.");
        return personalDetailsForm.getPersonalDetails();
    }
}
