package data;

public enum CoursePageTitlesData {

    TITLE("title"),
    SUBTITLE("subtitle");

    private String name;

    CoursePageTitlesData(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
