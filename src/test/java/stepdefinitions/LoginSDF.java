package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.LoginPOM;

public class LoginSDF {

    LoginPOM loginPOM;

    private String domain = "http://localhost:4200/";



    @After
    public void tearDown(){
        DriverSingleton.quitInstance();
    }

    @Given("A user is on the Login page")
    public void a_user_is_on_the_login_page() throws InterruptedException {
        DriverSingleton.getInstance().get(this.domain);
        Thread.sleep(5000);
        this.loginPOM = new LoginPOM(DriverSingleton.getInstance());
        Assertions.assertEquals(this.domain, this.loginPOM.getCurrentUrl());

    }
    @When("A user inputs valid credentials on the login form")
    public void a_user_inputs_valid_credntials_on_the_login_form() throws InterruptedException {
      this.loginPOM.enterUsername("jakarai");
      this.loginPOM.enterPassword("password");
      this.loginPOM.submitLogin();
      Thread.sleep(5000);
    }
    @Then("The user will be brought to the dashboard")
    public void a_user_will_be_brought_to_the_dashboard() {
       this.loginPOM.waitForSuccessfulLogin();
    }
    @When("A user inputs invalid credentials on the login form")
    public void a_user_inputs_invalid_credentials_on_the_login_form() throws InterruptedException{
        this.loginPOM.enterUsername("test");
        this.loginPOM.enterPassword("dummy");
        this.loginPOM.submitLogin();
        Thread.sleep(2000);
    }
    @Then("The user will be given an invalid login message")
    public void the_user_will_be_given_an_invalid_login_message() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("A user clicks the register button")
    public void a_user_clicks_the_register_button() throws InterruptedException{
       this.loginPOM.clickRegister();
        Thread.sleep(2000);
    }
    @Then("The user is brought to the register page")
    public void the_user_is_brought_to_the_register_page() {

        this.loginPOM.waitForRegisterLoad();
        Assertions.assertEquals(this.domain + "register", this.loginPOM.getCurrentUrl());
    }
    @When("A user clicks the forgot password button")
    public void a_user_clicks_the_forgot_password_button() throws InterruptedException{
        this.loginPOM.forgotPassword();
        Thread.sleep(2000);
    }
    @Then("The user is brought to the reset password page")
    public void the_user_is_brought_to_the_reset_password_page() {
        this.loginPOM.waitForForgotPassword();
        Assertions.assertEquals(this.domain + "forgotPassword", this.loginPOM.getCurrentUrl());
    }

}
