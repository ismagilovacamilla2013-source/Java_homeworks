package lesson_4;

public class Rectangle implements Figure {
    double width;
    double height;
    String fillColor;
    String borderColor;
    public Rectangle (double w, double h, String fill, String border){
        width = w;
        height = h;
        fillColor = fill;
        borderColor = border;
    }
    public double getArea(){
        return width * height;
    }
    public double getPerimeter(){
        return 2 * (width + height);
    }
    public String getFillColor(){
        return fillColor;
    }
    public String getBorderColor(){
        return borderColor;
    }
}
