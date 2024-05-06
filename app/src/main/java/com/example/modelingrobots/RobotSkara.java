package com.example.modelingrobots;

public class RobotSkara extends Robot{
    public enum OrientationLink {
        LEFT(1.0),
        RIGHT(-1.0);

        double orientation;
        OrientationLink(double orientation) {
            this.orientation = orientation;
        }
        public double getOrientation() {
            return this.orientation;
        }
    }

    OrientationLink orientationLink = OrientationLink.LEFT;
    @Override
    public double calcQ1() {
        double r = Math.sqrt(x*x + y*y);
        double a = Math.atan2(y,x);
        double g1 = Math.acos((r*r + L1*L1 - L2*L2)/(2*L1*r));
        return -Math.PI/2+a+g1*orientationLink.getOrientation();
    }

    @Override
    public double calcQ2() {
        double r = Math.sqrt(x*x + y*y);
        double g1 = Math.acos((r*r + L1*L1 - L2*L2)/(2*L1*r));
        double g2 = Math.asin(L1/L2*Math.sin(g1));
        return (g1+g2)*orientationLink.getOrientation();
    }

    @Override
    public double calcX() {
        return -L1*Math.sin(q1)-L2*Math.sin(q1+q2);
    }

    @Override
    public double calcY() {
        return L1*Math.cos(q1)+L2*Math.cos(q1+q2);
    }

    public void setOrientation(OrientationLink orientation) {
        orientationLink = orientation;
    }
}
