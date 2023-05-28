package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HerokuappPage {


    public HerokuappPage(){


        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(tagName = "h3")
    public WebElement openingWindowText;

    @FindBy(xpath = "//a[text()='Click Here']")
    public WebElement clickHereButton;

    @FindBy(tagName = "h3")
    public WebElement newWindowText;

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    public WebElement jsAlert;

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    public WebElement jsConfirmAlert;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    public WebElement jsPromptAlert;

    @FindBy(id = "result")
    public WebElement resultText;





}
