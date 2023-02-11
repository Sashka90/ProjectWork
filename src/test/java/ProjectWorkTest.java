import components.CoursesCatalogComponent;
import components.HeaderMenuComponent;
import components.HeaderSubMenuPopupComponent;
import data.HeaderSubMenuPopupData;
import exceptions.BrowserNotSupportedException;
import factories.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.CoursePage;
import pages.EventsPage;
import pages.MainPage;

import static data.EventsMenuItemsData.OPEN_WEBINAR;
import static data.HeaderMenuData.LEARNING;
import static data.HeaderSubMenuPopupData.EVENTS;

public class ProjectWorkTest {

    private WebDriver driver;

    @BeforeAll
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void init() throws BrowserNotSupportedException {
        driver = new WebDriverFactory().createDriver();
    }

    @AfterEach
    public void close(){
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void TestCards() {
        MainPage mainPage = new MainPage(driver);
        HeaderMenuComponent headerMenuComponent = new HeaderMenuComponent(driver);
        HeaderSubMenuPopupComponent headerSubMenuPopupComponent = new HeaderSubMenuPopupComponent(driver);
        CoursesCatalogComponent coursesCatalogComponent = new CoursesCatalogComponent(driver);
        CoursePage coursePage = new CoursePage(driver);

        mainPage.open();
        headerMenuComponent.moveToMenuItem(LEARNING);
        headerSubMenuPopupComponent.headerSubMenuItemClick(HeaderSubMenuPopupData.QA);
        coursesCatalogComponent.checkCountCourseCards(12);
        coursesCatalogComponent.clickCourseCard(2);
        coursePage.checkTitlesCourse();
        coursePage.checkFormatCourse();
    }

    @Test
    public void TestEvents() {
        MainPage mainPage = new MainPage(driver);
        HeaderSubMenuPopupComponent headerSubMenuPopupComponent = new HeaderSubMenuPopupComponent(driver);
        HeaderMenuComponent headerMenuComponent = new HeaderMenuComponent(driver);
        EventsPage eventsPage = new EventsPage(driver);

        mainPage.open();
        headerMenuComponent.moveToMenuItem(LEARNING);
        headerSubMenuPopupComponent.headerSubMenuItemClick(EVENTS);
        eventsPage.checkEventsDate();
        eventsPage.clickDropdownMenuItem(OPEN_WEBINAR);
        eventsPage.checkEventsCardTile(OPEN_WEBINAR);
    }
}
