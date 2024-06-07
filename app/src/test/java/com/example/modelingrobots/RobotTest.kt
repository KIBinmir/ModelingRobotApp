package com.example.modelingrobots

import com.example.modelingrobots.robots.kinematics.Robot
import com.example.modelingrobots.robots.kinematics.RobotDekart
import com.example.modelingrobots.robots.kinematics.RobotKoler
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RobotTest {
    private lateinit var robot: Robot
    @Before
    fun setUp() {
        robot = RobotDekart(
            1.0,
            1.0,
            0.0,
            1.0,
            0.0,
            1.0
        )
        robot.setQ1Min(0.0)
        robot.setQ1Max(1.2)
        robot.setQ2Min(0.0)
        robot.setQ2Max(1.3)
    }
    @Test
    fun correctLenth() {
        robot.setL1(2.0)
        robot.setL2(2.0)
        robot.correctLength()
        Assert.assertEquals(robot.L1, robot.maxL1, 0.001);
        Assert.assertEquals(robot.L2, robot.maxL2, 0.001);
        robot.setL1(-1.0)
        robot.setL2(-2.0)
        robot.correctLength()
        Assert.assertEquals(robot.L1, 0.0, 0.001);
        Assert.assertEquals(robot.L2, 0.0, 0.001);
        robot.setL1(0.7)
        robot.setL2(0.9)
        robot.correctLength()
        Assert.assertEquals(robot.L1, robot.L2, 0.001);
    }
    /*
    @Test
    fun correctQ1Q2Constrains() {
        var listRobots = listOf<Robot>(RobotDekart(),RobotCylindr(),RobotKoler(), RobotSkara())
        var l1 = 1.0
        var l2 = 0.7
        var listconstraights = listOf<List<Double>>(listOf(l1, l2),listOf(Math.PI, l2))
        for (i in 0..3) {
            robot = listRobots[i]
            robot.setL1(l1)
            robot.setL2(l2)
            robot.correctQ1Q2Constraints()

        }
    }*/
    @Test
    fun RobotKolergetXY() {
        robot = RobotKoler(
            1.0,
            0.5,
            0.0,
            0.9,
            -Math.PI / 2,
            Math.PI / 2
        )
        robot.setQ1(0.5)
        robot.setQ2(0.0)
        var x = robot.calcX(0.5, 0.0)
        var y = robot.calcY(0.5, 0.0)
        Assert.assertEquals(0.0, x, 0.001);
        Assert.assertEquals(robot.getQ1()+robot.L2*Math.cos(robot.getQ2()), y, 0.001);
    }
}