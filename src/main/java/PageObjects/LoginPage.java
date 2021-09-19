package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    private By loginWithEmail = By.xpath(("//div[contains(text(),'Continue with Email or Apple')]"));
    private By email = By.xpath("//input[contains(@placeholder,'your@email.com')]");
    private By next = By.xpath("//button[contains(@type,'submit')]");
    private By password = By.xpath("//input[@placeholder='Password']");
    private By submit = By.xpath("//button[@type='submit']");

    public WebElement login() {
        return driver.findElement(By.xpath("//a[contains(@class,'-secondary')]"));
    }

    public WebElement submit() {
        return driver.findElement(submit);
    }

    public WebElement password() {
        return driver.findElement(password);
    }

    public WebElement next() {
        return driver.findElement(next);
    }

    public WebElement email() {
        return driver.findElement(email);
    }

    public WebElement loginWithEmail() {
        return driver.findElement(loginWithEmail);
    }
}
