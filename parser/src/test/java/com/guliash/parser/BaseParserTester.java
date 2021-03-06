package com.guliash.parser;

import com.guliash.parser.evaluator.JavaEvaluator;
import com.guliash.parser.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class BaseParserTester {

    protected static final double EPS = 1e-15;

    /**
     * calculates without variables and at RAD mode
     * @param expression expression to evaluate
     * @return result
     */
    protected double calculate(String expression) {
        return calculate(expression, new ArrayList<StringVariable>(), AngleUnits.RAD);
    }

    protected double calculate(String expression, AngleUnits angleUnits) {
        return calculate(expression, new ArrayList<StringVariable>(), angleUnits);
    }

    protected double calculate(String expression, List<StringVariable> variables) {
        return calculate(expression, variables, AngleUnits.RAD);
    }

    protected double calculate(String expression, List<StringVariable> variables, AngleUnits angleUnits) {
        return Parser.calculate(expression, variables, new JavaEvaluator(angleUnits));
    }
}
