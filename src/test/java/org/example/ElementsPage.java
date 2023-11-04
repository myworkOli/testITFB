package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage {

    public WebDriver driver;
    public ElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//span[text()= \"Text Box\"]/..")
    private WebElement textBoxBtn;
    @Step("Нажать на «Text box»")
    public void clickTextBoxBtn(){
        textBoxBtn.click();
    }

}
