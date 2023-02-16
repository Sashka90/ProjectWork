package pages;

import data.DateData;
import data.EventsMenuItemsData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import waiters.Waiters;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EventsPage extends AbsBasePage{
    public EventsPage(WebDriver driver) {
        super(driver, "events/near/");
    }

    @FindBy (css = ".footer2__container")
    public WebElement footer;

    @FindBy(css = ".dod_new-event__time")
    public List<WebElement> eventsTime;

    @FindBy (css = ".dod_new-event__type")
    public List<WebElement> eventTypeList;

    private final static String dropdownMenuLocator = ".dod_new-events-dropdown";

    private final static String allEventsListTemplate = "%s__list-item[title='%s']";

    public void clickDropdownMenuItem(EventsMenuItemsData item) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({'block': 'center', 'inline': 'center'})", driver.findElement(By.cssSelector(dropdownMenuLocator)));
        Waiters wait = new Waiters(driver);
        String selector = String.format(allEventsListTemplate, dropdownMenuLocator, item.getName());
        driver.findElement(By.cssSelector(dropdownMenuLocator)).click();
        wait.waitForCondition(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(selector))));
        driver.findElement(By.cssSelector(selector)).click();
    }

    public void checkEventsCardTile(EventsMenuItemsData eventsMenuItemsData) {
        for(WebElement element : eventTypeList) {
            Assertions.assertTrue(element.getText().contains(eventsMenuItemsData.getName()));
        }
    }

    public void checkEventsDate() {
        scrollDownOfPage();
        List<String> eventsListToString = new ArrayList<>();
        List<LocalDateTime> eventsDateList = new ArrayList<>();
        String monthOfEvent;
        String dateOfEvent;

        for (WebElement element : eventsTime) {
            eventsListToString.add(element.getText());
        }
        for (String string : eventsListToString) {
            monthOfEvent = string.split(" ")[1];
            dateOfEvent = string.replaceAll("[а-я]+", String.format("%d", DateData.getDate(monthOfEvent).getNumber()));
            dateOfEvent += " " + LocalDate.now().getYear();
            dateOfEvent = dateOfEvent.charAt(0) + dateOfEvent.substring(1).toLowerCase();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d M HH:mm yyyy", Locale.ROOT);
            LocalDateTime localDateTime = LocalDateTime.parse(dateOfEvent, formatter);

            if (localDateTime.equals("Сейчас в эфире")) {
                eventsDateList.add(LocalDateTime.now());
            } else {
                eventsDateList.add(localDateTime);
            }
        }
        for (LocalDateTime localDateTime : eventsDateList) {
            Assertions.assertTrue(localDateTime
                    .isAfter(localDateTime.now()) || localDateTime.isEqual(localDateTime.now()));
        }
    }

    private void scrollDownOfPage() {
        for (int i = 0; i <= 100; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth'})", footer);
        }
    }
}
