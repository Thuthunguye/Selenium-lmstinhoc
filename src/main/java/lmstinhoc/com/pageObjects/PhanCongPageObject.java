package lmstinhoc.com.pageObjects;

import lmstinhoc.com.pageUI.MonHocPageUI;
import lmstinhoc.com.pageUI.PhanCongPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v137.network.model.DataReceived;

import java.util.List;

public class PhanCongPageObject extends SideBarPageObject{
    public PhanCongPageObject(WebDriver driver) {
        super(driver);
    }

    public void openAddPCSubjectPopup() {
        waitForElementClickable(driver, PhanCongPageUI.BTN_THEMPHANCONG);
        clickToElement(PhanCongPageUI.BTN_THEMPHANCONG);
    }

    public void selectClass(String className) {
        selectItemInCustomDropdown(driver, PhanCongPageUI.CLASS_SEARCH_INPUT, PhanCongPageUI.SELECT_OPTION_BY_TEXT, className);
    }

    public void selecteditClass(String newclassName) {
        selectItemInCustomDropdown(driver, PhanCongPageUI.CLASS_DROPDOWN, PhanCongPageUI.SELECT_OPTION_BY_TEXT, newclassName);
    }

    public void selectSubject(String subjectName) {
        selectItemInCustomDropdown(driver, PhanCongPageUI.SUBJECT_SEARCH_INPUT, PhanCongPageUI.SELECT_OPTION_BY_TEXT, subjectName);
    }

    public void selectCOURSE(String courseName) {
        selectItemInCustomDropdown(driver, PhanCongPageUI.COURSE_SEARCH_INPUT, PhanCongPageUI.SELECT_OPTION_BY_TEXT, courseName);
    }

    public void selectTEACHER(String teacherName) {
        selectItemInCustomDropdown(driver, PhanCongPageUI.TEACHER_SEARCH_INPUT, PhanCongPageUI.SELECT_OPTION_BY_TEXT, teacherName);
    }

    public void selectASSISTANT(String assistantName) {
        selectItemInCustomDropdown(driver, PhanCongPageUI.ASSISTANT_SEARCH_INPUT, PhanCongPageUI.SELECT_OPTION_BY_TEXT, assistantName);
    }

    public void selectFOLLOWERS(String followerName) {
        selectItemInCustomDropdown(driver, PhanCongPageUI.FOLLOWERS_SEARCH_INPUT, PhanCongPageUI.SELECT_OPTION_BY_TEXT, followerName);
    }

    public void inputDescription(String description) {
        waitForElementClickable(driver,PhanCongPageUI.DESCRIPTION_SEARCH_INPUT, description);
        sendkeyToElement(driver, PhanCongPageUI.DESCRIPTION_SEARCH_INPUT, description);
    }

    public void clickConfirm() {
        waitForElementClickable(driver, PhanCongPageUI.BTN_DONGY);
        clickToElement(PhanCongPageUI.BTN_DONGY);
    }

    public boolean isAssignmentDisplayed(String assignmentName) {
        waitForElementVisible(driver, PhanCongPageUI.ASSIGNMENT_NAME_IN_LIST,  assignmentName);
        return isElementDisplayed(driver, PhanCongPageUI.ASSIGNMENT_NAME_IN_LIST,  assignmentName);
    }

    public boolean isTeacherDisplayed(String teacherName) {
        waitForElementVisible(driver, PhanCongPageUI.TEACHER_TAG_IN_LIST, teacherName);
        return isElementDisplayed(driver, PhanCongPageUI.TEACHER_TAG_IN_LIST, teacherName);
    }

    public int getTotalResultByTeacher(String teacherName) {
        return getListElementSize(driver, PhanCongPageUI.ASSIGNMENT_NAME_IN_LIST, "Giáo viên: "+teacherName);
    }

    public void searchByTeacher(String teacherName) {
        selectItemInCustomDropdown(driver, PhanCongPageUI.TEACHER_SEARCH, PhanCongPageUI.SELECT_OPTION_BY_TEXT, teacherName);
    }

    public void openPCEditPopup(String courseName) {
        waitForElementClickable(driver, PhanCongPageUI.ICON_SUAPHANCONG, courseName);
        clickToElement(PhanCongPageUI.ICON_SUAPHANCONG, courseName);
        waitForElementVisible(driver, PhanCongPageUI.TITLE_POPUPEDIT);
    }

    public boolean isPCEditPopupDisplayed() {
        return isElementDisplayed(driver, PhanCongPageUI.TITLE_POPUPEDIT);
    }

    public String getPCNameInEditTextbox() {
        if (isElementDisplayed(driver, PhanCongPageUI.CLASS_SELECTED_TEXT)) {
            return getElementText(driver, PhanCongPageUI.CLASS_SELECTED_TEXT);
        }
        return "";
    }

    public void clickPCEditConfirm() {
        waitForElementClickable(driver, PhanCongPageUI.BTN_DONGY_EDIT);
        clickByJS(driver, PhanCongPageUI.BTN_DONGY_EDIT);
        waitForElementInvisible(driver, PhanCongPageUI.TITLE_POPUPEDIT);
    }

    public void clearEditPopup() {
        waitForElementClickable(driver, PhanCongPageUI.BTN_CLEAR_SELECT);
        clickToElement(driver, PhanCongPageUI.BTN_CLEAR_SELECT);
    }

    public boolean isPCListUpdated(String courseName, String newclassName) {
        waitForElementVisible(driver, PhanCongPageUI.ASSIGNMENT_NAME_EDIT_LIST, courseName, newclassName);
        return isElementDisplayed(driver,PhanCongPageUI.ASSIGNMENT_NAME_EDIT_LIST,courseName, newclassName);
    }

    public void deletePCSubject(String courseName) {
        // click icon xóa
        waitForElementClickable(driver, PhanCongPageUI.ICON_XOAPHANCONG, courseName);
        clickToElement(driver, PhanCongPageUI.ICON_XOAPHANCONG, courseName);

        // click xác nhận (JS click cho AntD)
        waitForElementVisible(driver, PhanCongPageUI.BTN_CONFIRM_DELETE);
        clickByJS(driver, PhanCongPageUI.BTN_CONFIRM_DELETE);

        // chờ dòng biến mất
        waitForElementInvisible(driver, PhanCongPageUI.SUBJECT_ROW_BY_NAME, courseName);
    }

    public boolean isPCSubjectUndisplayed(String courseName) {
        return isElementUndisplayed(driver, PhanCongPageUI.SUBJECT_ROW_BY_NAME, courseName);
    }




//    public void clickDropdown() {
//        waitForElementVisible(driver, PhanCongPageUI.CLASS_SEARCH_INPUT);
//        clickToElement(driver, PhanCongPageUI.CLASS_SEARCH_INPUT);
//    }
//    public void inputPCSubjectName(String className) {
//        waitForElementClickable(driver,PhanCongPageUI.CLASS_SEARCH_INPUT, className);
//        sendkeyToElement(driver, PhanCongPageUI.CLASS_SEARCH_INPUT, className);
//    }
//
//    public void clickOption(String className) {
//        // 3. Chờ option xuất hiện
//        waitForElementVisible(driver, PhanCongPageUI.SELECT_OPTION_BY_TEXT, className);
//
//        // 4. Click option
//        clickToElement(driver, PhanCongPageUI.SELECT_OPTION_BY_TEXT, className);
//    }
//    public void selectClass(String className) {
//
//    // 1. Click để focus dropdown
//    waitForElementVisible(driver, PhanCongPageUI.CLASS_SEARCH_INPUT);
//    clickToElement(driver, PhanCongPageUI.CLASS_SEARCH_INPUT);
//
//    // 2. Gõ tìm kiếm
//    sendkeyToElement(driver, PhanCongPageUI.CLASS_SEARCH_INPUT, className);
//
//    // 3. Chờ option xuất hiện
//    waitForElementVisible(driver, PhanCongPageUI.SELECT_OPTION_BY_TEXT, className);
//
//    // 4. Click option
//    clickToElement(driver, PhanCongPageUI.SELECT_OPTION_BY_TEXT, className);
//}
    public String getTextSelectedClassDroplist(){
        waitForElementVisible(driver, PhanCongPageUI.SELECT_BY_TEXT);
        return getAntdSelectedOrPlaceholder(driver, PhanCongPageUI.SELECT_BY_TEXT);
    }


}
