package lmstinhoc.com.pageObjects;

import lmstinhoc.com.pageUI.HocVienPageUI;
import lmstinhoc.com.pageUI.LopHocPageUI;
import lmstinhoc.com.pageUI.MonHocPageUI;
import lmstinhoc.com.pageUI.PhanCongPageUI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HocVienPageObject extends SideBarPageObject{
    public HocVienPageObject(WebDriver driver) {
        super(driver);
    }

    public void openAddPopup() {
        waitForElementClickable(driver, HocVienPageUI.BTN_THEMMOIHV);
        clickToElement(HocVienPageUI.BTN_THEMMOIHV);
    }
    public void inputUserName(String userName) {

        waitForElementVisible(driver, HocVienPageUI.INPUT_USER_ADD);

        WebElement input = getElement(driver, HocVienPageUI.INPUT_USER_ADD);

        input.click();

        input.sendKeys(Keys.CONTROL, "a");
        input.sendKeys(Keys.BACK_SPACE);

        input.sendKeys(userName);
        input.sendKeys(Keys.ENTER);
    }
    public void inputPassWord(String PassWord) {

        waitForElementVisible(driver, HocVienPageUI.INPUT_PASS_ADD);

        WebElement input = getElement(driver, HocVienPageUI.INPUT_PASS_ADD);

        input.click();

        input.sendKeys(Keys.CONTROL, "a");
        input.sendKeys(Keys.BACK_SPACE);

        input.sendKeys(PassWord);
        input.sendKeys(Keys.ENTER);
    }
    public void inputFullName(String fullName) {
        waitForElementClickable(driver, HocVienPageUI.INPUT_NAME_ADD, fullName);
        sendkeyToElement(driver,HocVienPageUI.INPUT_NAME_ADD, fullName);
    }

    public void clickConfirm() {
        waitForElementClickable(driver, HocVienPageUI.BTN_TAOMOI);
        clickToElement(HocVienPageUI.BTN_TAOMOI);
    }

    public boolean ishvDisplayed(String fullName) {
        waitForElementVisible(driver, HocVienPageUI.SUBJECT_NAME_IN_LIST, fullName);
        return isElementDisplayed(driver,HocVienPageUI.SUBJECT_NAME_IN_LIST, fullName);
    }

    public void openEditPopup(String fullName) {
        waitForElementClickable(driver, HocVienPageUI.ICON_SUAHOCVIEN, fullName);
        clickToElement(HocVienPageUI.ICON_SUAHOCVIEN, fullName);
        waitForElementVisible(driver, HocVienPageUI.TITLE_POPUPEDIT, fullName);
        waitForElementVisible(driver, HocVienPageUI.INPUT_NAME_EDIT);

    }

    public boolean isEditPopupDisplayed() {
        return isElementDisplayed(driver, HocVienPageUI.TITLE_POPUPEDIT);
    }

    public String getNameInEditTextbox() {
        waitForElementVisible(driver, HocVienPageUI.INPUT_NAME_EDIT);
        return getElementAttribute(driver, HocVienPageUI.INPUT_NAME_EDIT, "value");
    }

    public void inputEditName(String newName) {

        waitForElementVisible(driver, HocVienPageUI.INPUT_NAME_EDIT);

        WebElement input = getElement(driver, HocVienPageUI.INPUT_NAME_EDIT);

        input.click();

        input.sendKeys(Keys.CONTROL, "a");
        input.sendKeys(Keys.BACK_SPACE);

        input.sendKeys(newName);
        input.sendKeys(Keys.ENTER);
    }

    public void clickEditConfirm() {
        waitForElementClickable(driver, HocVienPageUI.BTN_CAPNHAT);
        clickByJS(driver, HocVienPageUI.BTN_CAPNHAT);
        waitForElementInvisible(driver, HocVienPageUI.TITLE_POPUPEDIT);
    }

    public boolean isListUpdated(String newName) {
        waitForElementVisible(driver, HocVienPageUI.SUBJECT_NAME_IN_LIST, newName);
        return isElementDisplayed(driver,HocVienPageUI.SUBJECT_NAME_IN_LIST, newName);
    }

    public void searchByUserName(String UserName) {
        waitForElementClickable(driver,HocVienPageUI.INPUT_USERNAME_SEARCH, UserName);
        sendkeyToElement(driver, HocVienPageUI.INPUT_USERNAME_SEARCH, UserName);
    }

    public void searchByFullName(String FullName) {
        waitForElementClickable(driver,HocVienPageUI.INPUT_FULLNAME_SEARCH, FullName);
        sendkeyToElement(driver, HocVienPageUI.INPUT_FULLNAME_SEARCH, FullName);
    }

    public void selectByStatus() {
        selectItemInCustomDropdownByIndex(driver, HocVienPageUI.INPUT_STATUS_SEARCH, HocVienPageUI.SELECT_OPTION_BY_TEXT, 1);
    }

    public int  getTotalResult(String userName, String fullName) {
        return getListElementSize(driver, HocVienPageUI.ASSIGNMENT_NAME_IN_LIST, userName, fullName);
    }

    public boolean isTeacherDisplayed(String userName,String fullName) {
        waitForElementVisible(driver, HocVienPageUI.ASSIGNMENT_NAME_IN_LIST, userName,fullName);
        return isElementDisplayed(driver, HocVienPageUI.ASSIGNMENT_NAME_IN_LIST, userName,fullName);
    }

    public void openSeePopup(String fullName) {
        waitForElementClickable(driver, HocVienPageUI.ICON_XEMCHITIET, fullName);
        clickToElement(HocVienPageUI.ICON_XEMCHITIET, fullName);
        waitForElementVisible(driver, HocVienPageUI.TITLE_POPUPSEE, fullName);
        waitForElementVisible(driver, HocVienPageUI.INPUT_NAME);
    }

    public String getNameInTextbox() {
        waitForElementVisible(driver, HocVienPageUI.INPUT_NAME);
        return getElementAttribute(driver, HocVienPageUI.INPUT_NAME, "value");
    }
    public void clickClose() {
        waitForElementClickable(driver, HocVienPageUI.BTN_DONG);
        clickToElement(HocVienPageUI.BTN_DONG);
    }
    public void openPassPopup(String fullName) {
        waitForElementClickable(driver, HocVienPageUI.ICON_DOIMATKHAU, fullName);
        clickToElement(HocVienPageUI.ICON_DOIMATKHAU, fullName);
        waitForElementVisible(driver, HocVienPageUI.TITLE_POPUPPASS, fullName);
//        waitForElementVisible(driver, HocVienPageUI.INPUT_NAME);
    }

    public void clickEditPass() {
        waitForElementClickable(driver, HocVienPageUI.ICON_EDIT_PASS);
        clickToElement(HocVienPageUI.ICON_EDIT_PASS);
    }

    public void inputEditPass(String newPassword) {

        waitForElementVisible(driver, HocVienPageUI.INPUT_PASS_EDIT);

        WebElement input = getElement(driver, HocVienPageUI.INPUT_PASS_EDIT);

        input.click();

        input.sendKeys(Keys.CONTROL, "a");
        input.sendKeys(Keys.BACK_SPACE);

        input.sendKeys(newPassword);
        input.sendKeys(Keys.ENTER);
    }

    public void clickConfirmPass() {
        waitForElementClickable(driver, HocVienPageUI.BTN_DONGY);
        clickToElement(HocVienPageUI.BTN_DONGY);
    }

    public void deleteSubject(String userName, String fullName ) {
        // click icon xóa
        waitForElementClickable(driver, HocVienPageUI.ICON_XOAHOCVIEN,userName, fullName);
        clickToElement(driver, HocVienPageUI.ICON_XOAHOCVIEN, userName,fullName);

        // click xác nhận (JS click cho AntD)
        waitForElementVisible(driver, HocVienPageUI.BTN_CONFIRM_DELETE);
        clickByJS(driver, HocVienPageUI.BTN_CONFIRM_DELETE);

        // chờ dòng biến mất
        waitForElementInvisible(driver, HocVienPageUI.ASSIGNMENT_NAME_IN_LIST,userName, fullName);
    }
    public boolean isSubjectUndisplayed(String userName, String fullName ) {
        return isElementUndisplayed(driver, HocVienPageUI.ASSIGNMENT_NAME_IN_LIST,userName, fullName);
    }


    public boolean isImportSuccess() {
        waitForElementVisible(driver, HocVienPageUI.IMPORT_EXCEL_INPUT);
        return isElementDisplayed(driver, HocVienPageUI.IMPORT_EXCEL_INPUT);
    }

    public void clickExportExcel() {
        waitForElementClickable(driver, HocVienPageUI.EXPORT_EXCEL_BUTTON);
        clickToElement(driver, HocVienPageUI.EXPORT_EXCEL_BUTTON);
    }

    public boolean isTableHasData() {
        return getListElementSize(driver, HocVienPageUI.TABLE_ROWS) > 0;
    }

}
