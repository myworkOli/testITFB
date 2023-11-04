package org.example;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.example.DemoqaTest.wait;

public class ButtonsPage {
    public WebDriver driver;
    public Actions actions;

    public ButtonsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[text()=\"Click Me\"]")
    private WebElement clickMeBtn;
    @FindBy(xpath = "//button[@id=\"rightClickBtn\"]")
    private WebElement rightClickBtn;
    @FindBy(xpath = "//*[text()=\"You have done a dynamic click\"]")
    private WebElement clickMeText;
    @FindBy(xpath = "//*[text()=\"You have done a right click\"]")
    private WebElement rightClickText;
    @FindBy(css = ".element-group:nth-child(3)")
    private WebElement alertsFrameWindowsBtn;
    @FindBy(css = "#doubleClickBtn")
    private WebElement doubleClickBtn;
    @FindBy(xpath = "//*[text()=\"You have done a double click\"]")
    private WebElement doubleClickText;
    @FindBy(xpath = "//*[text()=\"Browser Windows\"]")
    private WebElement browserWindowsBtn;


    @Step("Нажать на кнопку «Click me»")
    public void clickMeBtn() {
        clickMeBtn.click();
    }
    @Step("Нажать на «Alerts, Frame & Windows»")
    public void clickAlertsFrameWindowsBtn(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", alertsFrameWindowsBtn);
        alertsFrameWindowsBtn.click();
    }
    @Step("Нажать на «Browser Windows»")
    public void clickBrowserWindowsBtn(){
        browserWindowsBtn.click();
    }
    @Step("Нажать на кнопку «Right Click me»")
    public void rClickRightClickBtn() {
        actions = new Actions(driver);
        actions.contextClick(rightClickBtn).perform();
    }
    @Step ("Нажать на кнопку «Double Click me»")
    public void dclickdoubleClickBtn(){
        actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).perform();
    }

    @Step("Проверить, что появился текст «You have done a dynamic click»")
    public void checkingClickMeText() {
        try {
            Assertions.assertTrue(clickMeText.isDisplayed(),
                    "надпись 'You have done a dynamic click' не появилась на экране");
        } catch (NoSuchElementException e) {
            System.out.println("надписи 'You have done a dynamic click' нет на экране" + e.getMessage());
        }
    }

    @Step("Проверить, что появился текст «You have done a right click»")
    public void checkingRightClickText() {
        try {
            Assertions.assertTrue(rightClickText.isDisplayed(),
                    "надпись 'You have done a right click' не появилась на экране");
        } catch (NoSuchElementException e) {
            System.out.println("надписи 'You have done a right click' нет на экране" + e.getMessage());
        }
    }
    @Step("Проверить, что появился текст «You have done a double click»")
    public void checkingDoubleClickBtn() {
        try {
            Assertions.assertTrue(doubleClickText.isDisplayed(),
                    "надпись 'You have done a double click' не появилась на экране");
        } catch (NoSuchElementException e) {
            System.out.println("надписи 'You have done a double click' нет на экране" + e.getMessage());
        }
    }
}
