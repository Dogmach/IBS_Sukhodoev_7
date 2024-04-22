import org.example.Сalculating;
import org.junit.Assert;
import org.junit.Test;

import java.util.InputMismatchException;

public class MainTest {

    @Test
    public void testSum() {
        Сalculating calc = new Сalculating();
        float a = 2.5f;
        float b = 3.5f;
        int errorCode = calc.result(a, b, "+");
        Assert.assertEquals(Сalculating.ERROR_no, errorCode);
        Assert.assertEquals(a + b, calc.getValue(), 0.0001);
    }

    @Test
    public void testSubtract() {
        Сalculating calc = new Сalculating();
        float a = 5.5f;
        float b = 2.2f;
        int errorCode = calc.result(a, b, "-");
        Assert.assertEquals(Сalculating.ERROR_no, errorCode);
        Assert.assertEquals(a - b, calc.getValue(), 0.0001);
    }

    @Test
    public void testMultiply() {
        Сalculating calc = new Сalculating();
        float a = 2.0f;
        float b = 4.0f;
        int errorCode = calc.result(a, b, "*");
        Assert.assertEquals(Сalculating.ERROR_no, errorCode);
        Assert.assertEquals(8, calc.getValue(), 0.0001);
    }

    @Test
    public void testDivide() {
        Сalculating calc = new Сalculating();
        float a = 10.0f;
        float b = 2.0f;
        int errorCode = calc.result(a, b, "/");
        Assert.assertEquals(Сalculating.ERROR_no, errorCode);
        Assert.assertEquals(5, calc.getValue(), 0.0001);
    }

    @Test
    void testInvalidInputFormatOperator2Znak() {
        Сalculating calc = new Сalculating();
        float a = 5.0f;
        float b = 3.0f;
        String operator = "+-";
        int errorCode = calc.result(a, b, operator);
        Assert.assertEquals(Сalculating.ERROR_not_sup, errorCode);
        Assert.assertEquals(0.0, calc.getValue(), 0.0001);
    }

    @Test
    void testTextOfError() {
        Сalculating calc = new Сalculating();
        Assert.assertEquals("", calc.getErrorText(Сalculating.ERROR_no));
        Assert.assertEquals("Необходимо ввести один из знаков: +, -, * или /", calc.getErrorText(Сalculating.ERROR_not_sup));
        Assert.assertEquals("Делить на ноль нельзя", calc.getErrorText(Сalculating.ERROR_zero));
    }

    @Test
    public void testDivideByZero() {
        Сalculating calc = new Сalculating();
        float a = 5.0f;
        float b = 0.0f;
        Assert.assertThrows(ArithmeticException.class, () -> {
            calc.result(a, b, "/");
        });
    }

    @Test
    void testInvalidInputFormatOperator() {
        Сalculating calc = new Сalculating();
        float a = 5.0f;
        float b = 3.0f;
        String operator = ".";

        Assert.assertThrows(InputMismatchException.class, () -> {
            int errorCode = calc.result(a, b, operator);
        });
    }
}