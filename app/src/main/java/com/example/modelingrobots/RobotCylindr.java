package com.example.modelingrobots;

public class RobotCylindr extends Robot{
    @Override
    public double calcQ1() {
        return Math.atan2(x, y);
    }

    @Override
    public double calcQ2() {
        return Math.sqrt(x*x-y*y)-L1;
    }

    @Override
    public double calcX() {
        return (L1+q2)*Math.sin(q1);
    }

    @Override
    public double calcY() {
        return (L1+q2)*Math.cos(q1);
    }
}
