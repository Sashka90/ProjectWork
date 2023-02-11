package data;

public enum HeaderMenuData {
    LEARNING("learning"),
    INFORMATION("info");

    private String name;

    HeaderMenuData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
