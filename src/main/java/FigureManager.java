import java.util.ArrayList;
import java.util.List;

public class FigureManager {

    protected List<Figure> figures = new ArrayList<>();

    public void addNewFigure(Figure f) {
        figures.add(f);
    }

    public double calculateTotalArea() {
        double result = 0;
        for(Figure f : figures) {
            result += f.getArea();
        }
        return result;
    }

    public double calculateTotalPerimeter() {
        double result = 0;
        for(Figure f : figures) {
            result += f.getPerimeter();
        }
        return result;
    }

}
