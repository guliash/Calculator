package com.guliash.parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrigonometricTester extends BaseParserTester {

    @Test
    public void trigonometricTest1() {
        assertEquals(Math.sin(3.14 / 2) + Math.cos(2 - 6 / 3),
                calculate("sin(3.14/2)+cos(2-6/3)", AngleUnits.RAD), EPS);
    }

    @Test
    public void sinTest1() {
        assertEquals(Math.sin(Math.PI / 2),
                calculate("sin(pi / 2)", AngleUnits.RAD), EPS);
    }

    @Test
    public void sinTest2() {
        assertEquals(Math.sin(Math.PI / 4),
                calculate("sin(pi / 4)", AngleUnits.RAD), EPS);
    }

    @Test
    public void sinTest3() {
        assertEquals(Math.sin(0),
                calculate("sin(0)", AngleUnits.RAD), EPS);
    }

    @Test
    public void sinTest4() {
        assertEquals(Math.sin(Functions.convertAngles(45, AngleUnits.DEG, AngleUnits.RAD)),
                calculate("sin(45)", AngleUnits.DEG), EPS);
    }

    @Test
    public void sinTest5() {
        assertEquals(Math.sin(Functions.convertAngles(45, AngleUnits.GRAD, AngleUnits.RAD)),
                calculate("sin(45)", AngleUnits.GRAD), EPS);
    }

    @Test
    public void cosTest1() {
        assertEquals(Math.cos(Math.PI / 2), calculate("cos(pi/2)"), EPS);
    }

    @Test
    public void cosTest2() {
        assertEquals(Math.cos(Math.PI / 4), calculate("cos(pi/4)"), EPS);
    }

    @Test
    public void cosTest3() {
        assertEquals(Math.cos(0),
                calculate("cos(0)", AngleUnits.RAD), EPS);
    }

    @Test
    public void cosTest4() {
        assertEquals(Math.cos(Functions.convertAngles(45, AngleUnits.DEG, AngleUnits.RAD)),
                calculate("cos(45)", AngleUnits.DEG), EPS);
    }

    @Test
    public void cosTest5() {
        assertEquals(Math.cos(Functions.convertAngles(45, AngleUnits.GRAD, AngleUnits.RAD)),
                calculate("cos(45)", AngleUnits.GRAD), EPS);
    }

    @Test
    public void tanTest1() {
        assertEquals(Math.tan(Math.PI / 2), calculate("tan(pi/2)"), EPS);
    }

    @Test
    public void tanTest2() {
        assertEquals(Math.tan(Math.PI / 4), calculate("tan(pi/4)"), EPS);
    }

    @Test
    public void tanTest3() {
        assertEquals(Math.tan(0),
                calculate("tan(0)", AngleUnits.RAD), EPS);
    }

    @Test
    public void tanTest4() {
        assertEquals(Math.tan(Functions.convertAngles(45, AngleUnits.DEG, AngleUnits.RAD)),
                calculate("tan(45)", AngleUnits.DEG), EPS);
    }

    @Test
    public void tanTest5() {
        assertEquals(Math.tan(Functions.convertAngles(45, AngleUnits.GRAD, AngleUnits.RAD)),
                calculate("tan(45)", AngleUnits.GRAD), EPS);
    }

    @Test
    public void cotTest1() {
        assertEquals(1 / Math.tan(Math.PI / 2), calculate("cot(pi/2)"), EPS);
    }

    @Test
    public void cotTest2() {
        assertEquals(1 / Math.tan(Math.PI / 4), calculate("cot(pi/4)"), EPS);
    }

    @Test
    public void cotTest3() {
        assertEquals(1 / Math.tan(0),
                calculate("cot(0)", AngleUnits.RAD), EPS);
    }

    @Test
    public void cotTest4() {
        assertEquals(1 / Math.tan(Functions.convertAngles(45, AngleUnits.DEG, AngleUnits.RAD)),
                calculate("cot(45)", AngleUnits.DEG), EPS);
    }

    @Test
    public void cotTest5() {
        assertEquals(1 / Math.tan(Functions.convertAngles(45, AngleUnits.GRAD, AngleUnits.RAD)),
                calculate("cot(45)", AngleUnits.GRAD), EPS);
    }

    @Test
    public void asinTest1() {
        assertEquals(Math.asin(Math.sin(Math.PI / 2)),
                calculate("asin(sin(pi/2))", AngleUnits.RAD), EPS);
    }

    @Test
    public void asinTest2() {
        assertEquals(Math.asin(Math.sin(Math.PI / 4)),
                calculate("asin(sin(pi / 4))", AngleUnits.RAD), EPS);
    }

    @Test
    public void asinTest3() {
        assertEquals(Math.asin(Math.sin(0)),
                calculate("asin(sin(0))", AngleUnits.RAD), EPS);
    }

    @Test
    public void asinTest4() {
        assertEquals(Functions.convertAngles(Math.asin(Math.sin(Functions.convertAngles(45, AngleUnits.DEG, AngleUnits.RAD))),
                        AngleUnits.RAD, AngleUnits.DEG),
                calculate("asin(sin(45))", AngleUnits.DEG), EPS);
    }

    @Test
    public void asinTest5() {
        assertEquals(Functions.convertAngles(Math.asin(Math.sin(Functions.convertAngles(45, AngleUnits.GRAD, AngleUnits.RAD))),
                        AngleUnits.RAD, AngleUnits.GRAD),
                calculate("asin(sin(45))", AngleUnits.GRAD), EPS);
    }

    @Test
    public void acosTest1() {
        assertEquals(Math.acos(Math.cos(Math.PI / 2)),
                calculate("acos(cos(pi/2))", AngleUnits.RAD), EPS);
    }

    @Test
    public void acosTest2() {
        assertEquals(Math.acos(Math.cos(Math.PI / 4)),
                calculate("acos(cos(pi / 4))", AngleUnits.RAD), EPS);
    }

    @Test
    public void acosTest3() {
        assertEquals(Math.acos(Math.cos(0)),
                calculate("acos(cos(0))", AngleUnits.RAD), EPS);
    }

    @Test
    public void acosTest4() {
        assertEquals(Functions.convertAngles(Math.acos(Math.cos(Functions.convertAngles(45, AngleUnits.DEG, AngleUnits.RAD))),
                        AngleUnits.RAD, AngleUnits.DEG),
                calculate("acos(cos(45))", AngleUnits.DEG), EPS);
    }

    @Test
    public void acosTest5() {
        assertEquals(Functions.convertAngles(Math.acos(Math.cos(Functions.convertAngles(45, AngleUnits.GRAD, AngleUnits.RAD))),
                        AngleUnits.RAD, AngleUnits.GRAD),
                calculate("acos(cos(45))", AngleUnits.GRAD), EPS);
    }

    @Test
    public void atanTest1() {
        assertEquals(Math.atan(Math.tan(Math.PI / 2)),
                calculate("atan(tan(pi/2))", AngleUnits.RAD), EPS);
    }

    @Test
    public void atanTest2() {
        assertEquals(Math.atan(Math.tan(Math.PI / 4)),
                calculate("atan(tan(pi / 4))", AngleUnits.RAD), EPS);
    }

    @Test
    public void atanTest3() {
        assertEquals(Math.atan(Math.tan(0)), calculate("atan(tan(0))", AngleUnits.RAD), EPS);
    }

    @Test
    public void atanTest4() {
        assertEquals(Functions.convertAngles(Math.atan(Math.tan(Functions.convertAngles(45, AngleUnits.DEG, AngleUnits.RAD))),
                AngleUnits.RAD, AngleUnits.DEG), calculate("atan(tan(45))", AngleUnits.DEG), EPS);
    }

    @Test
    public void atanTest5() {
        assertEquals(Functions.convertAngles(Math.atan(Math.tan(Functions.convertAngles(45, AngleUnits.GRAD, AngleUnits.RAD))),
                AngleUnits.RAD, AngleUnits.GRAD), calculate("atan(tan(45))", AngleUnits.GRAD), EPS);
    }

    @Test
    public void acotTest1() {
        assertEquals(Functions.acot((Functions.cot(Math.PI / 2))),
                calculate("acot(cot(pi/2))", AngleUnits.RAD), EPS);
    }

    @Test
    public void acotTest2() {
        assertEquals(Functions.acot(Functions.cot(Math.PI / 4)),
                calculate("acot(cot(pi / 4))", AngleUnits.RAD), EPS);
    }

    @Test
    public void acotTest3() {
        assertEquals(Functions.acot(Functions.cot(0)), calculate("acot(cot(0))", AngleUnits.RAD), EPS);
    }

    @Test
    public void acotTest4() {
        assertEquals(Functions.convertAngles(Functions.acot(Functions.cot(Functions.convertAngles(45, AngleUnits.DEG, AngleUnits.RAD))),
                AngleUnits.RAD, AngleUnits.DEG),
                calculate("acot(cot(45))", AngleUnits.DEG), EPS);
    }

    @Test
    public void acotTest5() {
        assertEquals(Functions.convertAngles(Functions.acot(Functions.cot(Functions.convertAngles(45, AngleUnits.GRAD, AngleUnits.RAD))),
                AngleUnits.RAD, AngleUnits.GRAD),
                calculate("acot(cot(45))", AngleUnits.GRAD), EPS);
    }

    @Test
    public void sinhTest1() {
        assertEquals(Math.sinh(1), calculate("sinh(1)"), EPS);
    }

    @Test
    public void sinhTest2() {
        assertEquals(Math.sinh(Math.E), calculate("sinh(e)"), EPS);
    }

    @Test
    public void sinhTest3() {
        assertEquals(Math.sinh(Math.PI), calculate("sinh(pi)"), EPS);
    }

    @Test
    public void coshTest1() {
        assertEquals(Math.cosh(1), calculate("cosh(1)"), EPS);
    }

    @Test
    public void coshTest2() {
        assertEquals(Math.cosh(Math.E), calculate("cosh(e)"), EPS);
    }

    @Test
    public void coshTest3() {
        assertEquals(Math.cosh(Math.PI), calculate("cosh(pi)"), EPS);
    }

    @Test
    public void tanhTest1() {
        assertEquals(Math.tanh(1), calculate("tanh(1)"), EPS);
    }

    @Test
    public void tanhTest2() {
        assertEquals(Math.tanh(Math.E), calculate("tanh(e)"), EPS);
    }

    @Test
    public void tanhTest3() {
        assertEquals(Math.tanh(Math.PI), calculate("tanh(pi)"), EPS);
    }

    @Test
    public void cothTest1() {
        assertEquals(1 / Math.tanh(1), calculate("coth(1)"), EPS);
    }

    @Test
    public void cothTest2() {
        assertEquals(1 / Math.tanh(Math.E), calculate("coth(e)"), EPS);
    }

    @Test
    public void cothTest3() {
        assertEquals(1 / Math.tanh(Math.PI), calculate("coth(pi)"), EPS);
    }

    @Test
    public void cothTest4() {
        assertEquals(1 / Math.tanh(0), calculate("coth(0)"), EPS);
    }

    @Test
    public void piTest1() {
        assertEquals(Math.PI, calculate("pi"), EPS);
    }


}
