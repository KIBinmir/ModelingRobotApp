package com.example.modelingrobots.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.modelingrobots.R
import com.example.modelingrobots.databinding.FragmentMotorsBinding
import com.example.modelingrobots.viewmodels.MotorsViewModel
import com.google.android.material.textfield.TextInputEditText

class MotorsFragment : Fragment() {
    /*lateinit var j1: TextInputEditText
    lateinit var j2: TextInputEditText
    lateinit var l1: TextInputEditText
    lateinit var l2: TextInputEditText
    lateinit var r1: TextInputEditText
    lateinit var r2: TextInputEditText
    lateinit var ke1: TextInputEditText
    lateinit var ke2: TextInputEditText
    lateinit var km1: TextInputEditText
    lateinit var km2: TextInputEditText*/

    companion object {
        fun newInstance() = MotorsFragment()
    }

    //private lateinit var viewModel: MotorsViewModel
    private val viewModel: MotorsViewModel by activityViewModels()
    private var _binding: FragmentMotorsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val view = inflater.inflate(R.layout.fragment_motors, container, false)
        //viewModel = ViewModelProvider(this).get(MotorsViewModel::class.java)
        //return view
        _binding = FragmentMotorsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*j1 = view.findViewById(R.id.et_J1)
        j2 = view.findViewById(R.id.et_J2)
        l1 = view.findViewById(R.id.et_Lm1)
        l2 = view.findViewById(R.id.et_Lm2)
        r1 = view.findViewById(R.id.et_R1)
        r2 = view.findViewById(R.id.et_R2)
        km1 = view.findViewById(R.id.et_km1)
        km2 = view.findViewById(R.id.et_km2)
        ke1 = view.findViewById(R.id.et_ke1)
        ke2 = view.findViewById(R.id.et_ke2)*/

        viewModel.l1.observe(viewLifecycleOwner, Observer { l ->
            binding.etLm1.setText(l.toString())
        })
        viewModel.l2.observe(viewLifecycleOwner, Observer { l ->
            binding.etLm2.setText(l.toString())
        })
        viewModel.r1.observe(viewLifecycleOwner, Observer { r ->
            binding.etR1.setText(r.toString())
        })
        viewModel.r2.observe(viewLifecycleOwner, Observer { r ->
            binding.etR2.setText(r.toString())
        })
        viewModel.j1.observe(viewLifecycleOwner, Observer { j ->
            binding.etJ1.setText(j.toString())
        })
        viewModel.j2.observe(viewLifecycleOwner, Observer { j ->
            binding.etJ2.setText(j.toString())
        })
        viewModel.ke1.observe(viewLifecycleOwner, Observer { k ->
            binding.etKe1.setText(k.toString())
        })
        viewModel.ke2.observe(viewLifecycleOwner, Observer { k ->
            binding.etKe2.setText(k.toString())
        })
        viewModel.km1.observe(viewLifecycleOwner, Observer { k ->
            binding.etKm1.setText(k.toString())
        })
        viewModel.km2.observe(viewLifecycleOwner, Observer { k ->
            binding.etKm2.setText(k.toString())
        })

    }
    override fun onPause() {
        val j11 = binding.etJ1.text.toString().toDouble()
        val r11 = binding.etR1.text.toString().toDouble()
        val l11 = binding.etLm1.text.toString().toDouble()
        val j22 = binding.etJ2.text.toString().toDouble()
        val r22 = binding.etR2.text.toString().toDouble()
        val l22 = binding.etLm2.text.toString().toDouble()
        val ke11 = binding.etKe1.text.toString().toDouble()
        val ke22 = binding.etKe2.text.toString().toDouble()
        val km11 = binding.etKm1.text.toString().toDouble()
        val km22 = binding.etKm2.text.toString().toDouble()
        viewModel.setValues1(j11, l11, r11, km11, ke11)
        viewModel.setValues2(j22, l22, r22, km22, ke22)
        super.onPause()
    }

}