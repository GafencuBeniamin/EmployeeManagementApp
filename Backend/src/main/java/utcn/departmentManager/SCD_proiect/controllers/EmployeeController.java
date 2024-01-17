package utcn.departmentManager.SCD_proiect.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utcn.departmentManager.SCD_proiect.dtos.EmployeeDto;
import utcn.departmentManager.SCD_proiect.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Integer id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }
    @GetMapping("department/{id}")
    public ResponseEntity<List<EmployeeDto>> getAllEmployeesPerDepartment(@PathVariable Integer id) {
        return ResponseEntity.ok(employeeService.getAllEmployeesPerDepartment(id));
    }
    @GetMapping("managers/department/{id}")
    public ResponseEntity<List<EmployeeDto>> getAllManagersPerDepartment(@PathVariable Integer id) {
        return ResponseEntity.ok(employeeService.getAllManagersPerDepartment(id));
    }
    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.addEmployee(employeeDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employeeDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDto> removeEmployee(@PathVariable Integer id) {
        return ResponseEntity.ok(employeeService.removeEmployee(id));
    }

}
