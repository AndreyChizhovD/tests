import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GaussianIntegerTests {

    GaussianInteger first;
    GaussianInteger second;

    @BeforeTest
    public void setup() {
        first = new GaussianInteger(3, 2);
        second = new GaussianInteger(1, -6);
    }

    @Test
    public void checkNorm() {
        assertEquals(13, first.norm());
        assertEquals(37, second.norm());
    }

    @Test
    public void checkConjugate() {
        assertEquals(-2, first.conjugate().complex);
        assertEquals(6, second.conjugate().complex);
    }

    @Test
    public void checkSum() {
        var sum = GaussianInteger.sum(first, second);
        assertEquals(4, sum.real);
        assertEquals(-4, sum.complex);
    }

    @Test
    public void checkProd() {
        var prod = GaussianInteger.prod(first, second);
        assertEquals(15, prod.real);
        assertEquals(-16, prod.complex);
    }

    @Test
    public void checkDiv() {
        assertEquals(false, first.isDivisibleBy(second));
        assertEquals(false, second.isDivisibleBy(first));
        assertEquals(true, first.isDivisibleBy(first));
        GaussianInteger gaussianInteger = new GaussianInteger(3, 9);
        assertEquals(true, gaussianInteger.isDivisibleBy(new GaussianInteger(0, 3)));
    }
}
