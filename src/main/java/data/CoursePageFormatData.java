package data;

public enum CoursePageFormatData {

    LEARNING_TIME("Длительность обучения"),
    LEARNING_FORMAT("Формат");

    private String name;

    CoursePageFormatData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
