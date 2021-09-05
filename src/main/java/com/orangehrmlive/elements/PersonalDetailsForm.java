package com.orangehrmlive.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PersonalDetailsForm {

    private final SelenideElement firstNameField = $("#personal_txtEmpFirstName");
    private final SelenideElement middleNameField = $("#personal_txtEmpMiddleName");
    private final SelenideElement lastNameField = $("#personal_txtEmpLastName");
    private final SelenideElement employeeIdField = $("#personal_txtEmployeeId");
    private final SelenideElement otherIdField = $("#personal_txtOtherID");
    private final SelenideElement driverLicenseNumberField = $("#personal_txtLicenNo");
    private final SelenideElement driverLicenseExpiryDateField = $("#personal_txtLicExpDate");
    private final SelenideElement ssnNumberField = $("#personal_txtNICNo");
    private final SelenideElement sinNumberField = $("#personal_txtSINNo");
    private final SelenideElement maritalStatusField = $("#personal_cmbMarital");
    private final SelenideElement nationalityField = $("#personal_cmbNation");
    private final SelenideElement dateOfBirthField = $("#personal_DOB");
    private final SelenideElement nickNameField = $("#personal_txtEmpNickName");
    private final SelenideElement militaryServiceField = $("#personal_txtMilitarySer");

    private final ElementsCollection personalDetails = $$("*[id^='personal_']:not([type='hidden'])");

    public SelenideElement getFirstNameField() {

        return firstNameField;
    }

    public SelenideElement getMiddleNameField() {

        return middleNameField;
    }

    public SelenideElement getLastNameField() {

        return lastNameField;
    }

    public SelenideElement getEmployeeIdField() {

        return employeeIdField;
    }

    public SelenideElement getOtherIdField() {

        return otherIdField;
    }

    public SelenideElement getDriverLicenseNumberField() {

        return driverLicenseNumberField;
    }

    public SelenideElement getDriverLicenseExpiryDateField() {

        return driverLicenseExpiryDateField;
    }

    public SelenideElement getSsnNumberField() {

        return ssnNumberField;
    }

    public SelenideElement getSinNumberField() {

        return sinNumberField;
    }

    public SelenideElement getMaritalStatusField() {

        return maritalStatusField;
    }

    public SelenideElement getNationalityField() {

        return nationalityField;
    }

    public SelenideElement getDateOfBirthField() {

        return dateOfBirthField;
    }

    public SelenideElement getNickNameField() {

        return nickNameField;
    }

    public SelenideElement getMilitaryServiceField() {

        return militaryServiceField;
    }

    public ElementsCollection getPersonalDetails() {

        return personalDetails;
    }
}
