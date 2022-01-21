package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPOM {
    WebDriver driver;
    WebDriverWait wait;

    private String domain = "http://localhost:4200/";

    @FindBy(name = "username")
    WebElement usernameInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(id = "login-btn")
    WebElement loginBtn;

    @FindBy(id = "register-btn")
    WebElement registerBtn;

    @FindBy(id = "forgot-btn")
    WebElement forgotBtn;


    public LoginPOM(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        PageFactory.initElements(this.driver, this);
    }

    public void enterUsername(String username){
        this.usernameInput.sendKeys(username);
    }
    public void enterPassword(String password){
        this.passwordInput.sendKeys(password);
    }

    public void submitLogin(){
        this.loginBtn.click();
    }

    public void clickRegister(){
        this.registerBtn.click();
    }
    public void forgotPassword(){
        this.forgotBtn.click();
    }
//    public void
    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }

    public void waitForSuccessfulLogin() {
        this.wait.until((ExpectedConditions.urlToBe(this.domain + "mainpage")));
    }

    public void waitForForgotPassword() {
        this.wait.until((ExpectedConditions.urlToBe(this.domain + "forgotPassword")));
    }
    public void waitForRegisterLoad() {
        this.wait.until((ExpectedConditions.urlToBe(this.domain + "register")));
    }
}
