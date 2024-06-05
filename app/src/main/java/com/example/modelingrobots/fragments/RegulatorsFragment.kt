package com.example.modelingrobots.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.example.modelingrobots.R
import com.example.modelingrobots.viewmodels.RegulatorsViewModel
import com.google.android.material.textfield.TextInputEditText

class RegulatorsFragment : Fragment() {
    lateinit var kp1: TextInputEditText
    lateinit var kd1: TextInputEditText
    lateinit var ki1: TextInputEditText
    lateinit var kp2: TextInputEditText
    lateinit var kd2: TextInputEditText
    lateinit var ki2: TextInputEditText

    companion object {
        fun newInstance() = RegulatorsFragment()
    }

    private lateinit var viewModel: RegulatorsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_regulators, container, false)
        kp1 = view.findViewById(R.id.et_kp1)
        kp2 = view.findViewById(R.id.et_kp2)
        kd1 = view.findViewById(R.id.et_kd1)
        kd2 = view.findViewById(R.id.et_kd2)
        ki1 = view.findViewById(R.id.et_ki1)
        ki2 = view.findViewById(R.id.et_ki2)
        viewModel = ViewModelProvider(this).get(RegulatorsViewModel::class.java)

        viewModel.kp1.observe(viewLifecycleOwner, Observer { k ->
            kp1.setText(k.toString())
        })
        viewModel.kp2.observe(viewLifecycleOwner, Observer { k ->
            kp2.setText(k.toString())
        })
        viewModel.kd1.observe(viewLifecycleOwner, Observer { k ->
            kd1.setText(k.toString())
        })
        viewModel.kd2.observe(viewLifecycleOwner, Observer { k ->
            kd2.setText(k.toString())
        })
        viewModel.ki1.observe(viewLifecycleOwner, Observer { k ->
            ki1.setText(k.toString())
        })
        viewModel.ki2.observe(viewLifecycleOwner, Observer { k ->
            ki2.setText(k.toString())
        })
        return view
    }

    override fun onPause() {
        Toast.makeText(context, "Data saved", Toast.LENGTH_LONG).show()
        val kp11 = kp1.text.toString().toDouble()
        val kd11 = kd1.text.toString().toDouble()
        val ki11 = ki1.text.toString().toDouble()
        val kp22 = kp2.text.toString().toDouble()
        val kd22 = kd2.text.toString().toDouble()
        val ki22 = ki2.text.toString().toDouble()
        viewModel.setValues(kp11, kd11, ki11, kp22, kd22, ki22)
        super.onPause()
    }

}