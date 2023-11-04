package org.example;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage {
    public WebDriver driver;
    public TextBoxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//input[@id=\"userName\"]")
    private WebElement userName;
    @FindBy(xpath = "//input[@id=\"userEmail\"]")
    private WebElement userEmail;
    @FindBy(xpath = "//textarea[@id=\"currentAddress\"]")
    private WebElement userCurrentAddress;
    @FindBy(xpath = "//textarea[@id=\"permanentAddress\"]")
    private WebElement userPermanentAddress;
    @FindBy(xpath = "//button[@id=\"submit\"]")
    private WebElement submitBtn;
    @FindBy (css ="#name")
    private WebElement outputUserName;
    @FindBy (css ="#email")
    private WebElement outputUserEmail;
    @FindBy (css ="#currentAddress.mb-1")
    private WebElement outputCurrentAddress;
    @FindBy (css ="#permanentAddress.mb-1")
    private WebElement outputPermanentAddress;
    @FindBy (xpath = "//span[text()=\"Buttons\"]")
    private WebElement buttonsBtn;

    @Step("Нажать на кнопку «Submit»")
    public void clicksubmitBtn(){
        submitBtn.click();
    }
    @Step("Нажать на «Buttons»")
    public void clickButtonBtn(){
        buttonsBtn.click();
    }
    @Step ("Заполнить поля: Full Name, Email, Current Address, Permanent Address")
    public void addTextBox(String name, String email,String address,String addressPermanent ){
        userName.sendKeys(name);
        userEmail.sendKeys(email);
        userCurrentAddress.sendKeys(address);
        userPermanentAddress.sendKeys(addressPermanent);
    }
    public String getOutputUserName(){
        return outputUserName.getText();
    }
    public String getOutputUserEmail(){
        return outputUserEmail.getText();
    }
    public String getCurrentAddress(){
        return outputCurrentAddress.getText();
    }
    public String getPermanentAddress(){
        return outputPermanentAddress.getText();
    }
    @Step ("Проверить, что данные в блоке сохранены корректно")
    public void checkingOutputData(String name, String email, String currentAddress, String permanentAddress){
        Assertions.assertTrue(getOutputUserName().contains(name),"Добавленное имя не соответсвтвует исходному");
        Assertions.assertTrue(getOutputUserEmail().contains(email),"Добавленный email не соответсвтвует исходному");
        Assertions.assertTrue(getCurrentAddress().contains(currentAddress),"Добавленный текущий адрес не соответсвтвует исходному");
        Assertions.assertTrue(getPermanentAddress().contains(permanentAddress),"Добавленный  постоянный адрес не соответсвтвует исходному");
    }
}
