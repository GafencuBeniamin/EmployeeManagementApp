package utcn.departmentManager.SCD_proiect.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utcn.departmentManager.SCD_proiect.dtos.DepartmentDto;
import utcn.departmentManager.SCD_proiect.services.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Integer id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto) {
        return ResponseEntity.ok(departmentService.addDepartment(departmentDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable Integer id, @RequestBody DepartmentDto departmentDto) {
        return ResponseEntity.ok(departmentService.updateDepartment(id, departmentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DepartmentDto> removeDepartment(@PathVariable Integer id) {
        return ResponseEntity.ok(departmentService.removeDepartment(id));
    }
}
