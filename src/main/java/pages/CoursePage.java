package pages;

import data.CoursePageFormatData;
import data.CoursePageTitlesData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoursePage extends AbsBasePage{

    public CoursePage(WebDriver driver) {
        super(driver, "/lessons/");
    }

    private final static String titlesCourseTemplate = "//*[@class='course-header2__%s']";
    private final static String formatCourseTemplate = "//p[contains(text(),'%s')]/following::*[1]";

    public void checkTitlesCourse(){
        String locatorTitle = String.format(titlesCourseTemplate, CoursePageTitlesData.TITLE.getName());
        String locatorSubTitle = String.format(titlesCourseTemplate, CoursePageTitlesData.SUBTITLE.getName());
        Assertions.assertNotEquals(driver.findElement(By.xpath(locatorTitle)).getText(),"");
        Assertions.assertNotEquals(driver.findElement(By.xpath(locatorSubTitle)).getText(),"");
    }

    public void checkFormatCourse(){
        String locatorLearningTime = String.format(formatCourseTemplate, CoursePageFormatData.LEARNING_TIME.getName());
        String locatorFormat = String.format(formatCourseTemplate, CoursePageFormatData.LEARNING_FORMAT.getName());
        Assertions.assertNotEquals(driver.findElement(By.xpath(locatorLearningTime)).getText(), "");
        Assertions.assertNotEquals(driver.findElement(By.xpath(locatorFormat)).getText(), "");
    }
}

