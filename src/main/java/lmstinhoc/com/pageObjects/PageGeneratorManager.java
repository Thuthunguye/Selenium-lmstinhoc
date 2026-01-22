package lmstinhoc.com.pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static SideBarPageObject getSideBarPage(WebDriver driver){
        return new SideBarPageObject(driver);
    }

    public static SignInPageObject getSignInPage(WebDriver driver){
        return new SignInPageObject(driver);
    }

    public static PortalChoicePageObject getPortalChoicePage(WebDriver driver){
        return new PortalChoicePageObject(driver);
    }

    public static DashBoardPageObject getDashBoardPage(WebDriver driver){
        return new DashBoardPageObject(driver);
    }

    public static MonHocPageObject getMonHocPage(WebDriver driver){
        return new MonHocPageObject(driver);
    }

    public static PhanCongPageObject getPhanCongPage(WebDriver driver){
        return new PhanCongPageObject(driver);
    }

    public static LopHocPageObject getLopHocPage(WebDriver driver){
        return new LopHocPageObject(driver);
    }

    public static KhoiPageObject getKhoiPage(WebDriver driver){
        return new KhoiPageObject(driver);
    }

    public static HocVienPageObject getHocVienPage(WebDriver driver){
        return new HocVienPageObject(driver);
    }

    public static GiaoVienPageObject getGiaoVienPage(WebDriver driver){
        return new GiaoVienPageObject(driver);
    }

    public static NguoiDungPageObject getNguoiDungPage(WebDriver driver){
        return new NguoiDungPageObject(driver);
    }

    public static VaiTroPageObject getVaiTroPage(WebDriver driver){
        return new VaiTroPageObject(driver);
    }

    public static ChinhSachPageObject getChinhSachPage(WebDriver driver){
        return new ChinhSachPageObject(driver);
    }



}
