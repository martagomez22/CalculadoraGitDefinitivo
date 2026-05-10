package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import appcalculadora.Calculadora;

class CalculadoraTest {
    @Test
    void testSuma() {
        Calculadora calc = new Calculadora(10, 5);
        assertEquals(15, calc.suma());
    }
    @Test
    void testResta() {
        Calculadora calc = new Calculadora(10, 5);
        assertEquals(5, calc.resta());
    }
    @Test
    void testMultiplica() {
        Calculadora calc = new Calculadora(10, 5);
        assertEquals(50, calc.multiplica());
    }
    @Test
    void testDivide() {
        Calculadora calc = new Calculadora(10, 5);
        assertEquals(2, calc.divide());
    }
    @Test
    void testDividePorCero() {
        Calculadora calc = new Calculadora(10, 0);
        assertThrows(ArithmeticException.class, () -> calc.divide());
    }
}