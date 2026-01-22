package lmstinhoc.com.commons;

import lmstinhoc.com.pageUI.BaseElementUI;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.time.Duration;
import java.util.List;

public class BasePage {
    private Actions actions;
    protected WebDriver driver;
    private final int timeoutWaitForPageLoaded = 20;
    private WebDriverWait wait;
    JavascriptExecutor js;

    private final int TIMEOUT = 10;


    //hàm xây dựng là hàm trùng với tên class
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    public void sleepInSecond(long timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Locator & Element
    public WebElement getWebElement(String locator) {
        return driver.findElement(getByLocator(locator));
    }

    public WebElement getWebElement(String locator, String... restParams) {
        return driver.findElement(getByLocator(getDynamicLocator(locator, restParams)));
    }

    public WebElement getElement( String locator) {
        return driver.findElement(getByLocator(locator));
    }

    public List<WebElement> getListElement(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }

    public List<WebElement> getListElement(WebDriver driver, String locator, String... restParams) {
        return driver.findElements(getByLocator(getDynamicLocator(locator, restParams)));
    }

    //Text & Attribute
    public String getDynamicLocator(String locator, String... restParams) {
        return String.format(locator, (Object[]) restParams);

    }

    public String getElementText(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    public String getElementText(WebDriver driver, String locator, String... restParams) {
        return getElement(driver, getDynamicLocator(locator, restParams)).getText();
    }

    public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
        return getElement(driver, locator).getAttribute(attributeName);
    }

    public String getElementAttribute(WebDriver driver, String locator, String attributeName, String... restParams) {
        return getElement(driver, getDynamicLocator(locator, restParams)).getAttribute(attributeName);
    }

    public By getByLocator(String locatorValue) {
        By by = null;
        if (locatorValue.startsWith("xpath=") || locatorValue.startsWith("xPath=")
                || locatorValue.startsWith("XPATH=") || locatorValue.startsWith("Xpath=")) {
            by = By.xpath(locatorValue.substring(6));
        } else if (locatorValue.startsWith("css=") || locatorValue.startsWith("Css=")
                || locatorValue.startsWith("CSS=")) {
            by = By.cssSelector(locatorValue.substring(4));
        } else if (locatorValue.startsWith("id=") || locatorValue.startsWith("Id=")
                || locatorValue.startsWith("ID=")) {
            by = By.id(locatorValue.substring(3));
        } else if (locatorValue.startsWith("name=") || locatorValue.startsWith("Name=")
                || locatorValue.startsWith("NAME=")) {
            by = By.name(locatorValue.substring(5));
        } else if (locatorValue.startsWith("class=") || locatorValue.startsWith("Class=")
                || locatorValue.startsWith("CLASS=")) {
            by = By.className(locatorValue.substring(6));
        } else if (locatorValue.startsWith("tagname=") || locatorValue.startsWith("Tagname=") || locatorValue.startsWith("tagName=")
                || locatorValue.startsWith("TAGNAME=")) {
            by = By.tagName(locatorValue.substring(8));
        } else {
            throw new RuntimeException("Locator type is not valid");
        }

        return by;

    }

//    protected String formatLocator(String locator, String... values) {
//        return String.format(locator, (Object[]) values);
//    }

    // ================= BASIC ACTION =================
    // ================= CLICK =================

    public void clickToElement( String locator) {
        //driver.findElement(By.xpath(locator));
        getElement(driver, locator).click();
    }

    public void clickToElement( String locator, String... restParams) {
        getElement(driver, getDynamicLocator(locator, restParams)).click();
    }

    public void clickToElement( WebElement element) {
        //driver.findElement(By.xpath(locator));
        element.click();
    }


    public void sendkeyToElement(WebDriver driver, String locator, String valueToSend) {
//        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(valueToSend);
    }

    public void sendkeyToElement(WebDriver driver, String locator, String valueToSend, String... restParams) {
        getElement(driver, getDynamicLocator(locator, restParams)).clear();
        getElement(driver, getDynamicLocator(locator, restParams)).sendKeys(valueToSend);
    }


//    public boolean isElementDisplayed(String locator, String... values) {
//        locator = formatLocator(locator, values);
//        By by = getByLocator(locator);
//        return driver.findElement(by).isDisplayed();
//    }

    // ================= DROPDOWN =================

//    public void selectItemInDropdown(String locator, String text, String... values) {
//        locator = formatLocator(locator, values);
//        Select select = new Select(driver.findElement(getByLocator(locator)));
//        select.selectByVisibleText(text);
//    }

    public void selectItemInDropdown(WebDriver driver, String xpathParent, String xpathChild, String expectedText) {
    getElement(driver, xpathParent).click();
    sleepInSecond(2);
    List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(xpathChild)));
    for (WebElement tempElement : allItems) {

        if (tempElement.getText().equals(expectedText)) {

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoViewIfNeeded(true);", tempElement);
            sleepInSecond(5);

            tempElement.click();
            break;
        }
    }
}

    // ================= JS SUPPORT =================

//    public void clickToElementByJS(String locator, String... values) {
//        locator = formatLocator(locator, values);
//        By by = getByLocator(locator);
//        js.executeScript("arguments[0].click();", driver.findElement(by));
//    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", getElement(driver, locator));
        sleepInSecond(3);
    }

    // ================= WAIT PAGE LOAD=================

    public void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(driver ->
                ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }



    public void clickToElement(WebDriver driver, String locator) {
        //driver.findElement(By.xpath(locator));
        getElement(driver, locator).click();
    }
    public String getAntdSelectedOrPlaceholder(WebDriver driver, String locator) {
        WebElement dropdown = getElement(driver, locator);

        List<WebElement> selectedItems = dropdown.findElements(getByLocator(locator));

        if (!selectedItems.isEmpty()) {
            return selectedItems.get(0).getText();
        }

        return dropdown.findElement(getByLocator(locator)).getText();
    }


    public void clickToElement(WebDriver driver, String locator, String... restParams) {
        getElement(driver, getDynamicLocator(locator, restParams)).click();
    }

    public void clickToElement(WebDriver driver, WebElement element) {
        //driver.findElement(By.xpath(locator));
        element.click();
    }

    //DISPLAYED
    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    public boolean isElementDisplayed(WebDriver driver, String locator, String... restParams) {
        return getElement(driver, getDynamicLocator(locator, restParams)).isDisplayed();
    }

    public void setImplicitWait(WebDriver driver, long timeout) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    //UNDISPLAYED
    public boolean isElementUndisplayed(WebDriver driver, String locator) {
        setImplicitWait(driver, shortTimeout);
        List<WebElement> elements = getListElement(driver, locator);
        setImplicitWait(driver, longTimeout);
        if (elements.size() > 0 && elements.get(0).isDisplayed()) {
            //Element co tren UI va co trong DOM
            return false;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            //element k co tren UI va co trong DOM
            return true;
        } else {
            //Element khong co tren UI va khong co trong DOM
            return true;
        }
    }

    public boolean isElementUndisplayed(WebDriver driver, String locator, String... restParams) {
        setImplicitWait(driver, shortTimeout);
        List<WebElement> elements = getListElement(driver, getDynamicLocator(locator, restParams));
        setImplicitWait(driver, longTimeout);
        if (elements.size() > 0 && elements.get(0).isDisplayed()) {
            //Element co tren UI va co trong DOM
            return false;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            //element k co tren UI va co trong DOM
            return true;
        } else {
            //Element khong co tren UI va khong co trong DOM
            return true;
        }
    }

    //TIME
    private long longTimeout = GlobalConstants.LONG_TIMEOUT;
    private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;

    // ================= WAIT CLICKABLE =================
    //tĩnh
    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    //động
    public void waitForElementClickable(WebDriver driver, String locator, String... restParams) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(locator, restParams))));
    }

    // ================= WAIT VISIBLE =================
    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementVisible(WebDriver driver, String locator, String... restParams) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator, restParams))));
    }

    public void waitForListElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
    }

    public void waitForListElementVisible(WebDriver driver, String locator, String... restParams) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicLocator(locator, restParams))));
    }

    public void waitForElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementInvisible(WebDriver driver, String locator, String... values) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        By byLocator = getByLocator(getDynamicLocator(locator, values));

        wait.until(driver1 -> driver1.findElements(byLocator).isEmpty());    }


    // ================= WAIT PRESENCE =================
    //Đợi
    public void waitForElementPresence(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }

    //Kiểm tra
    public boolean isElementPresence(WebDriver driver, String locator) {
        try {
            driver.findElement(getByLocator(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //ALERT
    public Alert waitForAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.alertIsPresent());
    }

    //Clear ko xoa
    public void clearByKeyboard(WebDriver driver, String locator) {
        WebElement element = getWebElement(getDynamicLocator(locator));
        element.click();
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }

    public void clearByJS(WebDriver driver, String locator) {
        WebElement element = getWebElement(getDynamicLocator(locator));
        js.executeScript("arguments[0].value=''", element);
    }

    public void clickByJS(WebDriver driver, String locator) {
        WebElement element = getWebElement(getDynamicLocator(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void scrollToBottomPage(WebDriver driver) {
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void scrollToElement(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});",
                element
        );
    }


    // ================= DROPDOWN =================
    public void selectDropdown(WebDriver driver, String locator, String itemText ) {
        new Select(getElement(driver, locator)).selectByVisibleText(itemText);
    }

    public void selectDropdown(WebDriver driver, String locator, String itemText, String...restParams ) {
        new Select(getElement(driver, getDynamicLocator(locator, restParams))).selectByVisibleText(itemText);
    }

    public String getFirstSelectedOptionText(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String xpathParent, String xpathChild, String expectedText) {
        getElement(driver, xpathParent).click();
        sleepInSecond(2);
        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(xpathChild)));
        for (WebElement tempElement : allItems) {

            if (tempElement.getText().contains(expectedText)) {

                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoViewIfNeeded(true);", tempElement);
                sleepInSecond(5);

                tempElement.click();
                break;
            }
        }
    }
    public void selectItemInCustomDropdownByIndex(WebDriver driver, String xpathParent, String xpathChild, int index) {
    // mở dropdown
    getElement(driver, xpathParent).click();

    List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(xpathChild)));

    if (index < 0 || index >= allItems.size()) {
        throw new RuntimeException("Index " + index + " is out of range. Total items: " + allItems.size());
    }

    WebElement item = allItems.get(index);

    ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block:'center'});", item);

    item.click();
}


    // ================= SIZE =================
    public int getListElementSize(WebDriver driver, String locator) {
        return getListElement(driver, locator).size();
    }

    public int getListElementSize(WebDriver driver, String locator, String...restParams) {
        return getListElement(driver, getDynamicLocator(locator, restParams)).size();
    }

    // ================= HOVER =================
    public void hoverToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getElement(driver, locator)).perform();

    }

    public void hoverToElement(WebDriver driver, String locator, String...restParams) {
        new Actions(driver).moveToElement(getElement(driver, getDynamicLocator(locator, restParams))).perform();

    }

    //----------------------------------Upload multiple files
    public void uploadMultipleFiles(WebDriver driver, String...fileNames) {
        String filePath = System.getProperty("user.dir") + "\\uploadFiles\\";
        String fullFileName = "";
        for(String file : fileNames) {
            fullFileName = fullFileName + filePath + file + "\n";
        }
        fullFileName = fullFileName.trim();
        getElement(driver, BaseElementUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
    }

    public boolean isFileDownloadedSuccess(String fileName) {
        String downloadPath = System.getProperty("user.dir") + "\\downloadFiles\\";
        File file = new File(downloadPath + fileName);

        int timeWait = 0;
        while (timeWait < 20) { // đợi tối đa 20s
            if (file.exists() && file.length() > 0) {
                return true;
            }
            sleepInSecond(1);
            timeWait++;
        }
        return false;
    }

    public boolean isFileDownloadedWithExtension(String extension) {
        String downloadPath = "C:\\Users\\HDG\\Downloads\\";
        File folder = new File(downloadPath);

        int timeWait = 0;
        while (timeWait < 30) { // đợi tối đa 30s
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().endsWith(extension)
                            && !file.getName().contains("crdownload")
                            && file.length() > 0) {
                        return true;
                    }
                }
            }
            sleepInSecond(1);
            timeWait++;
        }
        return false;
    }
}


