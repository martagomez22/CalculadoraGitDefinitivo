package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import appcalculadora.Calculadora;

class CalculadoraTestParam {

    @ParameterizedTest
    @CsvSource({"1, 2, 3", "10, 5, 15", "-3, 3, 0", "7, 8, 15"})
    void testSumaParametrizada(int a, int b, int esperado) {
        Calculadora calc = new Calculadora(a, b);
        assertEquals(esperado, calc.suma());
    }

    @ParameterizedTest
    @CsvSource({"5, 3, 2", "10, 5, 5", "0, 7, -7", "-3, -3, 0"})
    void testRestaParametrizada(int a, int b, int esperado) {
        Calculadora calc = new Calculadora(a, b);
        assertEquals(esperado, calc.resta());
    }

    @ParameterizedTest
    @CsvSource({"2, 3, 6", "10, 5, 50", "-3, 3, -9", "7, 0, 0"})
    void testMultiplicaParametrizada(int a, int b, int esperado) {
        Calculadora calc = new Calculadora(a, b);
        assertEquals(esperado, calc.multiplica());
    }

    @ParameterizedTest
    @CsvSource({"10, 5, 2", "20, 4, 5", "-9, 3, -3", "0, 7, 0"})
    void testDivideParametrizada(int a, int b, int esperado) {
        Calculadora calc = new Calculadora(a, b);
        assertEquals(esperado, calc.divide());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, -3})
    void testDividePorCeroSinLambda(int a) {
        Calculadora calc = new Calculadora(a, 0);
        try {
            calc.divide();
            fail("Se esperaba ArithmeticException al dividir por cero");
        } catch (ArithmeticException e) {
            // Excepción correcta
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, -3})
    void testDividePorCeroConLambda(int a) {
        Calculadora calc = new Calculadora(a, 0);
        assertThrows(ArithmeticException.class, () -> calc.divide());
    }
}