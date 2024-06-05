package com.example.modelingrobots.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
    lateinit var viewModel: ParametersRobotsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentParametersRobotBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(this).get(ParametersRobotsViewModel::class.java)
        viewModel.l1.observe(viewLifecycleOwner, Observer { newValue ->
            binding.layoutInputL1.editText!!.setText(newValue)
        })
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parameters_robot, container, false)
    }
}