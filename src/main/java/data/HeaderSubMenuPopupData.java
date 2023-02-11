package data;

public enum HeaderSubMenuPopupData {
    QA("Тестирование"),
    GAMEDEV("GameDev"),
    ANALITICS("Аналитика"),
    EVENTS("Календарь мероприятий");


    private String name;

    HeaderSubMenuPopupData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
