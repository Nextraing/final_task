package com.orangehrmlive.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultTable {

    private final SelenideElement addButton = $("#btnAdd");
    private final SelenideElement deleteButton = $("#btnDelete");
    private final SelenideElement resultTable = $("#resultTable");

    private final ElementsCollection searchResults = $$("#resultTable tbody tr");

    public SelenideElement getAddButton() {

        return addButton;
    }

    public SelenideElement getDeleteButton() {

        return deleteButton;
    }

    public SelenideElement getResultTable() {

        return resultTable;
    }

    public void clickAddButton() {

        getAddButton().click();
    }

    public void clickDeleteButton() {

        getDeleteButton().click();
    }

    public ElementsCollection getSearchResults() {

        return searchResults;
    }

    public int getResultsSize() {

        return getSearchResults().size();
    }

    public void clickOnResultLine(int line) {

        getSearchResults().get(line).$(" td[class='left']:nth-child(2) a").click();
    }
}
