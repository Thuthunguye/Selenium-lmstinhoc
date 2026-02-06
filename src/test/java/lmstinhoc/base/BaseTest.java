package lmstinhoc.base;

import lmstinhoc.com.commons.GlobalConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.testng.annotations.BeforeMethod;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class BaseTest {
    protected final Logger log;
    protected BaseTest() {
        log = LogManager.getLogger(getClass());
    }
//    static String driverPath="resources\\drivers\\";

    //hàm này để cho những class khác gọi đến nó nhận driver đã khởi tạo (đã khởi tạp hàm beforclass qua hàm setdriver mà setdriver trả ra cho mình 1 cái driver=...)
    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }


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

    @AfterMethod(alwaysRun = true)
    public void takeScreenshot(ITestResult result) throws IOException {

        //passed = SUCCESS và failed = FAILURE
        if (ITestResult.FAILURE == result.getStatus()) {

            // Format ngày giờ
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
            String timestamp = dateFormat.format(new Date());

            // Tạo tham chiếu của TakesScreenshot với driver hiện tại
            TakesScreenshot ts = (TakesScreenshot) driver;
            // Gọi hàm capture screenshot - getScreenshotAs
            File source = ts.getScreenshotAs(OutputType.FILE);
            //Kiểm tra folder tồn tại. Nêu không thì tạo mới folder
            File theDir = new File("./Screenshots/");
            if (!theDir.exists()) {
                theDir.mkdirs();
            }
            // result.getName() lấy tên của test case xong gán cho tên File chụp màn hình luôn
            FileHandler.copy(source, new File("./Screenshots/" + result.getName() +"_" + timestamp+ ".png"));
            System.out.println("Screenshot taken: " + result.getName());
        }
    }
    @BeforeMethod(alwaysRun = true)
    public void beforeTest(Method method) {
        startRecordVideo(method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(ITestResult result) {
        stopRecordVideo();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected ScreenRecorder screenRecorder;
    protected String videoName;
    protected void startRecordVideo(String testName) {
        try {
            File videoDir = new File("./test-recordings/");

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle captureSize =
                    new Rectangle(0, 0, screenSize.width, screenSize.height);

            GraphicsConfiguration gc =
                    GraphicsEnvironment.getLocalGraphicsEnvironment()
                            .getDefaultScreenDevice()
                            .getDefaultConfiguration();

            SimpleDateFormat dateFormat =
                    new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
            videoName = testName + "_" + dateFormat.format(new Date());

            screenRecorder = new ScreenRecorder(
                    gc,
                    captureSize,
                    new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                    new Format(MediaTypeKey, MediaType.VIDEO,
                            EncodingKey, ENCODING_AVI_MJPG,
                            CompressorNameKey, ENCODING_AVI_MJPG,
                            DepthKey, 24,
                            FrameRateKey, Rational.valueOf(15),
                            QualityKey, 1.0f,
                            KeyFrameIntervalKey, 15 * 60),
                    new Format(MediaTypeKey, MediaType.VIDEO,
                            EncodingKey, "black",
                            FrameRateKey, Rational.valueOf(30)),
                    null,
                    videoDir
            ) {
                @Override
                protected File createMovieFile(Format fileFormat) throws IOException {
                    if (!videoDir.exists()) {
                        videoDir.mkdirs();
                    }
                    return new File(videoDir,
                            videoName + "."
                                    + Registry.getInstance().getExtension(fileFormat));
                }
            };

            screenRecorder.start();
            System.out.println("Start record video: " + videoName);

        } catch (Exception e) {
            System.out.println("Cannot start record video: " + e.getMessage());
        }
    }

    protected void stopRecordVideo() {
        try {
            if (screenRecorder != null) {
                screenRecorder.stop();
                System.out.println("Stop record video: " + videoName);
            }
        } catch (Exception e) {
            System.out.println("Cannot stop record video: " + e.getMessage());
        }
    }


}
