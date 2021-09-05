package com.orangehrmlive.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import users.Candidate;
import utils.RandomChoice;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static utils.Log.LOG;

public class AddCandidateForm {

    private final SelenideElement firstNameField = $("#addCandidate_firstName");
    private final SelenideElement middleNameField = $("#addCandidate_middleName");
    private final SelenideElement lastNameField = $("#addCandidate_lastName");
    private final SelenideElement emailField = $("#addCandidate_email");
    private final SelenideElement contactNoField = $("#addCandidate_contactNo");
    private final SelenideElement jobVacancyDrop = $("#addCandidate_vacancy");
    private final SelenideElement resumeInput = $("#addCandidate_resume");
    private final SelenideElement keywordsField = $("#addCandidate_keyWords");
    private final SelenideElement commentField = $("#addCandidate_comment");
    private final SelenideElement applicationDateField = $("#addCandidate_appliedDate");
    private final SelenideElement applicationDateError = $("span[for='addCandidate_appliedDate']");
    private final SelenideElement keepDataConsentCheckbox = $("#addCandidate_consentToKeepData");
    private final SelenideElement saveButton = $("#btnSave");
    private final SelenideElement backButton = $("#btnBack");

    private final ElementsCollection jobVacancyList = $$("#addCandidate_vacancy option:not([value=''])");

    private final DatePicker datePicker = new DatePicker();
    private final RandomChoice randomNumber = new RandomChoice();

    private static final LocalDate DATE_NOW = LocalDate.now();

    public void addCandidate(Candidate candidate) {

        firstNameField.setValue(candidate.getFirstName());
        middleNameField.setValue(candidate.getMiddleName());
        lastNameField.setValue(candidate.getLastName());
        emailField.setValue(candidate.getEmail());
        contactNoField.setValue(candidate.getContactNo());
        resumeInput.setValue(candidate.getResumePath());
    }

    public void addJobVacancy(String jobVacancyOptionValue) {

        jobVacancyDrop.selectOptionByValue(jobVacancyOptionValue);
    }

    public int getNumberOfJobVacancies() {

        return jobVacancyList.size();
    }

    public String getJobVacancyName(String jobVacancyOptionValue) {

        return jobVacancyList.find(Condition.value(jobVacancyOptionValue)).getText();
    }

    public void addKeywords(String keywords) {

        keywordsField.setValue(keywords);
    }

    public void addComment(String comment) {

        commentField.setValue(comment);
    }

    public void addApplicationDate() {

        applicationDateField.setValue(DATE_NOW.toString()).pressEnter();
    }

    public void addAnyApplicationDate() {

        applicationDateField.click();
        datePicker.pickMonth(randomNumber.getNumber(0, datePicker.getNumberOfMonths() - 1));
        datePicker.pickYear(randomNumber.getNumber(0, datePicker.getNumberOfYears() - 1));
        datePicker.pickDay(randomNumber.getNumber(0, datePicker.getNumberOfDays() - 1));
    }

    public void clickConsentToKeepData() {

        keepDataConsentCheckbox.click();
    }

    public void clickSaveButton() {

        saveButton.click();
    }

    public SelenideElement getBackButton() {

        return backButton;
    }

    public String getApplicationDateFieldValue() {

        LOG.info("Date of application: {}.", applicationDateField.getValue());
        return applicationDateField.getValue();
    }

    public LocalDate getDateNow() {

        return DATE_NOW;
    }

    public SelenideElement getApplicationDateError() {

        return applicationDateError;
    }
}
