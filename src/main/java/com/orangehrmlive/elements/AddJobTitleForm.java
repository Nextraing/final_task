package com.orangehrmlive.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AddJobTitleForm {

    private final SelenideElement jobTitleField = $("#jobTitle_jobTitle");
    private final SelenideElement jobDescriptionField = $("#jobTitle_jobDescription");
    private final SelenideElement jobSpecificationField = $("#jobTitle_jobSpec");
    private final SelenideElement noteField = $("#jobTitle_note");
    private final SelenideElement saveButton = $("#btnSave");
    private final SelenideElement cancelButton = $("#btnCancel");

    public SelenideElement getJobTitleField() {

        return jobTitleField;
    }

    public SelenideElement getJobDescriptionField() {

        return jobDescriptionField;
    }

    public SelenideElement getJobSpecificationField() {

        return jobSpecificationField;
    }

    public SelenideElement getNoteField() {

        return noteField;
    }

    public SelenideElement getSaveButton() {

        return saveButton;
    }

    public SelenideElement getCancelButton() {

        return cancelButton;
    }

    public void addJobTitle(String title) {

        getJobTitleField().sendKeys(title);
    }

    public void addJobDescription(String description) {

        getJobDescriptionField().sendKeys(description);
    }

    public void addJobSpecification(String specification) {

        getJobSpecificationField().setValue(specification);
    }

    public void addNote(String note) {

        getNoteField().sendKeys(note);
    }

    public void clickSaveButton() {

        getSaveButton().click();
    }
}
