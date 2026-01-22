package lmstinhoc.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MonHoc_Test extends BaseRun {

    @BeforeClass
    public void goToMonHocPage() {
        monHocPage = menuPage.openMonHocMenu();
    }

    @Test(priority = 1)
    public void Edit_subject_successfully()  {
        String subjectName = "Automation Selenium";
        String newName = "Edit Automation";

        //ADD
        monHocPage.openAddSubjectPopup();
        monHocPage.inputSubjectName(subjectName);
        monHocPage.clickConfirm();
        //theem thanh cong
        // VERIFY TOAST
//        monHocPage.waitForSuccessMessage();
//        // VERIFY DATA
//        assertTrue(monHocPage.isSubjectDisplayed(subjectName));
        assertTrue(monHocPage.isSubjectDisplayed(subjectName));
        //EDIT
        monHocPage.openEditPopup(subjectName);
        assertTrue(monHocPage.isEditPopupDisplayed());
        assertEquals(monHocPage.getNameInEditTextbox(), subjectName);

        monHocPage.inputEditName(newName);

        monHocPage.clickEditConfirm();
        assertTrue(monHocPage.isListUpdated(newName));

        // DELETE
        monHocPage.deleteSubject(newName);

        assertTrue(monHocPage.isSubjectUndisplayed(newName));
    }
//    @DataProvider(name = "subjectData")
//    public Object[][] subjectData() {
//        return new Object[][]{
//                {"", "Không được để trống"},
//                {"Automation Selenium", ""}
//        };
//    }
//    @Test(dataProvider = "subjectData")
//    public void validate_add_subject(String name, String expectedError) {
//
//        monHocPage.openAddSubjectPopup();
//        monHocPage.inputSubjectName(name);
//        monHocPage.clickConfirm();
//
//        if (expectedError.isEmpty()) {
//            // SUCCESS
//            assertTrue(monHocPage.isSubjectDisplayed(name));
//
//            // clean
//            monHocPage.deleteSubject(name);
//            assertTrue(monHocPage.isSubjectUndisplayed(name));
//        } else {
//            // VALIDATE FAIL
//            assertTrue(monHocPage.isErrorMessageDisplayed());
//
//            // reset popup cho case tiếp
//            monHocPage.clickCancel();
//        }
//    }

//    @Test(priority = 2)
//    public void Edit_name_blank() throws InterruptedException {
//        monHocPage.openAddSubjectPopup();
//        monHocPage.clickConfirm();
//        Thread.sleep(2000);
//        assertTrue(monHocPage.isErrorMessageDisplayed());
//    }
}
//        String subjectName = "ic3 c";
//
//
//        monHocPage.openEditPopup(subjectName);
//
//        monHocPage.inputEditName("");
//        monHocPage.clickEditConfirm();
//
//        assertTrue(monHocPage.isEditPopupDisplayed());
//        assertTrue(monHocPage.isErrorMessageDisplayed());

//
//    @Test
//    public void Edit_name_duplicate() {
//        String subjectName = "Microsoft Excel 2019";
//        String duplicateName = "Microsoft Word 2019";
//
//        monHocPage.openEditPopup(subjectName);
//
//        monHocPage.inputEditName(duplicateName);
//        monHocPage.clickEditConfirm();
//
//        assertTrue(monHocPage.isEditPopupDisplayed());
//        assertTrue(monHocPage.isDuplicateErrorDisplayed());
//    }

//    @Test
//    public void Cancel_edit_subject() {
//        String subjectName = "IC3 GS6 Spark Level 1";
//        String newName = "Input Namenew Not Save";
//
//        monHocPage.openEditPopup(subjectName);
//
//        monHocPage.inputEditName(newName);
//        monHocPage.clickEditCancel();
//
//        assertTrue(monHocPage.isEditPopupClosed());
//        assertFalse(monHocPage.isListUpdated(newName));
//    }

