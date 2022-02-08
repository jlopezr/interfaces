import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InterfacesTest {

    private static double mark;
    private static List<String> comments;

    @BeforeClass
    public static void setup() {
        mark = 0;
        comments = new ArrayList<>();
    }

    private void addComment(double n, String comment) {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        mark +=n;
        comments.add("("+methodName+") "+comment+" : "+n);
    }

    @Test
    public void test_circle_methods() {
        Circle c = new Circle(5.0);
        assertThat(c.getArea()).isEqualTo(Math.PI*Math.pow(5.0,2.0));
        assertThat(c.getPerimeter()).isEqualTo(2*Math.PI*5);

        addComment(1, "");
    }

    @Test
    public void test_square_methods() {
        Square c = new Square(8);
        assertThat(c.getArea()).isEqualTo(8*8);
        assertThat(c.getPerimeter()).isEqualTo(8*4);

        addComment(1, "");
    }

    @Test
    public void test_rectangle_methods() {
        Rectangle c = new Rectangle(2,5);
        assertThat(c.getArea()).isEqualTo(2*5);
        assertThat(c.getPerimeter()).isEqualTo(2*2+2*5);

        addComment(1, "");
    }

    @Test
    public void test_totalArea() {
        Circle a = new Circle(5.0);
        Square b = new Square(8);
        Rectangle c = new Rectangle(2,5);

        FigureManager f = new FigureManager();
        f.addNewFigure(a);
        f.addNewFigure(b);
        f.addNewFigure(c);

        assertThat(f.calculateTotalArea()).isEqualTo(152.53981633974485);

        addComment(1, "");
    }

    @Test
    public void test_totalPerimeter() {
        Circle a = new Circle(5.0);
        Square b = new Square(8);
        Rectangle c = new Rectangle(2,5);

        FigureManager f = new FigureManager();
        f.addNewFigure(a);
        f.addNewFigure(b);
        f.addNewFigure(c);

        assertThat(f.calculateTotalPerimeter()).isEqualTo(77.41592653589794);
    }

    private Class getInterfaceOrSuperClass(Class c) {
        Class[] interfaces = c.getInterfaces();
        if(interfaces != null && interfaces.length>0) {
            return interfaces[0];
        } else {
            return c.getSuperclass();
        }
    }

    @Test
    public void test_inheritance() throws Exception {
        Class circleParent = getInterfaceOrSuperClass(Class.forName("Circle"));
        Class rectangleParent = getInterfaceOrSuperClass(Class.forName("Rectangle"));
        Class squareParent = getInterfaceOrSuperClass(Class.forName("Square"));

        assertThat(circleParent).as("All figures should have a common ancestor").isEqualTo(rectangleParent);
        assertThat(circleParent).as("All figures should have a common ancestor").isEqualTo(squareParent);
        assertThat(circleParent).as("FigureManager should allow only to add figures").isNotEqualTo(Class.forName("java.lang.Object"));
        assertThat(circleParent.isInterface()).as("Empty classes should be interfaces").isEqualTo(true);
    }

    @Test
    public void test_manager_accepts_other_figures() throws Exception {
        class TestFigure extends Circle {

            public TestFigure() {
                super(1);
            }

            public double getArea() {
                return -1;
            }

            public double getPerimeter() {
                return -2;
            }
        }

        FigureManager manager = new FigureManager();
        manager.addNewFigure(new TestFigure());
        assertThat(manager.calculateTotalArea()).as("FigureManager must accept new implemented figures").isEqualTo(-1);
        assertThat(manager.calculateTotalPerimeter()).as("FigureManager must accept new implemented figures").isEqualTo(-2);
    }

    //@Test
    public void x_show_mark() {
        StringBuffer buffer = new StringBuffer();

        for(String comment : comments) {
            buffer.append(comment);
            buffer.append("\n");
        }

        fail("Summary:\n"+buffer+"\nTotal: "+mark+"\n");
    }

}
