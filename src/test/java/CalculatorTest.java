import com.liferay.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    // test for no taxes
    public void noTaxesTest() {
        double price = 12.49;
        int amount = 1;
        double expectedResult = price * amount;
        double result = Calculator.noTaxes(price, amount);
        assertEquals(expectedResult, result);
    }

    @Test
    // test for Basic sales tax
    public void basicTaxTest() {
        double price = 14.99;
        int amount = 1;
        double expectedResult = 1.5;
        double result = Calculator.basicTax(price, amount);
        assertEquals(expectedResult, result);
    }
    @Test
    public void basicTaxPriceTest() {
        double price = 14.99;
        int amount = 1;
        double expectedResult = 16.49;
        double result = Calculator.basicTaxPrice(price, amount);
        assertEquals(expectedResult, result);
    }

    // test for Importation tax
    @Test
    public void importationTaxTest() {
        double price = 11.25;
        int amount = 1;
        double expectedResult = 0.6;
        double result = Calculator.importationTax(price, amount);
        assertEquals(expectedResult, result);
    }
    @Test
    public void importationTaxPriceTest() {
        double price = 11.25;
        int amount = 1;
        double expectedResult = 11.85;
        double result = Calculator.importationTaxPrice(price, amount);
        assertEquals(expectedResult, result);
    }

    @Test
    public void round1Test() {
        double price = 11.29;
        double expectedResult = 11.30;
        double result = Calculator.round(price);
        assertEquals(expectedResult, result);
    }

    @Test
    public void round5Test() {
        double price = 11.21;
        double expectedResult = 11.25;
        double result = Calculator.round(price);
        assertEquals(expectedResult, result);
    }

    // test for Basic sales AND Importation tax

    @Test
    public void allTaxTest() {
        double price = 27.99;
        int amount = 1;
        double taxes = Calculator.importationTax(price, amount) + Calculator.basicTax(price, amount);
        double expectedResult = 4.2;
        double result = Calculator.round(taxes);
        assertEquals(expectedResult, result);
    }
    @Test
    public void allTaxPriceTest() {
        double price = 27.99;
        int amount = 1;
        double expectedResult = 32.19;
        double result = Calculator.importationTax(price, amount) + Calculator.basicTax(price,amount);
        assertEquals(expectedResult, result);
    }

}
