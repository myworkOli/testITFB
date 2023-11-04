package org.example;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.example.DemoqaTest.wait;

public class AlertsPage {

    public WebDriver driver;

    public AlertsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "#alertButton")
    private WebElement alertBtn;
    @FindBy(css = "#timerAlertButton")
    private WebElement timerAlertBtn;
    @FindBy(css = "#confirmButton")
    private WebElement confirmBtn;
    @FindBy(css = "#confirmResult")
    private WebElement confirmResult;
    @FindBy(css = "#promtButton")
    private WebElement promtBtn;
    @FindBy(css = "#promptResult")
    private WebElement promptResult;

    @Step("Нажать на кнопку «Click me»  рядом с Click Button to see alert")
    public void clickAlertBtn() {
        alertBtn.click();
    }

    @Step("Нажать на кнопку «Click me»  рядом с On button click, alert will appear after 5 secondst")
    public void clickTimerAlertBtn() {
        timerAlertBtn.click();
    }

    @Step("Нажать на кнопку «Click me»  рядом с On button click, confirm box will appear")
    public void clickConfirmBtn() {
        confirmBtn.click();
    }

    @Step("Нажать на кнопку «Click me»  рядом с On button click, prompt box will appear")
    public void clickPromtBtn() {
        promtBtn.click();
    }
    @Step("Закрыть уведомление")
    public void closeAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.dismiss();;
    }
    @Step("Нажать на кнопку «Да» в уведомление")
    public void closeOkAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Step("Проверить, что появился текст You selected Ok")
    public void chekingConfirmResult() {
        String text = confirmResult.getText();
        Assertions.assertEquals(text, "You selected Ok", "Вы нажали не ОК");
    }
    @Step("Проверить, что появился текст You entered Test name")
    public void chekingPromptBoxResult() {
        String text = promptResult.getText();
        Assertions.assertEquals(text, "You entered Test name", "Отправлен неверный текст ");
    }
    @Step("Заполнить поле в уведомление данными: {text}")
    public void closePromptBox(String text) {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }
}
