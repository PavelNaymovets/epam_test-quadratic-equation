package com.epam.rd.autotasks;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(Parameterized.class)
public class QuadraticEquationTwoRootsCasesTesting {
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();

    private double a;
    private double b;
    private double c;
    private String expected;

    public QuadraticEquationTwoRootsCasesTesting(double a, double b, double c, String expected) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1.0, 2.0, -3.0, "1.0 -3.0"},
                {1.0, -3.0, -4.0, "4.0 -1.0"},
                {3.0, -33.0, 90.0, "6.0 5.0"},
                {1.0, -26.0, 120.0, "20.0 6.0"}
        });
    }

    @Test
    public void testTwoRootsCase(){
        String[] arrayOfExp = expected.split(" ");
        List<Double> expNum = Arrays.stream(arrayOfExp)
                .map(Double::valueOf)
                .collect(Collectors.toList());
        String result = quadraticEquation.solve(a,b,c);
        if(result.equals("no roots")){
            throw new AssertionError();
        }
        String[] arrayOfResults = result.split(" ");
        List<Double> resultNumbers = Arrays.stream(arrayOfResults)
                .map(Double::valueOf)
                .collect(Collectors.toList());
        Assert.assertTrue(expNum.containsAll(resultNumbers));

    }

}
