package test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    CalculadoraTest.class,
    CalculadoraTestAll.class,
    CalculadoraTestEach.class,
    CalculadoraTestParam.class
})
public class SuiteCalculadora {
}