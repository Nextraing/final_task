package com.orangehrmlive.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.PropertiesLoader;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.Log.LOG;

public class DashboardPage {

    private final PropertiesLoader propertiesLoader = new PropertiesLoader();

    private final SelenideElement assignLeaveQLPanel =
            $("div[class='quickLaunge'] a[href='" + propertiesLoader.getAssignLeaveProperty() + "']");
    private final SelenideElement leaveListQLPanel =
            $("div[class='quickLaunge'] a[href='" + propertiesLoader.getViewLeaveListProperty() + "']");
    private final SelenideElement timesheetsQLPanel =
            $("div[class='quickLaunge'] a[href='" + propertiesLoader.getViewEmployeeTimesheetProperty() + "']");
    private final SelenideElement applyLeaveQLPanel =
            $("div[class='quickLaunge'] a[href='" + propertiesLoader.getApplyLeaveProperty() + "']");
    private final SelenideElement myLeaveQLPanel =
            $("div[class='quickLaunge'] a[href='" + propertiesLoader.getViewMyLeaveListProperty() + "']");
    private final SelenideElement myTimesheetQLPanel =
            $("div[class='quickLaunge'] a[href='" + propertiesLoader.getMyEmployeeTimesheetProperty() + "']");

    private final SelenideElement distributionPanel = $("#panel_draggable_1_0");
    private final SelenideElement legendPanel = $("#panel_draggable_1_1");
    private final SelenideElement requestsPanel = $("#panel_draggable_1_2");

    private final String panelNameTag = "legend";

    public String getUrl() {

        return propertiesLoader.getDashboardPageProperty();
    }

    @Step("Open Dashboard page.")
    public void openPage() {

        LOG.info("Open {} page.", getUrl());
        open(getUrl());
    }

    public SelenideElement getAssignLeaveQLPanel() {

        return assignLeaveQLPanel;
    }

    public SelenideElement getLeaveListQLPanel() {

        return leaveListQLPanel;
    }

    public SelenideElement getTimesheetsQLPanel() {

        return timesheetsQLPanel;
    }

    public SelenideElement getApplyLeaveQLPanel() {

        return applyLeaveQLPanel;
    }

    public SelenideElement getMyLeaveQLPanel() {

        return myLeaveQLPanel;
    }

    public SelenideElement getMyTimesheetQLPanel() {

        return myTimesheetQLPanel;
    }

    public SelenideElement getDistributionPanel() {

        return distributionPanel;
    }

    public SelenideElement getLegendPanel() {

        return legendPanel;
    }

    public SelenideElement getRequestsPanel() {

        return requestsPanel;
    }

    @Step("Get the name of the Quick Launch panel.")
    public String getQuickLaunchPanelName(SelenideElement element) {

        return element.$("span[class='quickLinkText']").getText();
    }

    @Step("Get the name of the panel.")
    public String getPanelName(SelenideElement element) {

        return element.find(panelNameTag).getText();
    }

    public List<SelenideElement> getQuickLaunchPanels() {

        List<SelenideElement> quickLaunchPanels = new ArrayList<>();

        quickLaunchPanels.add(getAssignLeaveQLPanel());
        quickLaunchPanels.add(getLeaveListQLPanel());
        quickLaunchPanels.add(getTimesheetsQLPanel());
        quickLaunchPanels.add(getApplyLeaveQLPanel());
        quickLaunchPanels.add(getMyLeaveQLPanel());
        quickLaunchPanels.add(getMyTimesheetQLPanel());

        return quickLaunchPanels;
    }

    public List<SelenideElement> getPanels() {

        List<SelenideElement> panels = new ArrayList<>();

        panels.add(getDistributionPanel());
        panels.add(getLegendPanel());
        panels.add(getRequestsPanel());

        return panels;
    }
}
