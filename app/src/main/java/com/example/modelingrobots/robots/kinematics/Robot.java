package com.example.modelingrobots.robots.kinematics;

public abstract class Robot {

    private final double maxL1 = 1.0;
    private final double maxL2 = 1.0;
    public double x;
    public double y;
    public double q1;
    public double q2;
    public double L1;
    public double L2;
    public double q1Min;
    public double q1Max;
    public double q2Min;
    public double q2Max;

    public Robot(double l1, double l2, double q1min, double q1max, double q2min, double q2max) {
        this.L1 = l1;
        this.L2 = l2;
        this.q1Min = q1min;
        this.q1Max = q1max;
        this.q2Min = q2min;
        this.q2Max = q2max;
    }

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
    public double getMaxL1() { return maxL1; }
    public double getMaxL2() { return maxL2; }
    public double getQ1Max() { return q1Max; }
    public double getQ2Max() { return q2Max; }
    public double getQ1Min() { return q1Min; }
    public double getQ2Min() { return q2Min; }

    public void setL1(double l1) {
        L1 = l1;
    }

    public void setL2(double l2) {
        L2 = l2;
    }

    public void setQ1(double q1) { this.q1 = q1; }

    public void setQ2(double q2) {
        this.q2 = q2;
    }

    public void setQ1Min(double q1min) {
        q1Min = q1min;
    }

    public void setQ1Max(double q1max) {
        q1Max = q1max;
    }
    public void setQ2Min(double q2min) {
        q2Min = q2min;
    }
    public void setQ2Max(double q2max) {
        q2Max = q2max;
    }
    public void correctLength() {
        L1 = L1 > maxL1 ? maxL1 : L1;
        L1 = L1 < 0.0 ? 0.0 : L1;
        L2 = L2 > maxL2 ? maxL1 : L2;
        L2 = L2 < 0.0 ? 0.0 : L2;
        L2 = L2 > L1 ? L1 : L2;
    }
    public void correctQ1Q2() {
        q1 = q1 > q1Max ? q1Max : q1;
        q1 = q1 < q1Min ? q1Min : q1;
        q2 = q2 > q2Max ? q2Max : q2;
        q2 = q2 < q2Min ? q2Min : q2;
    }

    public abstract double calcQ1(Double x1, Double y1);

    public abstract double calcQ2(Double x1, Double y1);

    public abstract double calcX(Double q11, Double q22);

    public abstract double calcY(Double q11, Double q22);

    public abstract void correctQ1Q2Constraints();
}
