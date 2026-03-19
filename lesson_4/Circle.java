package lesson_4;

public class Circle implements Figure{
    double radius;
    String fillColor;
    String borderColor;
    public Circle(double r, String fill, String border){
        radius = r;
        fillColor = fill;
        borderColor = border;
    }
    public double getArea(){
        return 3.14 * radius * radius;
    }
    public double getPerimeter(){
        return 2 * 3.14 * radius;
    }
    public String getFillColor(){
        return fillColor;
    }
    public String getBorderColor(){
        return borderColor;
    }
    public String getName(){
        return "Круг";
    }
}
