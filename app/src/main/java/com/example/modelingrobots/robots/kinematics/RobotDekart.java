package com.example.modelingrobots.robots.kinematics;

public class RobotDekart extends Robot {
    public RobotDekart(double l1, double l2, double q1min, double q1max, double q2min, double q2max) {
        super(l1, l2, q1min, q1max, q2min, q2max);
    }
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

    @Override
    public void correctQ1Q2Constraints() {
        q1Min = q1Min < 0.0 ? 0.0 : q1Min;
        q2Min = q2Min < 0.0 ? 0.0 : q2Min;
        q1Max = q1Max > L1 ? L1 : q1Max;
        q2Max = q2Max > L2 ? L2 : q2Max;
    }
}