package com.example.modelingrobots;

public class RobotKoler extends Robot {
    @Override
    public double calcQ1() {
        return y-L2*Math.cos(Math.asin(x/L2));
    }

    @Override
    public double calcQ2() {
        return Math.asin(x/L2);
    }

    @Override
    public double calcX() {
        return L2*Math.sin(q2);
    }

    @Override
    public double calcY() {
        return q1+L2*Math.cos(q2);
    }
}
