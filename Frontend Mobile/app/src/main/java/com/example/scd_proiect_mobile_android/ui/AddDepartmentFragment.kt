package com.example.scd_proiect_mobile_android.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.scd_proiect_mobile_android.R
import com.example.scd_proiect_mobile_android.data.entities.DepartmentInfo
import com.example.scd_proiect_mobile_android.databinding.FragmentAddDepartmentBinding
import com.example.scd_proiect_mobile_android.ui.viewmodels.AppViewModel
import com.example.scd_proiect_mobile_android.util.Resource
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddDepartmentFragment : Fragment() {

    private var _binding: FragmentAddDepartmentBinding? = null
    private val viewModel: AppViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddDepartmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener{
                var parent = 0
                if(!binding.parentEditText.text.isNullOrBlank())
                    parent=binding.parentEditText.text.toString().toInt()

                viewModel.addDepartment(DepartmentInfo(
                    binding.descriptionEditText.text.toString(),
                    parent
                ))
                setupAddDepartmentObserver()}
    }

    private fun setupAddDepartmentObserver() {
        viewModel.addedDepartment.observe(viewLifecycleOwner, Observer{
            when (it.status){
                Resource.Status.SUCCESS -> {
                    if (it.data !== null){
                        findNavController().navigate(R.id.action_addDepartmentFragment_to_HomeFragment)
                        showGreenSnackbar("Department ${it.data.id} added successfully")
                    }
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(
                        requireContext(),
                        it.message,
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d("Eroare la request",it.message.toString())
                }
                Resource.Status.LOADING -> {/*add progress bar*/}
            }
        })
    }
    fun showGreenSnackbar(message: String) {
        val snackbar = Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG)
        val snackbarView = snackbar.view
        snackbarView.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.light_green))
        snackbar.setTextColor(Color.BLACK)
        snackbar.setActionTextColor(Color.BLACK)
        snackbar.setAction("x") {snackbar.dismiss()}
        snackbar.show()
    }
}