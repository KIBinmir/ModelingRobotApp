package com.example.modelingrobots

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class RegulatorsFragment : Fragment() {

    companion object {
        fun newInstance() = RegulatorsFragment()
    }

    private lateinit var viewModel: RegulatorsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_regulators, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegulatorsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}