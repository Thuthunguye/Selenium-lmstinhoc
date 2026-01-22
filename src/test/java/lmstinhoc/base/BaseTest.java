package lmstinhoc.base;

import lmstinhoc.com.commons.GlobalConstants;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
//    static String driverPath="resources\\drivers\\";

    //hàm này để cho những class khác gọi đến nó nhận driver đã khởi tạo (đã khởi tạp hàm beforclass qua hàm setdriver mà setdriver trả ra cho mình 1 cái driver=...)
    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    //Hàm này để chọn browser cho chạy trước khi gọi class này (beforeclass)
//    private void setDriver(String browserType, String appURL) {
//
//        switch (browserType) {
//
//            case "chrome":
//                driver = initChromeDriver(appURL);
//                break;
//
//            case "firefox":
//                driver = initFirefoxDriver(appURL);
//                break;
//
//            case "opera":
//                driver = initOperaDriver(appURL);
//                break;
//
//            default:
//                System.out.println("Browser: " + browserType +
//                        " is invalid, Launching Chrome as default...");
//                driver = initChromeDriver(appURL);
//                break;
//        }
//    }

    protected WebDriver getBrowserDriver(String browserType, String appURL) {
        BrowserList browserList = BrowserList.valueOf(browserType.toUpperCase());
        switch (browserList) {

            case CHROME:
                //System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
                driver = new ChromeDriver();

                //version 5.x
                //Tự tải chromedriver tương ứng với chrome browser, sau đó khởi tạo driver lên
                //driver = WebDriverManager.chromedriver().create();
                break;

            case FIREFOX:
                //driver = WebDriverManager.firefoxdriver().create();
                driver = new FirefoxDriver();
                break;

            case EDGE:
                //driver = WebDriverManager.edgedriver().create();
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("Browser name is not valid");
        }

        driver.get(appURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        return driver;
    }

    protected WebDriver getBrowserDriver1(String browserName, String url) {
        ChromeOptions options = new ChromeOptions();

        String downloadPath = System.getProperty("user.dir") + "\\downloadFiles";

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadPath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("safebrowsing.enabled", true);

        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        driver.get(url);
        return driver;
    }


    // khởi tạo cấu hình của các brower để đưa vào switch case
//    private WebDriver initChromeDriver(String appURL) {
//        System.out.println("Launching Chrome browser...");
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.navigate().to(appURL);
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        return driver;
//    }
//
//    // ================= INIT FIREFOX =================
//    private WebDriver initFirefoxDriver(String appURL) {
//        System.out.println("Launching Firefox browser...");
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.navigate().to(appURL);
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        return driver;
//    }
//
//    // ================= INIT OPERA =================
//    private WebDriver initOperaDriver(String appURL) {
//        System.out.println("Launching Opera browser...");
//        WebDriverManager.operadriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.navigate().to(appURL);
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        return driver;
//    }


    // Chạy hàm initializeTestBaseSetup trước hết khi class này được gọi
//    @Parameters({"browserType", "webURL"})
//    @BeforeClass
//    public void initializeTestBaseSetup(String browserType, String webURL) {
//        try {
//            // Khởi tạo driver và browser
//            setDriver(browserType, webURL);
//        } catch (Exception e) {
//            System.out.println("Error..." + e.getStackTrace());
//        }
//    }
//
//    @AfterClass
//    public void tearDown() throws Exception {
//        Thread.sleep(2000);
//        driver.quit();
//    }
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
