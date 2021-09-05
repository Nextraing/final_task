package com.orangehrmlive.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchForm {

    private final SelenideElement subUnitBox = $("#empsearch_sub_unit");
    private final SelenideElement usernameField = $("#searchSystemUser_userName");
    private final SelenideElement employeeNameField = $("#searchSystemUser_employeeName_empName");
    private final SelenideElement searchButton = $("#searchBtn");

    private final ElementsCollection subUnitCollection = $$("#empsearch_sub_unit option");

    public SelenideElement getSubUnitBox() {

        return subUnitBox;
    }

    public SelenideElement getUsernameField(){

        return usernameField;
    }

    public SelenideElement getEmployeeNameField() {

        return employeeNameField;
    }

    public SelenideElement getSearchButton() {

        return searchButton;
    }

    public ElementsCollection getSubUnitCollection() {

        return subUnitCollection;
    }

    public void clickSubUnitBox() {

        getSubUnitBox().click();
    }

    public void clickSearchButton() {

        getSearchButton().click();
    }
}
