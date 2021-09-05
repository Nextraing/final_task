package com.orangehrmlive.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import users.User;
import utils.PropertiesLoader;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.Log.LOG;

public class LoginPage {

    private final SelenideElement loginField = $("#txtUsername");
    private final SelenideElement passwordField = $("#txtPassword");
    private final SelenideElement loginButton = $("#btnLogin");

    private final PropertiesLoader propertiesLoader = new PropertiesLoader();

    public void setValueToLoginField(String value) {

        loginField.setValue(value);
    }

    public void setValueToPasswordField(String value) {

        passwordField.setValue(value);
    }

    public void clickOnLoginButton() {

        loginButton.click();
    }

    public String getUrl() {

        return propertiesLoader.getLoginPageProperty();
    }

    @Step("Open Login page.")
    public void openPage() {

        LOG.info("Open {} page.", getUrl());
        open(getUrl());
    }

    @Step("User logs into the site.")
    public void login(User user) {

        LOG.info("User '{}' with password '{}' logs into the site.", user.getLoginName(), user.getPassword());
        setValueToLoginField(user.getLoginName());
        setValueToPasswordField(user.getPassword());
        clickOnLoginButton();
    }
}
