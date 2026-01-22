package lmstinhoc.com.pageObjects;

import lmstinhoc.com.pageUI.LopHocPageUI;
import lmstinhoc.com.pageUI.MonHocPageUI;
import lmstinhoc.com.pageUI.PhanCongPageUI;
import org.openqa.selenium.WebDriver;

public class LopHocPageObject extends SideBarPageObject{
    public LopHocPageObject(WebDriver driver) {
        super(driver);
    }

    public void openAddPopup() {
        waitForElementClickable(driver, LopHocPageUI.BTN_THEMMOILOPHOC);
        clickToElement(LopHocPageUI.BTN_THEMMOILOPHOC);
    }

    public void inputClasstName(String className) {
        waitForElementClickable(driver, LopHocPageUI.INPUT_NAME_ADD, className);
        sendkeyToElement(driver,LopHocPageUI.INPUT_NAME_ADD, className);
    }

    public void selectBlock(String blockName) {
        selectItemInCustomDropdown(driver, LopHocPageUI.BLOCK_DROP_INPUT, LopHocPageUI.SELECT_OPTION_BY_TEXT, blockName);
    }

    public void clickConfirm() {
        waitForElementClickable(driver, LopHocPageUI.BTN_DONGY);
        clickToElement(LopHocPageUI.BTN_DONGY);
    }

    public boolean ishvDisplayed(String className) {
        waitForElementVisible(driver, LopHocPageUI.SUBJECT_NAME_IN_LIST, className);
        return isElementDisplayed(driver,LopHocPageUI.SUBJECT_NAME_IN_LIST, className);
    }
}
