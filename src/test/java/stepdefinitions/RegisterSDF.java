package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.RegisterPOM;

public class RegisterSDF {

    RegisterPOM registerPOM;

    private String domain = "http://localhost:4200/register";

    @Given("A user is on the register page")
    public void a_user_is_on_the_register_page() throws InterruptedException {
        DriverSingleton.getInstance().get(this.domain);
        Thread.sleep(5000);
        this.registerPOM = new RegisterPOM(DriverSingleton.getInstance());
        Assertions.assertEquals(this.domain, this.registerPOM.getCurrentUrl());
    }
    @When("A user inputs valid registration credentials in the registration form")
    public void a_user_inputs_valid_registration_credentials_in_the_registration_form() {
        this.registerPOM.enterUsername("test");
        this.registerPOM.enterPassword("dummy");
        this.registerPOM.enterEmail("testdummy@gmail.com");
        this.registerPOM.enterFirstname("test");
        this.registerPOM.enterLastname("dummy");
        this.registerPOM.submitRegister();
    }
    @Then("The user will be brought back to the login page")
    public void the_user_will_be_brought_back_to_the_login_page() {

    }
    @When("A user inputs invalid registration credentials in the registration form")
    public void a_user_inputs_invalid_registration_credentials_in_the_registration_form() {
        this.registerPOM.enterUsername("bad");
        this.registerPOM.enterPassword("dummy");
        this.registerPOM.enterEmail("baddummy@gmail.com");
        this.registerPOM.enterFirstname("bad");
        this.registerPOM.enterLastname("test");
        this.registerPOM.submitRegister();
    }
    @Then("An error message will display")
    public void an_error_message_will_display() {

    }


}
