package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class DemoqaTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static DemoqaPage demoqaPage;
    public static ElementsPage elementsPage;
    public static TextBoxPage textBoxPage;
    public static ButtonsPage buttonsPage;
    public static BrowserWindowsPage browserWindowsPage;
    public static AlertsPage alertsPage;


    @Step("В браузере открыть: https://demoqa.com/")
    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        demoqaPage = new DemoqaPage(driver);
        elementsPage = new ElementsPage(driver);
        textBoxPage = new TextBoxPage(driver);
        buttonsPage = new ButtonsPage(driver);
        browserWindowsPage = new BrowserWindowsPage(driver);
        alertsPage = new AlertsPage(driver);
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000L));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://demoqa.com/");

    }


    @Test
    @Description(value = "Тест.Взаимодействия с веб элементами")
    public void loginTest() {
        String userName, email, currentAddress, permanentAddress, sentText;
        userName = "Ivanov Ivan";
        email = "ii@ya.ru";
        currentAddress = "USSR";
        permanentAddress = "Moscow";
        sentText = "Test name";
        String window0 = driver.getWindowHandle();

        demoqaPage.clickElementBtn();
        elementsPage.clickTextBoxBtn();
        textBoxPage.addTextBox(userName, email, currentAddress, permanentAddress);
        textBoxPage.clicksubmitBtn();
        textBoxPage.checkingOutputData(userName, email, currentAddress, permanentAddress);
        textBoxPage.clickButtonBtn();
        buttonsPage.clickMeBtn();
        buttonsPage.checkingClickMeText();
        buttonsPage.rClickRightClickBtn();
        buttonsPage.checkingRightClickText();
        buttonsPage.dclickdoubleClickBtn();
        buttonsPage.checkingDoubleClickBtn();
        buttonsPage.clickAlertsFrameWindowsBtn();
        buttonsPage.clickBrowserWindowsBtn();
        browserWindowsPage.clickNewTabBtn();
        browserWindowsPage.closeNewWindow(window0);
        browserWindowsPage.clickNnewWindowBtn();
        browserWindowsPage.closeNewWindow(window0);
        browserWindowsPage.clickAlerts();
        alertsPage.clickAlertBtn();
        alertsPage.closeAlert();
        alertsPage.clickTimerAlertBtn();
        alertsPage.closeAlert();
        alertsPage.clickConfirmBtn();
        alertsPage.closeOkAlert();
        alertsPage.chekingConfirmResult();
        alertsPage.clickPromtBtn();
        alertsPage.closePromptBox(sentText);
        alertsPage.chekingPromptBoxResult();
    }

    @Step("Закрыть драйвер")
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}

