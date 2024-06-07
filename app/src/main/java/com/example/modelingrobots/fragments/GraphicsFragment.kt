package com.example.modelingrobots.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Cartesian
import com.anychart.core.cartesian.series.Line
import com.anychart.data.Mapping
import com.anychart.data.Set
import com.anychart.enums.Anchor
import com.anychart.enums.MarkerType
import com.anychart.enums.TooltipPositionMode
import com.anychart.graphics.vector.Stroke
import com.example.modelingrobots.R
import com.example.modelingrobots.databinding.FragmentGraphicsBinding
import com.example.modelingrobots.robots.SystemRobot
import com.example.modelingrobots.robots.dynamics.DynamicRobot
import com.example.modelingrobots.viewmodels.GraphicsViewModel
import com.example.modelingrobots.viewmodels.InsicisionLinkViewModel
import com.example.modelingrobots.viewmodels.MotorsViewModel
import com.example.modelingrobots.viewmodels.ParametersRobotsViewModel
import com.example.modelingrobots.viewmodels.RegulatorsViewModel
import com.example.modelingrobots.viewmodels.TrajectoryParametersViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [GraphicsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GraphicsFragment : Fragment() {

    private var _binding: FragmentGraphicsBinding? = null
    private val binding get() = _binding!!
    //lateinit var viewModel: GraphicsViewModel
    val robotViewModel: ParametersRobotsViewModel by activityViewModels()
    val sectionViewModel: InsicisionLinkViewModel by activityViewModels()
    val regulatorsViewModel: RegulatorsViewModel by activityViewModels()
    val motorsViewModel: MotorsViewModel by activityViewModels()
    val trajectoryViewModel: TrajectoryParametersViewModel by activityViewModels()
    lateinit var system: SystemRobot

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGraphicsBinding.inflate(inflater, container, false)
        //viewModel = ViewModelProvider(this).get(GraphicsViewModel::class.java)
        return binding.root
        // inflater.inflate(R.layout.fragment_graphics, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val anyChartView: AnyChartView = binding.anyChartView
        anyChartView.setProgressBar(binding.progressModeling)

        val configRobot = robotViewModel.robotConfig
        val l1 = configRobot.L1
        val l2 = configRobot.L2
        val listMass1 = sectionViewModel.getMassInertion(l1)
        val listMass2 = sectionViewModel.getMassInertion(l2)
        val dynamicRobot = DynamicRobot(listMass1[0], listMass2[0], listMass1[1], listMass2[1], l1, l2)
        val pid1 = regulatorsViewModel.reg1
        val pid2 = regulatorsViewModel.reg2
        val motor1 = motorsViewModel.motor1
        val motor2 = motorsViewModel.motor2
        system = SystemRobot(configRobot, dynamicRobot, pid1, pid2, motor1, motor2)
        val data = trajectoryViewModel.timeTable.value!!
        val typeTraj = trajectoryViewModel.typeCoordinates.value!!
        val typesCoordinate = resources.getStringArray(R.array.type_coordinates)




        val cartesian: Cartesian = AnyChart.line()

        cartesian.apply {
            animation(true)

            padding(10.0, 20.0, 5.0, 20.0)

            crosshair().enabled(true)
            crosshair()
                .yLabel(true) // TODO ystroke
                .yStroke(null as Stroke?, null, null, null as String?, null as String?)

            tooltip().positionMode(TooltipPositionMode.POINT)

            title("Графики движения манипулятора")

            //yAxis(0).title("Number of Bottles Sold (thousands)")
            //xAxis(0).labels().padding(5.0, 5.0, 5.0, 5.0)
            xAxis(0).title("Время")
        }

        val seriesData: MutableList<DataEntry> = ArrayList()

        if (typeTraj == typesCoordinate[0]) {
            system.setStartXY(data[0].q1,data[0].q2)
            while(system.t < data[1].t) {
                var el = system.simXY(data[1].q1, data[1].q2)
                var x = configRobot.calcX(system.q1, system.q2)
                var y = configRobot.calcY(system.q1, system.q2)
                seriesData.add(CustomDataEntry(system.t.toString(), system.q1, system.q2, x, y))
            }
        }
        else {
            system.setStart(data[0].q1,data[0].q2)
            while(system.t < data[1].t) {
                var el = system.sim(data[1].q1, data[1].q2)
                var x = configRobot.calcX(system.q1, system.q2)
                var y = configRobot.calcY(system.q1, system.q2)
                seriesData.add(CustomDataEntry(system.t.toString(), system.q1, system.q2, x, y))
            }
        }
        /*seriesData.add(CustomDataEntry("1986", 3.6, 2.3, 2.8))
        seriesData.add(CustomDataEntry("1987", 7.1, 4.0, 4.1))
        seriesData.add(CustomDataEntry("1988", 8.5, 6.2, 5.1))
        seriesData.add(CustomDataEntry("1989", 9.2, 11.8, 6.5))
        seriesData.add(CustomDataEntry("1990", 10.1, 13.0, 12.5))
        seriesData.add(CustomDataEntry("1991", 11.6, 13.9, 18.0))
        seriesData.add(CustomDataEntry("1992", 16.4, 18.0, 21.0))
        seriesData.add(CustomDataEntry("1993", 18.0, 23.3, 20.3))
        seriesData.add(CustomDataEntry("1994", 13.2, 24.7, 19.2))
        seriesData.add(CustomDataEntry("1995", 12.0, 18.0, 14.4))
        seriesData.add(CustomDataEntry("1996", 3.2, 15.1, 9.2))
        seriesData.add(CustomDataEntry("1997", 4.1, 11.3, 5.9))
        seriesData.add(CustomDataEntry("1998", 6.3, 14.2, 5.2))
        seriesData.add(CustomDataEntry("1999", 9.4, 13.7, 4.7))
        seriesData.add(CustomDataEntry("2000", 11.5, 9.9, 4.2))
        seriesData.add(CustomDataEntry("2001", 13.5, 12.1, 1.2))
        seriesData.add(CustomDataEntry("2002", 14.8, 13.5, 5.4))
        seriesData.add(CustomDataEntry("2003", 16.6, 15.1, 6.3))
        seriesData.add(CustomDataEntry("2004", 18.1, 17.9, 8.9))
        seriesData.add(CustomDataEntry("2005", 17.0, 18.9, 10.1))
        seriesData.add(CustomDataEntry("2006", 16.6, 20.3, 11.5))
        seriesData.add(CustomDataEntry("2007", 14.1, 20.7, 12.2))
        seriesData.add(CustomDataEntry("2008", 15.7, 21.6, 10))
        seriesData.add(CustomDataEntry("2009", 12.0, 22.5, 8.9))*/


        val set = Set.instantiate()
        set.data(seriesData)
        val series1Mapping: Mapping = set.mapAs("{ x: 'x', value: 'value' }")
        val series2Mapping: Mapping = set.mapAs("{ x: 'x', value: 'value2' }")
        val series3Mapping: Mapping = set.mapAs("{ x: 'x', value: 'value3' }")
        val series4Mapping: Mapping = set.mapAs("{ x: 'x', value: 'value4' }")

        val series1: Line = cartesian.line(series1Mapping)
        series1.apply {
            name("q1")
            hovered().markers().enabled(true)
            hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4.0)
            tooltip()
                .position("right")
                .anchor(Anchor.LEFT_CENTER)
                .offsetX(5.0)
                .offsetY(5.0)
        }

        val series2: Line = cartesian.line(series2Mapping)
        series2.apply {
            name("q2")
            hovered().markers().enabled(true)
            hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4.0)
            tooltip()
                .position("right")
                .anchor(Anchor.LEFT_CENTER)
                .offsetX(5.0)
                .offsetY(5.0)
        }

        val series3: Line = cartesian.line(series3Mapping)
        series3.apply {
            name("x")
            hovered().markers().enabled(true)
            hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4.0)
            tooltip()
                .position("y")
                .anchor(Anchor.LEFT_CENTER)
                .offsetX(5.0)
                .offsetY(5.0)
        }

        cartesian.legend().apply {
            enabled(true)
            fontSize(13.0)
            padding(0.0, 0.0, 10.0, 0.0)
        }

        val series4: Line = cartesian.line(series3Mapping)
        series4.apply {
            name("y")
            hovered().markers().enabled(true)
            hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4.0)
            tooltip()
                .position("y")
                .anchor(Anchor.LEFT_CENTER)
                .offsetX(5.0)
                .offsetY(5.0)
        }

        cartesian.legend().apply {
            enabled(true)
            fontSize(13.0)
            padding(0.0, 0.0, 10.0, 0.0)
        }

        anyChartView.setChart(cartesian)
    }
    private class CustomDataEntry internal constructor(
        x: String?,
        value: Number?,
        value2: Number?,
        value3: Number?,
        value4: Number?
    ) :
        ValueDataEntry(x, value) {
        init {
            setValue("value2", value2)
            setValue("value3", value3)
            setValue("value4", value4)
        }
    }
}