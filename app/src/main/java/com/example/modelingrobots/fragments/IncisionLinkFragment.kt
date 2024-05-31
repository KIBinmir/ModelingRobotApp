package com.example.modelingrobots.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.modelingrobots.R

/**
 * A simple [Fragment] subclass.
 * Use the [IncisionLinkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class IncisionLinkFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_incision_link, container, false)
    }
}