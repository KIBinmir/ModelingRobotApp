package com.example.modelingrobots.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.modelingrobots.R
import com.example.modelingrobots.databinding.FragmentMotorsBinding
import com.example.modelingrobots.viewmodels.MotorsViewModel
import com.example.modelingrobots.viewmodels.RegulatorsViewModel
import com.google.android.material.textfield.TextInputEditText

class MotorsFragment : Fragment() {
    lateinit var j1: TextInputEditText
    lateinit var j2: TextInputEditText
    lateinit var l1: TextInputEditText
    lateinit var l2: TextInputEditText
    lateinit var r1: TextInputEditText
    lateinit var r2: TextInputEditText
    lateinit var ke1: TextInputEditText
    lateinit var ke2: TextInputEditText
    lateinit var km1: TextInputEditText
    lateinit var km2: TextInputEditText

    companion object {
        fun newInstance() = MotorsFragment()
    }

    private lateinit var viewModel: MotorsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_motors, container, false)
        l1 = view.findViewById(R.id.et_Lm1)
        l2 = view.findViewById(R.id.et_Lm2)
        r1 = view.findViewById(R.id.et_R1)
        r2 = view.findViewById(R.id.et_R2)
        km1 = view.findViewById(R.id.et_km1)
        km2 = view.findViewById(R.id.et_km2)
        ke1 = view.findViewById(R.id.et_ke1)
        ke2 = view.findViewById(R.id.et_ke2)

        viewModel.l1.observe(viewLifecycleOwner, Observer { l ->
            l1.setText(l.toString())
        })
        viewModel.l2.observe(viewLifecycleOwner, Observer { l ->
            l2.setText(l.toString())
        })
        viewModel.r1.observe(viewLifecycleOwner, Observer { r ->
            r1.setText(r.toString())
        })
        viewModel.r2.observe(viewLifecycleOwner, Observer { r ->
            r2.setText(r.toString())
        })
        viewModel.j1.observe(viewLifecycleOwner, Observer { j ->
            j1.setText(j.toString())
        })
        viewModel.j2.observe(viewLifecycleOwner, Observer { j ->
            j2.setText(j.toString())
        })
        viewModel.ke1.observe(viewLifecycleOwner, Observer { k ->
            ke1.setText(k.toString())
        })
        viewModel.ke2.observe(viewLifecycleOwner, Observer { k ->
            ke2.setText(k.toString())
        })
        viewModel.km1.observe(viewLifecycleOwner, Observer { k ->
            km1.setText(k.toString())
        })
        viewModel.km2.observe(viewLifecycleOwner, Observer { k ->
            km2.setText(k.toString())
        })

        return view
    }
    override fun onPause() {
        val j11 = j1.text.toString().toDouble()
        val r11 = r1.text.toString().toDouble()
        val l11 = l1.text.toString().toDouble()
        val j22 = j2.text.toString().toDouble()
        val r22 = l2.text.toString().toDouble()
        val l22 = r2.text.toString().toDouble()
        val ke11 = ke1.text.toString().toDouble()
        val ke22 = ke2.text.toString().toDouble()
        val km11 = km1.text.toString().toDouble()
        val km22 = km2.text.toString().toDouble()
        viewModel.setValues1(j11, l11, r11, km11, ke11)
        viewModel.setValues1(j22, l22, r22, km22, ke22)
        super.onPause()
    }

}