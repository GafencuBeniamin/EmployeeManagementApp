package com.example.scd_proiect_mobile_android.data.remote

import com.example.scd_proiect_mobile_android.data.entities.DepartmentInfo
import com.example.scd_proiect_mobile_android.data.entities.EmployeeInfo
import javax.inject.Inject

class AppRemoteDataSource @Inject constructor(
    private val appService: AppService
) : BaseDataSource() {
    suspend fun getEmployeeList() = getResult { appService.getEmployeeList() }
    suspend fun getDepartments() = getResult { appService.getDepartments() }
    suspend fun addEmployee(employeeInfo: EmployeeInfo) = getResult { appService.addEmployee(employeeInfo)}
    suspend fun addDepartment(departmentInfo: DepartmentInfo) = getResult { appService.addDepartment(departmentInfo)}
    suspend fun updateEmployee(id: Int, employeeInfo: EmployeeInfo) = getResult { appService.updateEmployee(id,employeeInfo) }
    suspend fun updateDepartment(id: Int, departmentInfo: DepartmentInfo) = getResult { appService.updateDepartment(id,departmentInfo)}
    suspend fun deleteEmployee(id: Int) = getResult { appService.deleteEmployee(id) }
    suspend fun deleteDepartment(id: Int)= getResult { appService.deleteDepartment(id) }

//    suspend fun getBuildings() = getResult { buildingService.getBuildingsSummary() }
//    suspend fun getBuilding(id: String) = getResult { buildingService.getBuilding(id) }
//    suspend fun getAvailableSeats(seatInfo: SeatInfo) =
//        getResult { buildingService.getAvailableSeats(seatInfo) }
//
//    suspend fun getMetaFloor(abbr: String) = getResult { buildingService.getMetaFloor(abbr) }
//
//    suspend fun postMyBooking(bookingEvents: List<BookingEvents>) =
//        getResult { buildingService.postMyBooking(bookingEvents) }
//
//    suspend fun editBooking(bookingEvents: List<BookingEventEdit>) =
//        getResult { buildingService.editBooking(bookingEvents) }
//
//    suspend fun getUserDetails() = getResult { buildingService.getUserDetails() }
//
//    suspend fun getFloorById(id: String) = getResult { buildingService.getFloorById(id) }
//    suspend fun getSeatById(id: String) = getResult { buildingService.getSeatById(id) }
//
//    suspend fun getBookings(request: BookingRequest) = getResult { buildingService.getBookings(request) }
//
//    suspend fun deleteBooking(id: String) = getResult { buildingService.deleteBooking(id) }
//
//    suspend fun checkIn(checkInEvent: CheckInEvent) = getResult { buildingService.checkIn(checkInEvent) }
//
//    suspend fun updateRpaPhone(rpaPhone: RpaPhone) = getResult { buildingService.updateRpaPhone(rpaPhone) }
//
//    suspend fun checkboxNotification(notificationEvent: NotificationEvent) =
//        getResult { buildingService.checkboxNotification(notificationEvent) }
}