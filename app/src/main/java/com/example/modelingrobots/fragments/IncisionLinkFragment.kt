package com.example.modelingrobots.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.modelingrobots.R
import com.example.modelingrobots.databinding.FragmentIncisionLinkBinding
import com.example.modelingrobots.robots.linksSections.Materials
import com.example.modelingrobots.viewmodels.InsicisionLinkViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [IncisionLinkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class IncisionLinkFragment : Fragment() {
    private var _binding: FragmentIncisionLinkBinding? = null
    private val binding get() = _binding!!
    //lateinit var viewModel: InsicisionLinkViewModel
    private val viewModel: InsicisionLinkViewModel by activityViewModels()

    private var typeMat = Materials.Aluminum
    private val listMaterials = listOf(Materials.Aluminum, Materials.Steel, Materials.Plastic)
    private var typeSctn = "Круглое сплошное"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentIncisionLinkBinding.inflate(inflater, container, false)
        //viewModel =  ViewModelProvider(this).get(InsicisionLinkViewModel::class.java)
        //return inflater.inflate(R.layout.fragment_incision_link, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spin_section = binding.spinnerSection
        val spin_materials = binding.spinnerMaterial
        val typeMaterials = resources.getStringArray(R.array.materials)
        val typeSections = resources.getStringArray(R.array.type_links)
        val map_materialsToNames = mapOf(Materials.Aluminum to typeMaterials[0], Materials.Steel to typeMaterials[1], Materials.Plastic to typeMaterials[2])
        binding.etParam1.hint

        binding.btnChooseSection.setOnClickListener { 
            typeSctn = spin_section.selectedItem.toString()
            setTypeLink()
        }


        viewModel.typeLink.observe(viewLifecycleOwner, Observer { newValue ->
            val pos = typeSections.indexOf(newValue)
            spin_section.setSelection(pos)
            typeSctn = newValue
            setTypeLink()
        })
        viewModel.materialLink.observe(viewLifecycleOwner, Observer { newValue ->
            val name_material = map_materialsToNames[newValue]
            val pos = typeMaterials.indexOf(name_material)
            typeMat = newValue
            spin_materials.setSelection(pos)
        })

        viewModel.p1.observe(viewLifecycleOwner, Observer { newValue ->
            binding.etParam1.setText(newValue.toString())
        })
        viewModel.p2.observe(viewLifecycleOwner, Observer { newValue ->
            binding.etParam2.setText(newValue.toString())
        })
        viewModel.p3.observe(viewLifecycleOwner, Observer { newValue ->
            binding.etParam3.setText(newValue.toString())
        })
    }

    override fun onPause() {
        super.onPause()
        val pos_mat = binding.spinnerMaterial.selectedItemPosition
        val typeSections = resources.getStringArray(R.array.type_links)
        val pos = typeSections.indexOf(typeSctn)
        typeMat = listMaterials[pos_mat]
        val p11 = binding.etParam1.text.toString().toDouble()
        var p22 = 0.0
        var p33 = 0.0
        when(pos) {
            0 -> {
                viewModel.setValues(typeSctn, typeMat, p11)
            }
            1, 2 -> {
                p22 = binding.etParam2.text.toString().toDouble()
                viewModel.setValues(typeSctn, typeMat, p11, p22)
            }
            3 -> {
                p22 = binding.etParam2.text.toString().toDouble()
                p33 = binding.etParam3.text.toString().toDouble()
                viewModel.setValues(typeSctn, typeMat, p11, p22, p33)
            }
        }

    }

    private fun setTypeLink() {
        Toast.makeText(requireContext().applicationContext, "Выбрано $typeSctn сечение", Toast.LENGTH_LONG).show()
        binding.apply {
            when(spinnerSection.selectedItemPosition) {
                0 -> {
                    imageSection.setImageResource(R.drawable.circle_full)
                    etParam2.isFocusable = false
                    etParam2.isEnabled = false
                    etParam3.isEnabled = false
                    etParam3.isEnabled = false
                }
                1 -> {
                    imageSection.setImageResource(R.drawable.think_circle_section)
                    etParam2.isFocusable = true
                    etParam2.isEnabled = true
                    etParam3.isEnabled = false
                    etParam3.isEnabled = false
                }
                2 -> {
                    imageSection.setImageResource(R.drawable.square)
                    etParam2.isFocusable = true
                    etParam2.isEnabled = true
                    etParam3.isEnabled = false
                    etParam3.isEnabled = false
                }
                3 -> {
                    imageSection.setImageResource(R.drawable.square_think)
                    etParam2.isFocusable = true
                    etParam2.isEnabled = true
                    etParam3.isEnabled = true
                    etParam3.isEnabled = true
                }
            }
        }
    }
}