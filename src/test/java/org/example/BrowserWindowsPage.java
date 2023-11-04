package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class BrowserWindowsPage {
    public WebDriver driver;
    public BrowserWindowsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//*[text()=\"New Tab\"]")
    private WebElement newTabBtn;
    @FindBy(css = "#windowButton")
    private WebElement newWindowBtn;
    @FindBy(xpath = "//*[text()=\"Alerts\"]")
    private WebElement alerts;

    @Step ("Нажать на кнопку «New Tab»")
    public void clickNewTabBtn(){
        newTabBtn.click();
    }
    @Step("Нажать на кнопку «New window»")
    public void clickNnewWindowBtn(){
        newWindowBtn.click();
    }
    @Step("Нажать на «Alerts»")
    public void clickAlerts(){
        alerts.click();
    }
    @Step("Закрыть новое окно")
    public void closeNewWindow(String window0){
        Set<String> correntWindow = driver.getWindowHandles();
        String window1;
        for (String window: correntWindow){
            if (!window.equals(window0)){
                window1=window;
                driver.switchTo().window(window1);
                driver.close();
                driver.switchTo().window(window0);
            }
        }
    }
}
