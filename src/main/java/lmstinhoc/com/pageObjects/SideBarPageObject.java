package lmstinhoc.com.pageObjects;

import lmstinhoc.com.commons.BasePage;
import lmstinhoc.com.pageUI.MenuPageUI;
import org.openqa.selenium.WebDriver;

public class SideBarPageObject extends BasePage {
    public SideBarPageObject(WebDriver driver) {
        super(driver);
    }
    public void openSidebarMenu(String menuName)
    {
        waitForElementClickable(driver, MenuPageUI.SIDEBAR_LINK_BY_CTH);
        clickToElement( MenuPageUI.SIDEBAR_LINK_BY_CTH, menuName);
    }

    public  DashBoardPageObject openDashboardMenu() {
        waitForElementClickable(driver, MenuPageUI.SIDEBAR_LINK_BY_DS);
        clickToElement(driver, MenuPageUI.SIDEBAR_LINK_BY_DS);
        return PageGeneratorManager.getDashBoardPage(driver);
    }

    public  MonHocPageObject openMonHocMenu() {
        waitForElementClickable(driver, MenuPageUI.SIDEBAR_LINK_BY_MH);
        clickToElement(driver, MenuPageUI.SIDEBAR_LINK_BY_MH);
        return PageGeneratorManager.getMonHocPage(driver);
    }

    public PhanCongPageObject openPhanCongMenu() {
        waitForElementClickable(driver, MenuPageUI.SIDEBAR_LINK_BY_PC);
        clickToElement(driver, MenuPageUI.SIDEBAR_LINK_BY_PC);
        return PageGeneratorManager.getPhanCongPage(driver);
    }

    public LopHocPageObject openLopHocMenu() {
        waitForElementClickable(driver, MenuPageUI.SIDEBAR_LINK_BY_LH);
        clickToElement(driver, MenuPageUI.SIDEBAR_LINK_BY_LH);
        return PageGeneratorManager.getLopHocPage(driver);
    }

    public KhoiPageObject openKhoiMenu() {
        waitForElementClickable(driver, MenuPageUI.SIDEBAR_LINK_BY_KHOI);
        clickToElement(driver, MenuPageUI.SIDEBAR_LINK_BY_KHOI);
        return PageGeneratorManager.getKhoiPage(driver);
    }

    public HocVienPageObject openHocVienMenu() {
        waitForElementClickable(driver, MenuPageUI.SIDEBAR_LINK_BY_HV);
        clickToElement(driver, MenuPageUI.SIDEBAR_LINK_BY_HV);
        return PageGeneratorManager.getHocVienPage(driver);
    }

    public GiaoVienPageObject openGiaoVienMenu() {
        waitForElementClickable(driver, MenuPageUI.SIDEBAR_LINK_BY_GV);
        clickToElement(driver, MenuPageUI.SIDEBAR_LINK_BY_GV);
        return PageGeneratorManager.getGiaoVienPage(driver);
    }

    public NguoiDungPageObject openNguoiDungMenu() {
        waitForElementClickable(driver, MenuPageUI.SIDEBAR_LINK_BY_ND);
        clickToElement(driver, MenuPageUI.SIDEBAR_LINK_BY_ND);
        return PageGeneratorManager.getNguoiDungPage(driver);
    }

    public VaiTroPageObject openVaiTroMenu() {
        waitForElementClickable(driver, MenuPageUI.SIDEBAR_LINK_BY_VT);
        clickToElement(driver, MenuPageUI.SIDEBAR_LINK_BY_VT);
        return PageGeneratorManager.getVaiTroPage(driver);
    }

    public ChinhSachPageObject openChinhSachMenu() {
        waitForElementClickable(driver, MenuPageUI.SIDEBAR_LINK_BY_CS);
        clickToElement(driver, MenuPageUI.SIDEBAR_LINK_BY_CS);
        return PageGeneratorManager.getChinhSachPage(driver);
    }



    public SideBarPageObject openDynamicSideBarPage(String pageName) {
        waitForElementClickable(driver, MenuPageUI.SIDEBAR_LINK_BY_CTH, pageName);
        clickToElement(driver, MenuPageUI.SIDEBAR_LINK_BY_CTH, pageName);
        switch (pageName) {
            case "Môn học":
                return PageGeneratorManager.getMonHocPage(driver);

            case "Phân công giảng dạy":
                return PageGeneratorManager.getPhanCongPage(driver);

            case "Lớp học":
                return PageGeneratorManager.getLopHocPage(driver);

            case "Khối":
                return PageGeneratorManager.getKhoiPage(driver);

            case "Học viên":
                return PageGeneratorManager.getHocVienPage(driver);

            case "Giáo viên":
                return PageGeneratorManager.getGiaoVienPage(driver);

            case "Người dùng":
                return PageGeneratorManager.getNguoiDungPage(driver);

            case "Vai trò":
                return PageGeneratorManager.getVaiTroPage(driver);

            case "Chính sách":
                return PageGeneratorManager.getChinhSachPage(driver);
            default:
                new RuntimeException("Side bar page name is incorrect");
                return null;
        }

    }
}
