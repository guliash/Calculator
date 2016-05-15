package com.guliash.parser;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VariablesTester extends BaseParserTester {

    @Test
    public void variablesReadCorrectly1() {
        ArrayList<Variable> variables = new ArrayList<>();
        variables.add(new Variable("x", Double.toString(-1.0)));
        variables.add(new Variable("y", Double.toString(2.0)));
        assertEquals(Math.exp(-1d) * Math.sin(2d), calculate("exp(x)*sin(y)", variables), EPS);
    }

    @Test
    public void variablesReadCorrectly2() {
        ArrayList<Variable> variables = new ArrayList<>();
        variables.add(new Variable("x", Double.toString(-1.0)));
        variables.add(new Variable("y", Double.toString(2.0)));
        assertEquals(Math.min(-1.d, 2.d), calculate("min(x, y)", variables), EPS);
    }

    /**
     * The parser is case-sensitive. So it should be able to calculate a correct expression
     * with same variables
     */
    @Test
    public void sameVariablesButDifferentCaseTest() {
        List<Variable> variables = new ArrayList<>();
        variables.add(new Variable("x", Double.toString(2d)));
        variables.add(new Variable("X", Double.toString(3d)));
        assertEquals(5d, calculate("x + X", variables), EPS);
    }

    @Test
    public void constantsShouldHaveMorePriorityThanVariables() {
        List<Variable> variables = new ArrayList<>();
        variables.add(new Variable("e", Double.toString(2d)));
        assertEquals(Math.E, calculate("e", variables), EPS);
    }

    @Test(expected = Exception.class)
    public void variableNameMustNotBeginWithDigit() {
        List<Variable> variables = new ArrayList<>();
        variables.add(new Variable("1_32ab", Double.toString(2d)));
        calculate("1_32ab + 3", variables);
    }

    @Test
    public void variableNameCanBeginWithDollar() {
        List<Variable> variables = new ArrayList<>();
        variables.add(new Variable("$23", Double.toString(2d)));
        variables.add(new Variable("ab", Double.toString(10d)));
        assertEquals(12d, calculate("$23 + ab", variables), EPS);
    }

    @Test
    public void variableNameCanBeginWithUnderscore() {
        List<Variable> variables = new ArrayList<>();
        variables.add(new Variable("_23", Double.toString(2d)));
        variables.add(new Variable("$ab", Double.toString(10d)));
        assertEquals(12d, calculate("_23 + $ab", variables), EPS);
    }

    @Test
    public void testVariableNameConvention() {
        List<Variable> variables = new ArrayList<>();
        double _$12_3$ = 35d;
        double J2eV = 45d;
        double masse = 10043d;
        variables.add(new Variable("_$12_3$", Double.toString(_$12_3$)));
        variables.add(new Variable("J2eV", Double.toString(J2eV)));
        variables.add(new Variable("masse", Double.toString(masse)));
        assertEquals(_$12_3$ / J2eV * masse, calculate("_$12_3$ / J2eV * masse", variables), EPS);
    }

    @Test
    public void testVariablesCaseSensitiveness() {
        double j2ev = 45d;
        double J2eV = 53534;
        List<Variable> variables = new ArrayList<>();
        variables.add(new Variable("j2ev", Double.toString(j2ev)));
        variables.add(new Variable("J2eV", Double.toString(J2eV)));
        assertEquals(j2ev / J2eV, calculate("j2ev / J2eV", variables), EPS);
    }

    @Test(expected = Exception.class)
    public void testVariablesCaseSensitivenessWrongVariable() {
        double j2ev = 45d;
        List<Variable> variables = new ArrayList<>();
        variables.add(new Variable("j2ev", Double.toString(j2ev)));
        calculate("J2eV", variables);
    }


    @Test
    public void variableNameCanMatchFunctionName() {
        ArrayList<Variable> variables = new ArrayList<>();
        variables.add(new Variable("exp", Double.toString(3.0)));
        variables.add(new Variable("y", Double.toString(2.0)));
        assertEquals(3.0, calculate("exp", variables), EPS);
    }

    @Test
    public void variableNameCanMatchFunctionName2() {
        ArrayList<Variable> variables = new ArrayList<>();
        double sin = 433;
        double cos = 433;
        variables.add(new Variable("sin", Double.toString(sin)));
        variables.add(new Variable("cos", Double.toString(cos)));
        assertEquals(Math.cos(cos) * Math.sin(sin), calculate("cos(cos) * sin(sin)", variables), EPS);
    }

    @Test
    public void variableNameCanMatchFunctionName3() {
        ArrayList<Variable> variables = new ArrayList<>();
        double sin = 433;
        double cos = 433;
        variables.add(new Variable("sin", Double.toString(sin)));
        variables.add(new Variable("cos", Double.toString(cos)));
        assertEquals(Math.cos(Math.cos(sin)) * Math.sin(Math.cos(sin)), calculate("cos(cos(sin)) * sin(cos(sin))", variables), EPS);
    }

    @Test
    public void variableCanContainExpressions() {
        ArrayList<Variable> variables = new ArrayList<>();
        Double a = Math.sin(2*Math.cos(3));
        variables.add(new Variable("a", "sin(2*cos(3))"));
        assertEquals(Math.tan(a), calculate("tan(a)", variables), EPS);
    }

    @Test
    public void variablesCanContainExpressions() {
        List<Variable> variables = new ArrayList<>();
        double a = Math.abs(Math.cos(3));
        double b = Math.tan(Math.cos(45));
        double c = Math.acos(90);
        variables.add(new Variable("a", "abs(cos(3))"));
        variables.add(new Variable("b", "tan(cos(45))"));
        variables.add(new Variable("c", "acos(90)"));
        assertEquals(Math.exp(a + b * c), calculate("exp(a + b * c)", variables), EPS);
    }

    @Test(expected = Exception.class)
    public void variableExpressionCannotContainAnotherVariable() {
        List<Variable> variables = new ArrayList<>();
        double a = Math.pow(2, 3);
        double b = Math.exp(a);
        variables.add(new Variable("a", "pow(2, 3)"));
        variables.add(new Variable("b", "exp(a)"));
        assertEquals(Math.cos(b), calculate("cos(b)", variables), EPS);
    }

    @Test(expected = Exception.class)
    public void variablesCannotContainIncorrectExpression() {
        List<Variable> variables = new ArrayList<>();
        double a = Math.cos(25*Math.pow(3, 3)*Math.exp(   3 ))*25;
        double b = Math.cos(Math.sin(25)*Math.exp(3)*Functions.logarithm(2, 3));
        variables.add(new Variable("a", "cos(25*pow(3, 3)*exp(   3 ))*25"));
        variables.add(new Variable("b", "cos(sin(25)*exp(3)*log(,2, 3))"));
        assertEquals(a + b, calculate("a + b", variables), EPS);
    }

}
