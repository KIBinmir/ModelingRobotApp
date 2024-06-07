package com.example.modelingrobots.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modelingrobots.ItemTimeTable
import com.example.modelingrobots.R
import com.example.modelingrobots.TimeDataAdapter
import com.example.modelingrobots.databinding.FragmentTrajectoryBinding
import com.example.modelingrobots.viewmodels.InsicisionLinkViewModel
import com.example.modelingrobots.viewmodels.TrajectoryParametersViewModel

class TrajectoryFragment : Fragment() {
    private var _binding: FragmentTrajectoryBinding? = null
    private val binding get() = _binding!!
    //lateinit var viewModel: TrajectoryParametersViewModel
    private val viewModel: TrajectoryParametersViewModel by activityViewModels()

    private var typeCoord: String = "Декартовые"
    private val n = 2


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTrajectoryBinding.inflate(inflater, container, false)
        //viewModel = ViewModelProvider(this).get(TrajectoryParametersViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = List<ItemTimeTable>(n, {i -> ItemTimeTable(i*5.0, 0.0, 0.0) })
        val typesCoordinates = resources.getStringArray(R.array.type_coordinates)
        /*val timeDataAdapter = TimeDataAdapter(data)

        val recyclerView = binding.timedataRecycler
        recyclerView.layoutManager = LinearLayoutManager(requireContext().applicationContext)
        recyclerView.adapter = timeDataAdapter*/
        binding.radioDekart.setOnClickListener(View.OnClickListener {
            typeCoord = typesCoordinates[0]
            changeOnDekart()
        })
        binding.radioRelate.setOnClickListener(View.OnClickListener {
            typeCoord = typesCoordinates[1]
            changeOnRelate()
        })

        viewModel.typeCoordinates.observe(viewLifecycleOwner, Observer { newValue ->
            typeCoord = newValue
            if (typeCoord == typesCoordinates[0]) {
                changeOnDekart()
            }
            else {
                changeOnRelate()
            }
        })
        viewModel.timeTable.observe(viewLifecycleOwner, Observer { newValue ->
            val data = newValue
            binding.apply {
                etTime0.setText(data[0].t.toString())
                etQ1time0.setText(data[0].q1.toString())
                etQ2time0.setText(data[0].q2.toString())
                etTime1.setText(data[1].t.toString())
                etQ1time1.setText(data[0].q1.toString())
                etQ2time1.setText(data[0].q2.toString())
            }
        })
    }

    override fun onPause() {
        super.onPause()
        val t0 = binding.etTime0.text.toString().toDouble()
        val t1 = binding.etTime1.text.toString().toDouble()
        val q10 = binding.etQ1time0.text.toString().toDouble()
        val q20 = binding.etQ2time0.text.toString().toDouble()
        val q11 = binding.etQ1time1.text.toString().toDouble()
        val q21 = binding.etQ2time1.text.toString().toDouble()

        val data = listOf<ItemTimeTable>(ItemTimeTable(t0, q10, q20), ItemTimeTable(t1, q11, q21))
        viewModel.setValues(typeCoord, data)
    }
    private fun changeOnDekart() {
        binding.apply {
            etQ1time0.hint = "x(t0)"
            etQ2time0.hint = "y(t0)"
            etQ1time1.hint = "x(t1)"
            etQ1time1.hint = "y(t1)"
        }
    }
    private fun changeOnRelate() {
        binding.apply {
            etQ1time0.hint = "q1(t0)"
            etQ2time0.hint = "q2(t0)"
            etQ1time1.hint = "q1(t1)"
            etQ1time1.hint = "q2(t1)"
        }
    }
}