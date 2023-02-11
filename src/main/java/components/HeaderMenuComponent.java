package components;

import data.HeaderMenuData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HeaderMenuComponent extends AbsBaseComponent{

    public HeaderMenuComponent(WebDriver driver) {
        super(driver);
    }

    private final static String headerMenuItemTemplate = "[data-name='%s'].header3__nav-item";

    @FindBy(xpath = "//button[@class = 'header3__button-sign-in']")
    public WebElement signInButton;

    @FindBy(xpath = "//*[@data-name='user-info']")
    public WebElement userInfo;

    public void moveToMenuItem(HeaderMenuData headerMenuData) {
        String selector = String.format(headerMenuItemTemplate, headerMenuData.getName());
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector(selector))).build().perform();

    }


}
