//package lmstinhoc.testcase;
//
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import static org.testng.Assert.assertTrue;
//
//public class LopHoc_Test extends BaseRun{
//    @BeforeClass
//    public void goToLopHocPage() {
//        lopHocPage = menuPage.openLopHocMenu();
//    }
//
//    @Test(priority = 1)
//    public void Flow_successfully()  {
//        String className = "1A";
//        String blockName = "Khối 1";
//
//        //ADD
//        lopHocPage.openAddPopup();
//        lopHocPage.inputClasstName(className);
//        lopHocPage.selectBlock(blockName);
//        lopHocPage.clickConfirm();
//        assertTrue(lopHocPage.isClassDisplayed(className));
//
//    }
//}
