package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By createTask = By.xpath("//span[@class='AppHeaderNewTaskButton__button__text']");
    private By taskName = By.xpath("//div[@class='SmartTypeNewTaskModalTextFieldWrapper__content']//div//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']");
    private By submitTask = By.xpath("//button[@class='ButtonsBar__button']");

    public WebElement createTask() {
        return driver.findElement(createTask);
    }

    public WebElement taskName() {
        return driver.findElement(taskName);
    }

    public WebElement submitTask() {
        return driver.findElement(submitTask);
    }

    public WebElement clickSettings() {
        return driver.findElement(By.xpath("//button[@aria-label='Settings']"));
    }

    public WebElement clickMyProfile() {
        return driver.findElement(By.xpath("//div[normalize-space()='My Profile']"));
    }

    public WebElement clickSignOut() {
        return driver.findElement(By.xpath("//div[normalize-space()='Sign Out']"));
    }
}
