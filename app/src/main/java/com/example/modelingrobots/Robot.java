package com.example.modelingrobots;

public abstract class Robot {
    public double x;
    public double y;
    public double q1;
    public double q2;
    public double L1;
    public double L2;
    private double q1Min;
    private double q1Max;
    private double q2Min;
    private double q2Max;

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getQ1() {
        return q1;
    }
    public double getQ2() {
        return q2;
    }
    public void setL1(double l1) {
        L1 = l1;
    }

    public void setL2(double l2) {
        L2 = l2;
    }

    public void setQ1Min(double q1min) {
        q1Min = q1min;
    }

    public void setQ1Max(double q1max) {
        q1Max = q1Max;
    }
    public void setQ2Min(double q2min) {
        q2Min = q2min;
    }
    public void setQ2Max(double q2max) {
        q2Max = q2Max;
    }

    public abstract double calcQ1();

    public abstract double calcQ2();

    public abstract double calcX();

    public abstract double calcY();
}
