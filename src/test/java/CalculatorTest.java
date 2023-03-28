import com.liferay.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void testAllTaxes() {
        double price = 27.99;
        int amount = 1;
        double expectedResult = 4.2;
        double actualResult = Calculator.roundTax(Calculator.calculateImportationTax(price, amount) +
                Calculator.calculateBasicTax(price, amount));
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void testAllTaxesPrice() {
        double price = 27.99;
        int amount = 1;
        double expectedResult = 32.19;
        double actualResult = Calculator.calculateImportationTaxedPrice(price, amount) +
                Calculator.calculateBasicTax(price,amount);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void testBasicTax() {
        double price = 14.99;
        int amount = 1;
        double expectedResult = 1.5;
        double actualResult = Calculator.calculateBasicTax(price, amount);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void testBasicTaxedPrice() {
        double price = 14.99;
        int amount = 1;
        double expectedResult = 16.49;
        double actualResult = Calculator.calculateBasicTaxedPrice(price, amount);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void testImportationTax() {
        double price = 11.25;
        int amount = 1;
        double expectedResult = 0.6;
        double actualResult = Calculator.calculateImportationTax(price, amount);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void testImportationTaxedPrice() {
        double price = 11.25;
        int amount = 1;
        double expectedResult = 11.85;
        double actualResult = Calculator.calculateImportationTaxedPrice(price, amount);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void testNoTaxes() {
        double price = 12.49;
        int amount = 1;
        double expectedResult = price * amount;
        double actualResult = Calculator.calculateTotalPrice(price, amount);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void testRound1() {
        double price = 11.29;
        double expectedResult = 11.30;
        double actualResult = Calculator.roundTax(price);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void testRound2() {
        double price = 11.21;
        double expectedResult = 11.25;
        double actualResult = Calculator.roundTax(price);
        assertEquals(expectedResult, actualResult);
    }

}
