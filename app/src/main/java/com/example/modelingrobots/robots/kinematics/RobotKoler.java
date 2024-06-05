package com.example.modelingrobots.robots.kinematics;

public class RobotKoler extends Robot {
    public RobotKoler(double l1, double l2, double q1min, double q1max, double q2min, double q2max) {
        super(l1, l2, q1min, q1max, q2min, q2max);
    }
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
        return -L2*Math.sin(q2);
    }

    @Override
    public double calcY() {
        return q1+L2*Math.cos(q2);
    }

    @Override
    public void correctQ1Q2Constraints() {
        q1Min = q1Min < 0.0 ? 0.0 : q1Min;
        q1Max = q1Max > L1 ? L1 : q1Max;
        q2Max = q2Max > Math.PI ? Math.PI : q2Max;
        q2Min = q2Min < -Math.PI ? -Math.PI : q2Min;
    }
}
