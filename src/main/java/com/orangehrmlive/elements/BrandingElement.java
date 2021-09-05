package com.orangehrmlive.elements;

import com.codeborne.selenide.SelenideElement;
import utils.PropertiesLoader;

import static com.codeborne.selenide.Selenide.$;
import static utils.Log.LOG;

public class BrandingElement {

    private final PropertiesLoader propertiesLoader = new PropertiesLoader();

    private final SelenideElement accountButton = $("#welcome");
    private final SelenideElement logoutButton =
            $("a[href='" + propertiesLoader.getLogoutProperty() + "']");

    public void clickAccountButton() {

        accountButton.click();
    }

    public void clickLogoutButton() {

        logoutButton.click();
    }

    public void logout() {

        LOG.info("User logs out the site.");
        clickAccountButton();
        clickLogoutButton();
        LOG.info("User was logged out successfully.");
    }
}
