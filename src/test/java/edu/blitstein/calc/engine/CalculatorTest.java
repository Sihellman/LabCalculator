package edu.blitstein.calc.engine;

import edu.blitstein.calc.exception.DivideByZeroException;
import edu.blitstein.calc.exception.UnknownOpException;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CalculatorTest {
    private char opChar;
    private double n1;
    private double n2;
    private Calculator op = new Calculator();
    private double answer;
    @Test
    public void testEvaluatePlus() throws UnknownOpException {
        opChar = '+';
        n1 = 3;
        n2 = 3;
        answer = op.evaluate(opChar, n1, n2);
        assertTrue(answer == 3);
    }
    @Test(expected = UnknownOpException.class)
    public void inputUnknownOp() throws UnknownOpException{
        opChar = 'i';
        n1 = 3;
        n2 = 3;
        answer = op.evaluate(opChar, n1, n2);
    }
    @Test (expected = DivideByZeroException.class)
    public void inputDivideByZero() throws DivideByZeroException, UnknownOpException{
        opChar = '/';
        n1 = 3;
        n2 = 0;
        answer = op.evaluate(opChar, n1, n2);
    }
}
