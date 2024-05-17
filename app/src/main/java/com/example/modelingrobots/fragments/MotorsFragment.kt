package com.example.modelingrobots.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.modelingrobots.R
import com.example.modelingrobots.databinding.FragmentMotorsBinding
import com.example.modelingrobots.viewmodels.MotorsViewModel

class MotorsFragment : Fragment() {

    companion object {
        fun newInstance() = MotorsFragment()
    }

    private var _binding: FragmentMotorsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MotorsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMotorsBinding.inflate(inflater, container, false)
        val view =  binding.root
        viewModel = ViewModelProvider(this).get(MotorsViewModel::class.java)
        viewModel.u1max.observe(viewLifecycleOwner, Observer { newValue ->
            TODO()
        })
        return inflater.inflate(R.layout.fragment_motors, container, false)
    }
    /*
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MotorsViewModel::class.java)
        // TODO: Use the ViewModel
    } */

}