package data;

public enum EventsMenuItemsData {
    ALL("Все мероприятия"),
    INTENSIVE("Интенсивы"),
    DAY_OF_OPEN_DOORS("ДОД"),
    OPEN_WEBINAR("Открытый вебинар"),
    ONLINE_MEETUP("Онлайн митап");

    private String name;


    EventsMenuItemsData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
