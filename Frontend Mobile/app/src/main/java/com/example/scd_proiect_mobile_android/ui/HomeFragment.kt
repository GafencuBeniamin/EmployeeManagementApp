package com.example.scd_proiect_mobile_android.ui

import android.app.ActionBar
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.view.isInvisible
import androidx.core.view.setMargins
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scd_proiect_mobile_android.R
import com.example.scd_proiect_mobile_android.data.entities.Department
import com.example.scd_proiect_mobile_android.data.entities.Employee
import com.example.scd_proiect_mobile_android.databinding.FragmentHomeBinding
import com.example.scd_proiect_mobile_android.ui.adapters.DepartmentsAdapter
import com.example.scd_proiect_mobile_android.ui.adapters.EmployeesAdapter
import com.example.scd_proiect_mobile_android.ui.viewmodels.AppViewModel
import com.example.scd_proiect_mobile_android.util.Resource
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), DepartmentsAdapter.DepartmentItemListener, EmployeesAdapter.EmployeeItemListener {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var departmentsAdapter: DepartmentsAdapter
    private lateinit var employeesAdapter : EmployeesAdapter
    private val viewModel: AppViewModel by viewModels()
    private var selectedDepartmentId: Int? = null
    private var selectedEmployeeId: Int?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupDepartmentRV()
        setupEmployeeRV()
        viewModel.getDepartments()
        setupDepartmentObserver()
        viewModel.getEmployees()
        setupEmployeesObserver()

        binding.deleteEmployee.isInvisible=true
        binding.deleteDepartment.isInvisible=true
        binding.editDepartment.isInvisible=true
        binding.editEmployee.isInvisible=true

        binding.addEmployee.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_addEmployeeFragment)
        }
        binding.editEmployee.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_editEmployeeFragment,bundleOf(
                Pair("employeeId",selectedEmployeeId)
            ))
        }
        binding.editDepartment.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_editDepartmentFragment,bundleOf(
                Pair("departmentId",selectedDepartmentId)
            ))
        }
        binding.addDepartment.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_addDepartmentFragment)
        }
        binding.deleteDepartment.setOnClickListener {
            selectedDepartmentId?.let { id -> viewModel.deleteDepartment(id) }
            setupDeleteDepartmentObserver()
        }
        binding.deleteEmployee.setOnClickListener {
            selectedEmployeeId?.let { id -> viewModel.deleteEmployee(id) }
            setupDeleteEmployeeObserver()
        }
    }




    private fun setupDepartmentRV() {
        departmentsAdapter = DepartmentsAdapter(this)
        binding.departmentRV.layoutManager = LinearLayoutManager(requireContext())
        binding.departmentRV.adapter= departmentsAdapter
//        binding.departmentRV.itemAnimator=null //to delete animation
    }
    private fun setupEmployeeRV() {
        employeesAdapter = EmployeesAdapter(this)
        binding.employeeRV.layoutManager = LinearLayoutManager(requireContext())
        binding.employeeRV.adapter= employeesAdapter
    }
    fun showRedSnackbar(message: String) {
        val snackbar = Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG)
        val snackbarView = snackbar.view
        snackbarView.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.light_red))
        snackbar.setActionTextColor(Color.WHITE)
        snackbar.setAction("x") {snackbar.dismiss()}
        snackbar.show()
    }
    private fun setupDeleteEmployeeObserver() {
        viewModel.deletedEmployee.observe(viewLifecycleOwner, Observer{
            when (it.status){
                Resource.Status.SUCCESS -> {
                    if (it.data !== null) {
                        showRedSnackbar("Employee $selectedEmployeeId deleted successfully")
                        viewModel.getEmployees()
                        setupEmployeesObserver()
                        binding.editEmployee.isInvisible=true
                        binding.deleteEmployee.isInvisible=true
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
    private fun setupDeleteDepartmentObserver() {
        viewModel.deletedDepartment.observe(viewLifecycleOwner, Observer{
            when (it.status){
                Resource.Status.SUCCESS -> {
                    if (it.data !== null) {
                        showRedSnackbar("Department $selectedDepartmentId deleted successfully")
                        binding.editDepartment.isInvisible=true
                        binding.deleteDepartment.isInvisible=true
                        viewModel.getDepartments()
                        setupDepartmentObserver()

                        viewModel.getEmployees()
                        setupEmployeesObserver()
                        employeesAdapter.clearSelection()
                        binding.editEmployee.isInvisible=true
                        binding.deleteEmployee.isInvisible=true
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
    private fun setupDepartmentObserver() {
        viewModel.departments.observe(viewLifecycleOwner, Observer{
            when (it.status){
                Resource.Status.SUCCESS -> {
                    if (it.data !== null && it.data.isNotEmpty()){
                        departmentsAdapter.setItems(ArrayList(it.data))
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
    private fun setupEmployeesObserver() {
        viewModel.employees.observe(viewLifecycleOwner, Observer{
            when (it.status){
                Resource.Status.SUCCESS -> {
                    if (it.data !== null && it.data.isNotEmpty()){
                        employeesAdapter.setItems(ArrayList(it.data))
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClickedDepartment(department: Department) {
        val selectedPosition = departmentsAdapter.items.indexOf(department)
        departmentsAdapter.setSelectedItem(selectedPosition)
        selectedDepartmentId = department.id
        binding.editDepartment.isInvisible=false
        binding.deleteDepartment.isInvisible=false
        Log.d("Selected department on selection",selectedDepartmentId.toString())
        Log.d("Selected department position on selection",selectedPosition.toString())
    }

    override fun onClickedEmployee(employee: Employee) {
        val selectedPosition = employeesAdapter.items.indexOf(employee)
        employeesAdapter.setSelectedItem(selectedPosition)
        selectedEmployeeId = employee.id
        binding.editEmployee.isInvisible=false
        binding.deleteEmployee.isInvisible=false
    }
}