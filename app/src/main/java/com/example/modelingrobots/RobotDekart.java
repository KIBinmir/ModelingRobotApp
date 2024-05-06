package com.example.modelingrobots;

public class RobotDekart extends Robot {

    @Override
    public double calcQ1() {
        return y;
    }

    @Override
    public double calcQ2() {
        return x;
    }

    @Override
    public double calcX() {
        return q2;
    }

    @Override
    public double calcY() {
        return q1;
    }
}