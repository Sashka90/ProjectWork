package components;

import org.openqa.selenium.WebDriver;
import pageobject.PageObject;

public class AbsBaseComponent extends PageObject {

    public AbsBaseComponent(WebDriver driver) {
        super(driver);
    }
}
