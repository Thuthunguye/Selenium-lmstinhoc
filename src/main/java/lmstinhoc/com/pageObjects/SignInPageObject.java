package lmstinhoc.com.pageObjects;

import lmstinhoc.com.commons.BasePage;
import lmstinhoc.com.pageUI.SignInPageUI;
import org.openqa.selenium.WebDriver;

public class SignInPageObject extends BasePage {
    public SignInPageObject(WebDriver driver) {
        super(driver);
    }

    public PortalChoicePageObject  login(String username, String password) {
        sendkeyToElement(driver,SignInPageUI.USERNAME_TEXTBOX, username);
        sendkeyToElement(driver,SignInPageUI.PASSWORD_TEXTBOX, password);
        clickToElement(SignInPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getPortalChoicePage(driver);
    }
}
