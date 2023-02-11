package data;

public enum CourseCatalogData {
    CARDS("a[@href]"),
    SHOW_MORE_BUTTON("button");

    private String name;

    CourseCatalogData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
