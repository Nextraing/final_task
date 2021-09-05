package com.orangehrmlive.pages;

import com.codeborne.selenide.Condition;
import com.orangehrmlive.elements.AddJobTitleForm;
import com.orangehrmlive.elements.SearchResultTable;
import io.qameta.allure.Step;
import utils.PropertiesLoader;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.Log.LOG;

public class JobTitlesPage {

    private final PropertiesLoader propertiesLoader = new PropertiesLoader();
    private final SearchResultTable searchResultTable = new SearchResultTable();
    private final AddJobTitleForm addJobTitleForm = new AddJobTitleForm();

    private static String LINE_CHECKBOX_ID;

    public String getUrl() {

        return propertiesLoader.getViewJobTitleListPageProperty();
    }

    @Step("Open Job Titles page.")
    public void openPage() {

        LOG.info("Open {} page.", getUrl());
        open(getUrl());
    }

    @Step("Click Add button.")
    public void clickAddButton() {

        LOG.info("Click Add button.");
        searchResultTable.clickAddButton();
    }

    @Step("Click Delete button.")
    public void clickDeleteButton() {

        LOG.info("Click Delete button.");
        searchResultTable.clickDeleteButton();
    }

    @Step("Fill '{title}' into Job Title field.")
    public void fillJobTitle(String title) {

        LOG.info("Fill Job Title '{}'.", title);
        addJobTitleForm.addJobTitle(title);
    }

    @Step("Fill Job Description field.")
    public void fillJobDescription(String description) {

        LOG.info("Fill Job Description '{}'.", description);
        addJobTitleForm.addJobDescription(description);
    }

    @Step("Fill Job specification field.")
    public void fillJobSpecification(String specification) {

        LOG.info("Fill Job Specification '{}'.", specification);
        addJobTitleForm.addJobSpecification(specification);
    }

    @Step("Fill Note field.")
    public void fillNote(String note) {

        LOG.info("Fill Note field '{}'.", note);
        addJobTitleForm.addNote(note);
    }

    @Step("Click Save button.")
    public void clickSaveButton() {

        LOG.info("Click Save button.");
        addJobTitleForm.clickSaveButton();
    }

    @Step("Check if the Job Title '{title}' and Job Description are on the list.")
    public boolean isJobTitleAndDescriptionInList(String title, String description) {

        LOG.info("Check if the Job Title '{}' and Description '{}' are on the list.", title, description);

        boolean isTitleInList = false;
        boolean isDescriptionInList = false;

        for (int i = 0; i < searchResultTable.getResultsSize(); i++) {

            isTitleInList = searchResultTable.getSearchResults()
                    .get(i)
                    .$(" td[class='left']:nth-child(2) a")
                    .getText()
                    .equals(title);

            isDescriptionInList = searchResultTable.getSearchResults()
                    .get(i)
                    .$(" td[class='left']:nth-child(3)")
                    .getText()
                    .equals(description);

            if (isTitleInList & isDescriptionInList) {

                LINE_CHECKBOX_ID = "#" + searchResultTable.getSearchResults()
                        .get(i)
                        .$(" td input")
                        .getAttribute("id");
                LOG.info("Job Title checkbox ID is: {}. ", LINE_CHECKBOX_ID);
                break;
            }
        }

        LOG.info("Are Job Title and Job Description on the list: {}", (isTitleInList & isDescriptionInList));
        return (isTitleInList & isDescriptionInList);
    }

    @Step("Delete Job Title '{jobTitle}'.")
    public void deleteJobTitle(String jobTitle, String description) {

        if (isJobTitleAndDescriptionInList(jobTitle, description)) {

            $(LINE_CHECKBOX_ID).click();
            clickDeleteButton();
            confirmJobTitleDeletion();
        }
    }

    @Step("Confirm Job Title Deletion.")
    public void confirmJobTitleDeletion() {

        LOG.info("Confirm Job Title deletion.");
        $("#dialogDeleteBtn").shouldBe(Condition.visible).click();
    }
}
