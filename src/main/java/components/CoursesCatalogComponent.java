package components;

import data.CourseCatalogData;
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

    private final static String courseCatalogElementsTemplate = "//h1//ancestor::section//child::%s";

    public void checkCountCourseCards(int count){
        String showMoreButtonLocator = String.format(courseCatalogElementsTemplate, CourseCatalogData.SHOW_MORE_BUTTON.getName());
        String cardsLocator = String.format(courseCatalogElementsTemplate, CourseCatalogData.CARDS.getName());
        Waiters wait = new Waiters(driver);
        if (isShowMoreButtonPresent()){
            wait.waitForCondition(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(showMoreButtonLocator))));
            driver.findElement(By.xpath(showMoreButtonLocator)).click();
        }
        wait.waitCountOfElements(By.xpath(cardsLocator), count);
    }

    public void clickCourseCard(int courseCard){
        String cardsLocator = String.format(courseCatalogElementsTemplate, CourseCatalogData.CARDS.getName());
        driver.findElements(By.xpath(cardsLocator)).get(courseCard).click();
    }

    private boolean isShowMoreButtonPresent() {
        String showMoreButtonLocator = String.format(courseCatalogElementsTemplate, CourseCatalogData.SHOW_MORE_BUTTON.getName());
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(showMoreButtonLocator)));
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }
}
