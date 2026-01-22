package lmstinhoc.com.pageObjects;

import lmstinhoc.com.commons.BasePage;
import lmstinhoc.com.pageUI.PortalChoicePageUI;
import org.openqa.selenium.WebDriver;

public class PortalChoicePageObject extends BasePage {
    public PortalChoicePageObject(WebDriver driver) {
        super(driver);
    }

    public DashBoardPageObject chooseRole(String roleName) {
        clickToElement(PortalChoicePageUI.ROLE_BY_NAME, roleName);
        return new DashBoardPageObject(driver);
    }
}
