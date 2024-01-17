package com.example.scd_proiect_mobile_android.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.SCD_proiect.data.repository.AppRepository
import com.example.scd_proiect_mobile_android.data.entities.Department
import com.example.scd_proiect_mobile_android.data.entities.DepartmentInfo
import com.example.scd_proiect_mobile_android.data.entities.Employee
import com.example.scd_proiect_mobile_android.data.entities.EmployeeInfo
import com.example.scd_proiect_mobile_android.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    val repository: AppRepository
) : ViewModel() {
    val employees = MutableLiveData<Resource<List<Employee>>>()
    val departments = MutableLiveData<Resource<List<Department>>>()
    val updatedDepartment = MutableLiveData<Resource<Department>>()
    val updatedEmployee = MutableLiveData<Resource<Employee>>()
    val deletedDepartment = MutableLiveData<Resource<Department>>()
    val deletedEmployee = MutableLiveData<Resource<Employee>>()
    val addedDepartment = MutableLiveData<Resource<Department>>()
    val addedEmployee = MutableLiveData<Resource<Employee>>()
    fun getEmployees() {
        viewModelScope.launch {
            val result = repository.remote.getEmployeeList()
            employees.postValue(result)
        }
    }
    fun getDepartments() {
        viewModelScope.launch {
            val result = repository.remote.getDepartments()
            departments.postValue(result)
        }
    }
    fun updateDepartment(id: Int, departmentInfo: DepartmentInfo){
        viewModelScope.launch {
            val result = repository.remote.updateDepartment(id,departmentInfo)
            updatedDepartment.postValue(result)
        }
    }
    fun updateEmployee(id: Int, employeeInfo: EmployeeInfo){
        viewModelScope.launch {
            val result = repository.remote.updateEmployee(id,employeeInfo)
            updatedEmployee.postValue(result)
        }
    }
    fun deleteDepartment(id: Int){
        viewModelScope.launch {
            val result = repository.remote.deleteDepartment(id)
            deletedDepartment.postValue(result)
        }
    }
    fun deleteEmployee(id: Int){
        viewModelScope.launch{
            val result = repository.remote.deleteEmployee(id)
            deletedEmployee.postValue(result)
        }
    }
    fun addDepartment(departmentInfo: DepartmentInfo){
        viewModelScope.launch{
            val result = repository.remote.addDepartment(departmentInfo)
            addedDepartment.postValue(result)
        }
    }
    fun addEmployee(employeeInfo: EmployeeInfo){
        viewModelScope.launch {
            val result = repository.remote.addEmployee(employeeInfo)
            addedEmployee.postValue(result)
        }
    }
}