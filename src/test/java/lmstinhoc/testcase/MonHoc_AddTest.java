//package lmstinhoc.testcase;
//
//import lmstinhoc.com.pageObjects.PageGeneratorManager;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import static org.testng.Assert.assertFalse;
//import static org.testng.Assert.assertTrue;
//
//public class MonHoc_AddTest extends BaseRun{
//
//    private final String subjectName = "Automation Selenium";
//
//
//    @BeforeClass
//    public void goToMonHocPage() {
//        menuPage = PageGeneratorManager.getSideBarPage(driver);
//
//        monHocPage = menuPage.openMonHocMenu();
//    }
//
//    @Test
//    public void Add_subject_name_is_required() {
//
//        monHocPage.openAddSubjectPopup();
//        monHocPage.clickConfirm();
//        assertTrue(monHocPage.isErrorMessageDisplayed());
//        monHocPage.clickCancel();
//        assertTrue(monHocPage.isAddSubjectPopupClosed());
//
//    }
//
//    @Test
//    public void Can_add_subject_successfully() {
//
//        monHocPage.openAddSubjectPopup();
//        monHocPage.inputSubjectName(subjectName);
//        monHocPage.clickConfirm();
//        //theem thanh cong
//        assertTrue(monHocPage.isSubjectDisplayed(subjectName));
//
//    }
//
//    @Test
//    public void Cancel_add_subject_popup() {
//
//        monHocPage.openAddSubjectPopup();
//        monHocPage.clickCancel();
//        assertTrue(monHocPage.isAddSubjectPopupClosed());
//
//    }
//
//
//}
