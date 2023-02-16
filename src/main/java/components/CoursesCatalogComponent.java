package components;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waiters.Waiters;

import java.time.Duration;

public class CoursesCatalogComponent extends AbsBaseComponent{
    public CoursesCatalogComponent(WebDriver driver) {
        super(driver);
    }

    private final static String showMoreButton = "//h1//ancestor::section//child::button";
    private final static String courseCards = "//h1//ancestor::section//child::a[@href]";

    public void checkCountCourseCards(int count){
        Waiters wait = new Waiters(driver);
        if (isShowMoreButtonPresent()){
            wait.waitForCondition(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(showMoreButton))));
            driver.findElement(By.xpath(showMoreButton)).click();
        }
        wait.waitCountOfElements(courseCards, count);
    }

    public void clickCourseCard(int courseCard){
        driver.findElements(By.xpath(courseCards)).get(courseCard).click();
    }

    private boolean isShowMoreButtonPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(showMoreButton)));
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }
}
