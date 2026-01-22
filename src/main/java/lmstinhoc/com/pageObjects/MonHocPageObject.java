package lmstinhoc.com.pageObjects;

import lmstinhoc.com.pageUI.DashBoardPageUI;
import lmstinhoc.com.pageUI.MonHocPageUI;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class MonHocPageObject extends SideBarPageObject {
    public MonHocPageObject(WebDriver driver) {
        super(driver);
    }

    // ================= ADD =================

    public void openAddSubjectPopup() {
        waitForElementClickable(driver, MonHocPageUI.BTN_THEMMOIMONHOC);
        clickToElement(MonHocPageUI.BTN_THEMMOIMONHOC);
    }

    public boolean isPopupDisplayed() {
        waitForElementVisible(driver, MonHocPageUI.TITLE_POPUPTHEM);
        return isElementDisplayed(driver,MonHocPageUI.TITLE_POPUPTHEM);
    }

    public void inputSubjectName(String subjectName) {
        waitForElementClickable(driver,MonHocPageUI.INPUT_NAME_ADD, subjectName);
        sendkeyToElement(driver,MonHocPageUI.INPUT_NAME_ADD, subjectName);
    }

    public void clickConfirm() {
        waitForElementClickable(driver, MonHocPageUI.BTN_DONGY);
        clickToElement(MonHocPageUI.BTN_DONGY);
    }

    public void clickCancel() {
        waitForElementClickable(driver, MonHocPageUI.BTN_HUY);
        clickToElement(MonHocPageUI.BTN_HUY);
        waitForElementInvisible(driver, MonHocPageUI.TITLE_POPUPTHEM);

    }

    public boolean isErrorMessageDisplayed() {
        waitForElementClickable(driver, MonHocPageUI.ERROR_MESSAGE);
        return isElementDisplayed(driver,MonHocPageUI.ERROR_MESSAGE);
    }


    public boolean isSubjectDisplayed(String subjectName) {
//        waitForElementVisible(driver, MonHocPageUI.INPUT_NAME_ADD, subjectName);
        waitForElementVisible(driver, MonHocPageUI.SUBJECT_NAME_IN_LIST, subjectName);
        return isElementDisplayed(driver,MonHocPageUI.SUBJECT_NAME_IN_LIST, subjectName);
    }

    public boolean isAddSubjectPopupClosed() {
        return isElementUndisplayed(driver, MonHocPageUI.TITLE_POPUPTHEM);
    }

    // ================= EDIT =================
    public void openEditPopup(String subjectName) {
        waitForElementClickable(driver, MonHocPageUI.ICON_SUAMONHOC, subjectName);
        clickToElement(MonHocPageUI.ICON_SUAMONHOC, subjectName);
        waitForElementVisible(driver, MonHocPageUI.TITLE_POPUPEDIT);
        waitForElementVisible(driver, MonHocPageUI.INPUT_NAME_EDIT);

    }

    public boolean isEditPopupDisplayed() {
        return isElementDisplayed(driver, MonHocPageUI.TITLE_POPUPEDIT);
    }

    public String getNameInEditTextbox() {
        waitForElementVisible(driver, MonHocPageUI.INPUT_NAME_EDIT);
        return getElementAttribute(driver, MonHocPageUI.INPUT_NAME_EDIT, "value");
    }


    public void inputEditName(String newName) {

        waitForElementVisible(driver, MonHocPageUI.INPUT_NAME_EDIT);

        WebElement input = getElement(driver, MonHocPageUI.INPUT_NAME_EDIT);

        input.click();

        input.sendKeys(Keys.CONTROL, "a");
        input.sendKeys(Keys.BACK_SPACE);

        input.sendKeys(newName);
        input.sendKeys(Keys.ENTER);
    }



    public void clickEditConfirm() {
        waitForElementClickable(driver, MonHocPageUI.BTN_DONGY_EDIT);
        clickByJS(driver, MonHocPageUI.BTN_DONGY_EDIT);
        waitForElementInvisible(driver, MonHocPageUI.TITLE_POPUPEDIT);
    }

    public boolean isDuplicateErrorDisplayed() {
        waitForElementVisible(driver, MonHocPageUI.ERROR_MESSAGE);
        return isElementDisplayed(driver, MonHocPageUI.ERROR_MESSAGE);
    }

    public void clickEditCancel() {
        waitForElementClickable(driver, MonHocPageUI.BTN_HUY);
        clickToElement(MonHocPageUI.BTN_HUY);
        waitForElementInvisible(driver, MonHocPageUI.TITLE_POPUPEDIT);

    }

    public boolean isEditPopupClosed() {
        return isElementUndisplayed(driver, MonHocPageUI.TITLE_POPUPEDIT);
    }

    public boolean isListUpdated(String newName) {
        waitForElementVisible(driver, MonHocPageUI.SUBJECT_NAME_IN_LIST, newName);
        return isElementDisplayed(driver,MonHocPageUI.SUBJECT_NAME_IN_LIST, newName);
    }
    // ================= DELETE =================
//    public void openDeletePopup(String subjectName) {
//        waitForElementClickable(driver, MonHocPageUI.ICON_XOAMONHOC, subjectName);
//        clickToElement(MonHocPageUI.ICON_XOAMONHOC, subjectName);
//    }

//    public boolean isEditPopupDisplayed() {
//        return isElementDisplayed(driver, MonHocPageUI.TITLE_POPUPEDIT);
//    }
//    public void clickDeleteConfirm() {
//        waitForElementClickable(driver, MonHocPageUI.BTN_DONGY_EDIT);
////        clickToElement(MonHocPageUI.BTN_DONGY_EDIT);
//        clickByJS(driver, MonHocPageUI.BTN_DONGY_EDIT);
//        waitForElementInvisible(driver, MonHocPageUI.TITLE_POPUPEDIT);
//    }
//    //verify ko còn
//    public boolean isSubjectUndisplayed(String subjectName) {
//        return isElementUndisplayed(driver, MonHocPageUI.SUBJECT_ROW_BY_NAME, subjectName);
//    }
    public void deleteSubject(String subjectName) {
    // click icon xóa
    waitForElementClickable(driver, MonHocPageUI.ICON_XOAMONHOC, subjectName);
    clickToElement(driver, MonHocPageUI.ICON_XOAMONHOC, subjectName);

    // click xác nhận (JS click cho AntD)
    waitForElementVisible(driver, MonHocPageUI.BTN_CONFIRM_DELETE);
    clickByJS(driver, MonHocPageUI.BTN_CONFIRM_DELETE);

    // chờ dòng biến mất
    waitForElementInvisible(driver, MonHocPageUI.SUBJECT_ROW_BY_NAME, subjectName);
}
    public boolean isSubjectUndisplayed(String subjectName) {
        return isElementUndisplayed(driver, MonHocPageUI.SUBJECT_ROW_BY_NAME, subjectName);
    }


    public void waitForSuccessMessage() {
        // 1. Chờ toast xuất hiện
        waitForElementVisible(driver, MonHocPageUI.TOAST_SUCCESS_TEXT);

        // 2. Lấy text
        String actualText = getElementText(driver, MonHocPageUI.TOAST_SUCCESS_TEXT).trim();
        System.out.println("TOAST TEXT = " + actualText);

        // 3. Assert
        Assert.assertTrue(
                "Expected success toast but got: " + actualText,
                actualText.contains("Thành công")
        );
        // 4. Chờ toast biến mất (tránh che UI)
        waitForElementInvisible(driver, MonHocPageUI.TOAST_NOTICE);
    }
}
