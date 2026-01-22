package lmstinhoc.testcase;

import lmstinhoc.base.BaseTest;
import lmstinhoc.com.pageObjects.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseRun extends BaseTest {

//    protected WebDriver driver;
    protected SideBarPageObject menuPage;

    protected SignInPageObject signInPage;
    protected PortalChoicePageObject portalPage;
    protected DashBoardPageObject dashBoardPage;
    protected MonHocPageObject monHocPage;
    protected PhanCongPageObject phanCongPage;
    protected LopHocPageObject lopHocPage;
    protected KhoiPageObject khoiPage;
    protected HocVienPageObject hocVienPage;

    private final String usernameLogin = "admin";
    private final String passwordLogin = "Admin@123";
    private final String roleName = "Quản trị viên";

    @BeforeClass
    @Parameters({"browserType", "webURL"})
    public void baseLogin(String browser, String url) {

//        driver = getDriver();
        driver = getBrowserDriver(browser, url);

        // 1. Mở trang đăng nhập
        signInPage = PageGeneratorManager.getSignInPage(driver);

        // 2. Login → Portal Choice
        portalPage = signInPage.login(usernameLogin, passwordLogin);

        // 3. Chọn role → Dashboard
        dashBoardPage = portalPage.chooseRole(roleName);

        //4. Menu
        menuPage = PageGeneratorManager.getSideBarPage(driver);


    }
//    @Test
//    public void Switch_menu_by_specific_methods() throws InterruptedException {
//
//        // Dashboard → Môn học
//        monHocPage = menuPage.openMonHocMenu();
//
//        Thread.sleep(2000);
//        // Môn học → Phân công
//        phanCongPage = monHocPage.openPhanCongdMenu();
//
//        Thread.sleep(2000);
//        // Môn học → Lớp học
//        lopHocPage = phanCongPage.openLopHocMenu();
//
//        Thread.sleep(2000);
//        // Lớp học → Khối
//        khoiPage = lopHocPage.openKhoiMenu();
//
//        Thread.sleep(2000);
//        // Khối → Dashboard
//        dashBoardPage = khoiPage.openDashboardMenu();
//    }
//
//    @Test
//    public void Switch_menu_dynamic() throws InterruptedException {
//
//        monHocPage = (MonHocPageObject) menuPage.openDynamicSideBarPage("Môn học");
//
//        Thread.sleep(2000);
//        lopHocPage = (LopHocPageObject) monHocPage.openDynamicSideBarPage("Lớp học");
//
//        Thread.sleep(2000);
//        khoiPage = (KhoiPageObject) lopHocPage.openDynamicSideBarPage("Khối");
//
//        Thread.sleep(2000);
//        dashBoardPage = (DashBoardPageObject) khoiPage.openDynamicSideBarPage("Dashboard");
//    }
}
