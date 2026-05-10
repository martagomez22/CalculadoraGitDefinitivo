package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import appcalculadora.Calculadora;

class CalculadoraTestEach {
    private Calculadora calc;

    @BeforeEach
    void setUp() {
        calc = new Calculadora(10, 5);
        System.out.println("Iniciando prueba...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Prueba finalizada.");
    }

    @Test
    void testSuma() {
        assertEquals(15, calc.suma());
    }

    @Test
    void testResta() {
        assertEquals(5, calc.resta());
    }

    @Test
    void testMultiplica() {
        assertEquals(50, calc.multiplica());
    }

    @Test
    void testDivide() {
        assertEquals(2, calc.divide());
    }

    @Test
    void testDividePorCeroSinLambda() {
        calc = new Calculadora(10, 0);  
        try {
            calc.divide();
            fail("Se esperaba ArithmeticException al dividir por cero");
        } catch (ArithmeticException e) {
            // La excepción es correcta, la prueba pasa
        }
    }
}