package utcn.departmentManager.SCD_proiect.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utcn.departmentManager.SCD_proiect.dtos.DepartmentDto;
import utcn.departmentManager.SCD_proiect.exceptions.CrudOperationException;
import utcn.departmentManager.SCD_proiect.models.Department;
import utcn.departmentManager.SCD_proiect.repositories.DepartmentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentDto> getAllDepartments() {

        Iterable<Department> departments = departmentRepository.findAll();
        List<DepartmentDto> departmentDtos = new ArrayList<>();

        departments.forEach(department ->
                departmentDtos.add(DepartmentDto.builder()
                        .id(department.getId())
                        .parentId(department.getParentId())
                        .description(department.getDescription())
                        .build())
        );

        return departmentDtos;
    }

    public DepartmentDto getDepartmentById(Integer id) {

        Department department=departmentRepository.findById(id).orElseThrow(() -> new CrudOperationException("Department does not exist"));

        return DepartmentDto.builder()
                .id(department.getId())
                .parentId(department.getParentId())
                .description(department.getDescription())
                .build();
    }

    public DepartmentDto updateDepartment(Integer id, DepartmentDto departmentDto){
        Department department=departmentRepository.findById(id).orElseThrow(() -> new CrudOperationException("Department does not exist"));
        department.setDescription(departmentDto.getDescription());
        department.setParentId(departmentDto.getParentId());
        departmentRepository.save(department);
        departmentDto.setId(department.getId());
        return departmentDto;
    }

    public DepartmentDto addDepartment(DepartmentDto departmentDto) {
        Department category = Department.builder()
                .id(departmentDto.getId())
                .parentId(departmentDto.getParentId())
                .description(departmentDto.getDescription())
                .build();
        departmentRepository.save(category);
        departmentDto.setId(category.getId());
        return departmentDto;
    }
    public DepartmentDto removeDepartment(Integer id){
        Department department =  departmentRepository.findById(id).orElseThrow(()-> new CrudOperationException("Department does not exist"));
        departmentRepository.deleteById(id);
        return DepartmentDto.builder()
                .id(department.getId())
                .description(department.getDescription())
                .parentId(department.getParentId())
                .build();
    }
}
