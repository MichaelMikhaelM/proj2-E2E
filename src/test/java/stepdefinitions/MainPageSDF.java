package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import poms.LoginPOM;
import poms.MainPagePOM;

public class MainPageSDF {

    LoginPOM loginPOM;
    MainPagePOM mainPagePOM;
    WebDriver driver;

    private String domain = "http://localhost:4200/";
    private String post = "Hello world this is my post";


    @After
    public void tearDown(){
        DriverSingleton.quitInstance();
    }


    @Given("A user is on the Main Page")
    public void a_user_is_on_the_main_page() {
        DriverSingleton.getInstance().get(this.domain);
        this.loginPOM = new LoginPOM(DriverSingleton.getInstance());
        this.loginPOM.enterUsername("jakarai");
        this.loginPOM.enterPassword("newpass");
        this.loginPOM.submitLogin();
        this.loginPOM.waitForSuccessfulLogin();

        this.mainPagePOM = new MainPagePOM(DriverSingleton.getInstance());


    }
    @When("A user creates a post in the post area")
    public void a_user_creates_a_post_in_the_post_area() {
        this.mainPagePOM.postInput(this.post);
        this.mainPagePOM.submitPost();
    }
    @Then("A post is made")
    public void a_post_is_made() {
        this.mainPagePOM.waitForPostAdded();
        this.mainPagePOM.checkForPost(this.post);
    }

    @When("a user clicks view pictures")
    public void a_user_clicks_view_pictures() {
        this.mainPagePOM.refreshPage();
        this.mainPagePOM.dropdownNav();
        this.mainPagePOM.viewPics();
    }
    @Then("The user will be taken to their picture page")
    public void the_user_will_be_taken_to_their_picture_page() {
        Assertions.assertEquals(this.domain + "mypics", this.loginPOM.getCurrentUrl());

    }

    @When("A user clicks Feed to view their feed")
    public void a_user_clicks_feed_to_view_their_feed() {
       this.mainPagePOM.viewFeed();
    }
    @Then("The user will be brought to their feed")
    public void the_user_will_be_brought_to_their_feed() {
        Assertions.assertEquals(this.domain + "feed", this.loginPOM.getCurrentUrl());
    }

    @When("A user clicks the logout button")
    public void a_user_clicks_the_logout_button() {
       this.mainPagePOM.dropdownNav();
       this.mainPagePOM.dropdownAccount();
       this.mainPagePOM.submitLogout();
    }
    @Then("The user will be brought to the login page")
    public void the_user_will_be_brought_to_the_login_page() {

        Assertions.assertEquals(this.domain, this.loginPOM.getCurrentUrl());

    }

}
