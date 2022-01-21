package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainPagePOM {

    WebDriver driver;
    WebDriverWait wait;


    @FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a")
    WebElement picsBtn;

    @FindBy(id = "mypics-btn")
    WebElement picBtn;

    @FindBy(id = "feed-btn")
    WebElement feedBtn;

    @FindBy(id = "post-input")
    WebElement postArea;

    @FindBy(id = "post-btn")
    WebElement postBtn;

    @FindBy(id = "navbarDropdown")
    WebElement accountBtn;

    @FindBy(id = "navbar-burger")
    WebElement navBurger;

    @FindBy(id = "logout-btn")
    WebElement logoutBtn;

    @FindBy(id = "changePass-page")
    WebElement changePassPage;

    @FindBy(className = "post-container")
    List<WebElement> postList = new ArrayList<>();


    public MainPagePOM(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        PageFactory.initElements(this.driver, this);
    }

    public void viewPics(){
        this.picBtn.click();
    }
    public void viewFeed(){
        this.feedBtn.click();
    }
    public String postInput(String post){
        this.postArea.sendKeys(post);
        return post;
    }
    public void submitPost(){
        this.postBtn.click();
    }
    public void dropdownNav(){
        this.navBurger.click();
    }

    public void dropdownAccount(){
        this.accountBtn.click();
    }
    public void submitLogout(){
        this.logoutBtn.click();
    }

    public boolean checkForPost(String postContent){
        for (WebElement post : this.postList){
            if (getPost(post).equals(postContent)){
                return true;
            }
        }
        return false;
    }

    private String getPost(WebElement post){
        List<WebElement> newPost = post.findElements(By.className("post-container"));
        return newPost.get(newPost.size()-1).getText().toLowerCase(Locale.ROOT);
    }

    private WebElement getNewPost(String newPost){
        for (WebElement post : this.postList){
            if(getPost(post).equals(newPost)){
                return post;
            }
        }
        return null;
    }

    public boolean waitForPostAdded(){
        this.postList = this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("post-container"),this.postList.size()));
        if (this.postList != null){
            return true;
        }
        return false;
    }

    public void refreshPage(){
        this.driver.navigate().refresh();
    }
}
