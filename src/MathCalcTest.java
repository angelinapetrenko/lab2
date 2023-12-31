
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MathCalcTest {

    private final MathCalc calculator = new MathCalc(System.in);

    @Test
    public void additionTest() throws Exception{
        assertEquals(1d, calculator.calc("0.5 + 0.5"));
        assertEquals(1.5d, calculator.calc("1.0 + 0.5"));
        assertEquals(1.5d, calculator.calc("1 + 0.5"));
        assertEquals(10d, calculator.calc("  9 + 0.5 +    0.5"));
        assertEquals(11d, calculator.calc("0.5 + 0.5 + 9 + 1"));
    }

    @Test
    public void subtractionTest() throws Exception{
        assertEquals(0d,calculator.calc("0.5 - 0.5"));
        assertEquals(1d, calculator.calc("0.5 - -0.5"));
        assertEquals(1.5d, calculator.calc("  2- 0.5"));
        assertEquals(0.5d, calculator.calc("1 - 0.5"));
        assertEquals(8d, calculator.calc("  (9 - 0.5) -  0.5"));
    }

    @Test
    public void multiplicationTest() throws Exception{
        assertEquals(0.25d, calculator.calc("0.5 * 0.5"));
        assertEquals(1d, calculator.calc("  2* 0.5"));
        assertEquals(20d,calculator.calc("10 * 2"));
        assertEquals(42d, calculator.calc("  3 * (7 * 2)"));
    }

    @Test
    public void divisionTest() throws Exception{
        assertEquals(4d/3, calculator.calc("4/3"));
        assertEquals(10d, calculator.calc("  100 / 10.0"));
        assertEquals(5d/2, calculator.calc("5.0/2"));
        assertEquals(6d, calculator.calc("  12/(4/2)"));
    }

    @Test
    public void bracketsTest() throws Exception{
        assertEquals(-10d,calculator.calc("2 * (3 + 2) * -1"));
        assertEquals(10d, calculator.calc("(50 + 50) * 2 * (3 + 2) / 100"));
        assertEquals(14d, calculator.calc("2 * (6 + 3) * 7 / 9"));
        assertEquals(37d, calculator.calc("2 + 7 * ( 3 + 4/2)"));
    }

    @Test
    void testCalc_InvalidExpression() {
        MathCalc mathCalc = new MathCalc(System.in);

        // Тестирование невалидного выражения
        assertThrows(Exception.class, () -> mathCalc.calc("2 + * 3"));

        // Тестирование выражения с неизвестной операцией
        assertThrows(Exception.class, () -> mathCalc.calc("2 $ 3"));

        // Тестирование выражения с неподдерживаемой операцией
        assertThrows(Exception.class, () -> mathCalc.calc("2 % 3"));
    }

}
