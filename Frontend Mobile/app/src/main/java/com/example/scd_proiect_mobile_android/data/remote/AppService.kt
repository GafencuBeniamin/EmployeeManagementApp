package com.example.scd_proiect_mobile_android.data.remote

import com.example.scd_proiect_mobile_android.data.entities.Department
import com.example.scd_proiect_mobile_android.data.entities.DepartmentInfo
import com.example.scd_proiect_mobile_android.data.entities.Employee
import com.example.scd_proiect_mobile_android.data.entities.EmployeeInfo
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface AppService {

    @GET("employees")
    suspend fun getEmployeeList(): Response<List<Employee>>
    @GET("departments")
    suspend fun getDepartments(): Response<List<Department>>
    @POST("departments")
    suspend fun addDepartment(@Body departmentInfo: DepartmentInfo): Response<Department>
    @POST("employees")
    suspend fun addEmployee(@Body employeeInfo: EmployeeInfo): Response<Employee>
    @DELETE("departments/{id}")
    suspend fun  deleteDepartment(@Path("id") id:Int) : Response<Department>
    @DELETE("employees/{id}")
    suspend fun  deleteEmployee(@Path("id") id:Int) : Response<Employee>
    @PUT("departments/{id}")
    suspend fun  updateDepartment(@Path("id") id:Int,@Body departmentInfo: DepartmentInfo) : Response<Department>
    @PUT("employees/{id}")
    suspend fun  updateEmployee(@Path("id") id:Int,@Body employeeInfo: EmployeeInfo) : Response<Employee>

}