package com.example.modelingrobots.fragments

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.modelingrobots.R
import com.example.modelingrobots.databinding.FragmentParametersRobotBinding
import com.example.modelingrobots.viewmodels.ParametersRobotsViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [ParametersRobot.newInstance] factory method to
 * create an instance of this fragment.
 */
class ParametersRobot : Fragment() {
    private var _binding: FragmentParametersRobotBinding? = null
    private val binding get() = _binding!!
    //lateinit var viewModel: ParametersRobotsViewModel
    private val viewModel: ParametersRobotsViewModel by activityViewModels()
    private var typeR: String = "Декарт"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentParametersRobotBinding.inflate(inflater, container, false)
        //viewModel = ViewModelProvider(this).get(ParametersRobotsViewModel::class.java)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val types_robot = resources.getStringArray(R.array.names_robots)
        val spinR = binding.spinnerRobots

        binding.btnChooseRobot.setOnClickListener {
            typeR = spinR.selectedItem.toString()
            Toast.makeText(requireContext().applicationContext, "Выбран робот $typeR", Toast.LENGTH_LONG).show()
            when (typeR) {
                types_robot[0] -> binding.imageRobot.setImageResource(R.drawable.robot_dekart)
                types_robot[1] -> binding.imageRobot.setImageResource(R.drawable.robot_cylindr)
                types_robot[2] -> binding.imageRobot.setImageResource(R.drawable.robot_koler)
                types_robot[3] -> binding.imageRobot.setImageResource(R.drawable.robot_skara)
                else -> binding.imageRobot.setImageResource(R.drawable.robot_dekart)
            }
        }


        viewModel.typeRobot.observe(viewLifecycleOwner, Observer { newValue ->
            binding.spinnerRobots.setSelection(types_robot.indexOf(newValue))
            typeR = newValue
            Toast.makeText(requireContext().applicationContext, "Выбран робот $typeR", Toast.LENGTH_LONG).show()
            when (typeR) {
                types_robot[0] -> binding.imageRobot.setImageResource(R.drawable.robot_dekart)
                types_robot[1] -> binding.imageRobot.setImageResource(R.drawable.robot_cylindr)
                types_robot[2] -> binding.imageRobot.setImageResource(R.drawable.robot_koler)
                types_robot[3] -> binding.imageRobot.setImageResource(R.drawable.robot_skara)
                else -> binding.imageRobot.setImageResource(R.drawable.robot_dekart)
            }
        })

        viewModel.l1.observe(viewLifecycleOwner, Observer { newValue ->
            binding.etLength1.setText(newValue.toString())
        })
        viewModel.l2.observe(viewLifecycleOwner, Observer { newValue ->
            binding.etLength2.setText(newValue.toString())
        })
        viewModel.q1min.observe(viewLifecycleOwner, Observer { newValue ->
            binding.etQ1min.setText(newValue.toString())
        })
        viewModel.q1max.observe(viewLifecycleOwner, Observer { newValue ->
            binding.etQ1max.setText(newValue.toString())
        })
        viewModel.q2min.observe(viewLifecycleOwner, Observer { newValue ->
            binding.etQ2min.setText(newValue.toString())
        })
        viewModel.q2max.observe(viewLifecycleOwner, Observer { newValue ->
            binding.etQ2max.setText(newValue.toString())
        })

    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(requireContext().applicationContext, "ok$typeR", Toast.LENGTH_LONG).show()
        val l11 = binding.etLength1.text.toString().toDouble()
        val l22 = binding.etLength1.text.toString().toDouble()
        val q1min1 = binding.etLength1.text.toString().toDouble()
        val q1max1 = binding.etLength1.text.toString().toDouble()
        val q2min2 = binding.etLength1.text.toString().toDouble()
        val q2max2 = binding.etLength1.text.toString().toDouble()
        viewModel.setValues(typeR, l11, l22, q1min1, q1max1, q2min2, q2max2)
    }
}