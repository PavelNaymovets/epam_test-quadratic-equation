package com.epam.rd.autotasks;

public class QuadraticEquation {
    public String solve(double a, double b, double c) {
        if(a == 0) throw new IllegalArgumentException();
        double disc = b*b - 4*a*c;
        if(disc<0) return "no roots";
        double x1 = (-b + Math.sqrt(disc)) / (2 * a);
        double x2 = (-b - Math.sqrt(disc)) / (2 * a);
        return x1 == x2 ? Double.toString(x1) : x1 + " " + x2;
    }
}