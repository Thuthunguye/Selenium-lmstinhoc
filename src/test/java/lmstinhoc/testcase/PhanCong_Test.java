package lmstinhoc.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PhanCong_Test extends BaseRun{
    @BeforeClass
    public void goToPhanCongPage() {
        phanCongPage = menuPage.openPhanCongMenu();
    }

    @Test
    public void Phancong_subject_successfully() throws InterruptedException {
        String className = "Lớp 11";
        String subjectName = "ic3 c";
        String courseName = "Khóa học 1";
        String teacherName = "ngân - ngan";
        String assistantName = "ngân - ngan";
        String followersName = "ngân - ngan";
        String descriptionName = "abc";
        String teachertkName = "ngân";

        String newclassName = "2A2";


        //ADD
//        phanCongPage.openAddPCSubjectPopup();
//        phanCongPage.selectClass(className);
//        phanCongPage.selectSubject(subjectName);
//        phanCongPage.selectCOURSE(courseName);
//        phanCongPage.selectTEACHER(teacherName);
//        phanCongPage.selectASSISTANT(assistantName);
//        phanCongPage.selectFOLLOWERS(followersName);
//        phanCongPage.inputDescription(descriptionName);
//        phanCongPage.clickConfirm();
//        assertTrue(phanCongPage.isAssignmentDisplayed(courseName));

        //SEARCH
        phanCongPage.searchByTeacher(teachertkName);
        assertTrue(phanCongPage.getTotalResultByTeacher(teachertkName) > 0);
        assertTrue(phanCongPage.isTeacherDisplayed(teachertkName));

        //EDIT
//        phanCongPage.openPCEditPopup(courseName);
//        assertTrue(phanCongPage.isPCEditPopupDisplayed());
//
////        String subjectText = phanCongPage.getTextSelectedClassDroplist();
//        assertEquals(phanCongPage.getTextSelectedClassDroplist(), className);
////        System.out.println(subjectText);
//
//        phanCongPage.selecteditClass(newclassName);
//        phanCongPage.clickPCEditConfirm();
//        Thread.sleep(2000);
//        assertTrue(phanCongPage.isPCListUpdated(courseName,newclassName));

        // DELETE
//        phanCongPage.deletePCSubject(courseName);
//
//        assertTrue(phanCongPage.isPCSubjectUndisplayed(courseName));


//        phanCongPage.clickDropdown();
//        phanCongPage.inputPCSubjectName(className);
//        phanCongPage.clickOption(className);
    }
}
