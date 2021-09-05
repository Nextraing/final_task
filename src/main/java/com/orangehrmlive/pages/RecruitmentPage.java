package com.orangehrmlive.pages;

import com.codeborne.selenide.SelenideElement;
import com.orangehrmlive.elements.AddCandidateForm;
import com.orangehrmlive.elements.SearchResultTable;
import io.qameta.allure.Step;
import users.Candidate;
import utils.PropertiesLoader;
import utils.RandomChoice;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.open;
import static utils.Log.LOG;

public class RecruitmentPage {

    private final PropertiesLoader propertiesLoader = new PropertiesLoader();
    private final SearchResultTable searchResultTable = new SearchResultTable();
    private final AddCandidateForm addCandidateForm = new AddCandidateForm();
    private final RandomChoice randomNumber = new RandomChoice();

    public String getUrl() {

        return propertiesLoader.getRecruitmentPageProperty();
    }

    @Step("Open Recruitment page.")
    public void openPage() {

        LOG.info("Open {} page.", getUrl());
        open(getUrl());
    }

    @Step("Click Add button.")
    public void clickAddButton() {

        searchResultTable.clickAddButton();
    }

    @Step("Fill candidate's data to form.")
    public void fillAddCandidateForm(Candidate candidate) {

        LOG.info("Fill '{} {}' candidate to form.", candidate.getFirstName(), candidate.getLastName());
        addCandidateForm.addCandidate(candidate);
    }

    @Step("Fill Job Vacancy data to form.")
    public void fillJobVacancy(String jobVacancyOptionValue) {

        LOG.info("Fill Job Vacancy {} '{}' to form.", jobVacancyOptionValue,
                addCandidateForm.getJobVacancyName(jobVacancyOptionValue));
        addCandidateForm.addJobVacancy(jobVacancyOptionValue);
    }

    public void fillAnyJobVacancy() {

        fillJobVacancy(getAnyJobVacancy());
    }

    @Step("Fill Keywords to form.")
    public void fillKeywords(String keywords) {

        addCandidateForm.addKeywords(keywords);
    }

    @Step("Fill Comment to form.")
    public void fillComment(String comment) {

        addCandidateForm.addComment(comment);
    }

    @Step("Fill today Date of application to form.")
    public void fillApplicationDate() {

        LOG.info("Fill today Date of application to form.");
        addCandidateForm.addApplicationDate();
    }

    @Step("Fill any Date of application to form.")
    public void fillAnyApplicationDate() {

        LOG.info("Fill any Date of application to form.");
        addCandidateForm.addAnyApplicationDate();
    }

    @Step("Fill Consent to keep data to form.")
    public void consentToKeepData() {

        addCandidateForm.clickConsentToKeepData();
    }

    @Step("Save the data.")
    public void save() {

        LOG.info("Save the data.");
        addCandidateForm.clickSaveButton();
    }

    public SelenideElement getBackButton() {

        return addCandidateForm.getBackButton();
    }

    public String getApplicationDateFieldValue() {

        return addCandidateForm.getApplicationDateFieldValue();
    }

    public LocalDate getDateNow() {

        return addCandidateForm.getDateNow();
    }

    public SelenideElement getApplicationDateError() {

        return addCandidateForm.getApplicationDateError();
    }

    public boolean isDateLessOrEqualsThanCurrent(String date) {

        return (LocalDate.parse(date).isBefore(getDateNow()) || LocalDate.parse(date).isEqual(getDateNow()));
    }

    private String getAnyJobVacancy() {

        int value = randomNumber.getNumber(1, addCandidateForm.getNumberOfJobVacancies());

        return String.valueOf(value);
    }
}
