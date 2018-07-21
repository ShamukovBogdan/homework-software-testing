package lessons.lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lessons.lib.ui.MyListsPageObject;

public class iOSMyListsPageObject extends MyListsPageObject
{
    static
    {
        ARTICLE_BY_TITLE_TPL = "XCUIElementTypeLink[contains(@name='{TITLE}')]";
    }

    public iOSMyListsPageObject(AppiumDriver driver){
        super(driver);
    }
}