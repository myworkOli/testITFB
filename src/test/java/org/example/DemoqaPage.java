package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoqaPage {

    public WebDriver driver;
    public DemoqaPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//h5[text()=\"Elements\"]")
    private WebElement elementBtn;
    @Step("Нажать на «Elements»")
    public void clickElementBtn() {
        elementBtn.click();
    }

}
