package lesson_4;

public interface Figure {
    double getArea();
    double getPerimeter();
    String getFillColor();
    String getBorderColor();
    default String getFigureName() {
        return this.getClass().getSimpleName();
    }
}
