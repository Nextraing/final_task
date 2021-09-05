package com.orangehrmlive.elements;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;
import static utils.Log.LOG;

public class DatePicker {

    private final ElementsCollection monthList = $$(".ui-datepicker-month option");
    private final ElementsCollection yearList = $$(".ui-datepicker-year option");
    private final ElementsCollection dayList = $$(".ui-state-default");

    public void pickDay(int day) {

        LOG.info("Pick day: {}.", dayList.get(day).getText());
        dayList.get(day).click();
    }

    public void pickMonth(int month) {

        LOG.info("Pick month: '{}'.", monthList.get(month).getText());
        monthList.get(month).click();
    }

    public void pickYear(int year) {

        LOG.info("Pick year: {}.", yearList.get(year).getText());
        yearList.get(year).click();
    }

    public int getNumberOfMonths() {

        return monthList.size();
    }

    public int getNumberOfYears() {

        return yearList.size();
    }

    public int getNumberOfDays() {

        return dayList.size();
    }
}
