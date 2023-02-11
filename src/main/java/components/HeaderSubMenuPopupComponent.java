package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import data.HeaderSubMenuPopupData;
import org.openqa.selenium.support.ui.ExpectedConditions;
import waiters.Waiters;

public class HeaderSubMenuPopupComponent extends AbsBaseComponent {

    public HeaderSubMenuPopupComponent(WebDriver driver) {
        super(driver);
    }

    private final static String headerSubMenuItemTemplate = "(//*[contains(@class, 'header3__nav-item-popup-content')]//a[contains(text(), '%s')])[1]";

    public void headerSubMenuItemClick(HeaderSubMenuPopupData headerSubMenuPopupData) {
        Waiters wait = new Waiters(driver);
        String locator = String.format(headerSubMenuItemTemplate, headerSubMenuPopupData.getName());
        wait.waitForCondition(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        driver.findElement(By.xpath(locator)).click();
    }

}
