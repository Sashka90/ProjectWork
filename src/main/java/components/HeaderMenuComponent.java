package components;

import data.HeaderMenuData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HeaderMenuComponent extends AbsBaseComponent{

    public HeaderMenuComponent(WebDriver driver) {
        super(driver);
    }

    private final static String headerMenuItemTemplate = "[data-name='%s'].header3__nav-item";

    public void moveToMenuItem(HeaderMenuData headerMenuData) {
        String selector = String.format(headerMenuItemTemplate, headerMenuData.getName());
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector(selector))).build().perform();

    }


}
