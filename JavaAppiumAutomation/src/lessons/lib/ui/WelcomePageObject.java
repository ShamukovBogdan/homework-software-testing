package lessons.lib.ui;

import io.appium.java_client.AppiumDriver;

public class WelcomePageObject extends MainPageObject {

    private static final String
        STEP_LEARN_MORE_LINK = "id:Learn more about Wikipedia",
        STEP_NEW_WAY_TO_EXPLORE_LINK = "id:New ways to explore",
        STEP_ADD_OR_EDIT_PREFFERED_LANG_LINK = "id:Add or edit preferred languages",
        STEP_LEARN_MORE_ACOUT_DATA_COLLECTED_LINK = "id:Learn more about data collected",
        NEXT_BUTTON = "id:Next",
        GET_STARTED_BUTTON = "id:Get started",
        SKIP = "id:Skip";

    public WelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void waitForLearnMoreLink()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_LINK, "Cannot find text on 1 screen", 10);
    }

    public void waitForNewWayToExploreText()
    {
        this.waitForElementPresent(STEP_NEW_WAY_TO_EXPLORE_LINK, "Cannot find text on 2 screen", 10);
    }

    public void waitForAddOrEditPreferredLanguagesText()
    {
        this.waitForElementPresent(STEP_ADD_OR_EDIT_PREFFERED_LANG_LINK, "Cannot find text on 3 screen", 10);
    }

    public void waitForLearnMoreAboutDataCollectedText()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_ACOUT_DATA_COLLECTED_LINK, "Cannot find text on 4 screen", 10);
    }

    public void clickNextButton()
    {
        this.waitForElementAndClick(NEXT_BUTTON, "Cannot find 'Next' button", 10);
    }

    public void clickGetStartedButton()
    {
        this.waitForElementAndClick(GET_STARTED_BUTTON, "Cannot find 'Get started' button", 10);
    }

    public void clickSkip()
    {
        this.waitForElementAndClick(SKIP, "Cannot fing 'Skip' button", 5);
    }
}
