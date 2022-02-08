import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class InterfacesTest {
    @Test
    public void test_circle_methods() {
        Circle c = new Circle(5.0);
        assertThat(c.getArea()).isEqualTo(Math.PI*Math.pow(5.0,2.0));
        assertThat(c.getPerimeter()).isEqualTo(2*Math.PI*5);
    }

    @Test
    public void test_square_methods() {
        Square c = new Square(8);
        assertThat(c.getArea()).isEqualTo(8*8);
        assertThat(c.getPerimeter()).isEqualTo(8*4);
    }

    @Test
    public void test_rectangle_methods() {
        Rectangle c = new Rectangle(2,5);
        assertThat(c.getArea()).isEqualTo(2*5);
        assertThat(c.getPerimeter()).isEqualTo(2*2+2*5);
    }
}
