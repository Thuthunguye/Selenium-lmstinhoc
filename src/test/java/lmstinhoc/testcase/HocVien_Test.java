package lmstinhoc.testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HocVien_Test extends BaseRun{
    @BeforeClass
    public void goToHocVienPage() {
        hocVienPage = menuPage.openHocVienMenu();
    }

    @Test(priority = 1)
    public void FlowHV_successfully() throws InterruptedException {
        String fullName = "testt";
        String userName = "testt";
        String passWord = "Admin@123";
        String newPassWord = "Editpass@123";

        String newName = "testt_edit";


        //ADD
        hocVienPage.openAddPopup();
        hocVienPage.inputUserName(userName);
        hocVienPage.inputPassWord(passWord);
        hocVienPage.inputFullName(fullName);
//        lopHocPage.selectBlock(blockName);
        hocVienPage.clickConfirm();
        assertTrue(hocVienPage.ishvDisplayed(fullName));

        //SEARCH
        hocVienPage.searchByUserName(userName);
        Thread.sleep(2000);
        hocVienPage.searchByFullName(fullName);
        Thread.sleep(2000);
        hocVienPage.selectByStatus();

        Thread.sleep(2000);
        assertTrue(hocVienPage.getTotalResult(userName,fullName) > 0);
        assertTrue(hocVienPage.isTeacherDisplayed(userName, fullName));

        //SEE
        hocVienPage.openSeePopup(fullName);
        assertEquals(hocVienPage.getNameInTextbox(), fullName);
        hocVienPage.clickClose();

        //EDIT
        hocVienPage.openEditPopup(fullName);
//        assertTrue(hocVienPage.isEditPopupDisplayed());
        assertEquals(hocVienPage.getNameInEditTextbox(), fullName);

        hocVienPage.inputEditName(newName);

        hocVienPage.clickEditConfirm();
        assertTrue(hocVienPage.isListUpdated(newName));

        //EDIT PASS
        hocVienPage.openPassPopup(newName);
        hocVienPage.clickEditPass();
        hocVienPage.inputEditPass(newPassWord);
        hocVienPage.clickConfirmPass();

        // DELETE
        hocVienPage.deleteSubject(userName,fullName);
        assertTrue(hocVienPage.isSubjectUndisplayed(userName, fullName));
    }

    @Test(priority = 2)
    public void Import_excel()  {
//        String large = "large.jpg";
        String[] fileNames = {"student-class-example.xlsx"};
        hocVienPage.uploadMultipleFiles(driver, fileNames);
        assertTrue(hocVienPage.isImportSuccess());
    }

    @Test(priority = 3)
    public void Export_Excel() {

        assertTrue(hocVienPage.isTableHasData(), "Bảng KHÔNG có dữ liệu");

        hocVienPage.clickExportExcel();

        // Cách 1: kiểm tra theo tên file cụ thể
//        assertTrue(hocVienPage.isFileDownloadedSuccess("hoc_vien.xlsx"));

        // HOẶC Cách 2: kiểm tra theo đuôi file
         assertTrue(hocVienPage.isFileDownloadedWithExtension(".xlsx"));
    }
}
