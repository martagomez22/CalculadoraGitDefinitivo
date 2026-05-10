package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import appcalculadora.Calculadora;

class CalculadoraTestAll {
    private static Calculadora calcGlobal;   
    private Calculadora calc;                

    @BeforeAll
    static void initAll() {
        System.out.println(">>> @BeforeAll: Inicializando recursos globales...");
        calcGlobal = new Calculadora(100, 20);  
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println(">>> @AfterAll: Liberando recursos globales...");
        calcGlobal = null;
    }

    @BeforeEach
    void setUp() {
        System.out.println("-> @BeforeEach: Preparando calculadora para la prueba...");
        calc = new Calculadora(10, 5);  
    }

    @AfterEach
    void tearDown() {
        System.out.println("-> @AfterEach: Finalizando prueba...");
        calc = null;
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
    void testDividePorCeroConLambda() {
        calc = new Calculadora(10, 0);
        assertThrows(ArithmeticException.class, () -> calc.divide());
    }

    @Test
    void testDividePorCeroSinLambda() {
        calc = new Calculadora(10, 0);
        try {
            calc.divide();
            fail("Se esperaba ArithmeticException al dividir por cero");
        } catch (ArithmeticException e) {
            // Excepción correcta
        }
    }

    @Test
    void testRecursoGlobal() {
        assertEquals(120, calcGlobal.suma());
    }
}