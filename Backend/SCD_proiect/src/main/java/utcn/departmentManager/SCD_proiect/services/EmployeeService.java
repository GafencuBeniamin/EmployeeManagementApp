package utcn.departmentManager.SCD_proiect.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utcn.departmentManager.SCD_proiect.dtos.EmployeeDto;
import utcn.departmentManager.SCD_proiect.exceptions.CrudOperationException;
import utcn.departmentManager.SCD_proiect.models.Department;
import utcn.departmentManager.SCD_proiect.models.Employee;
import utcn.departmentManager.SCD_proiect.repositories.DepartmentRepository;
import utcn.departmentManager.SCD_proiect.repositories.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;
    @Autowired
    private final DepartmentRepository departmentRepository;

    public List<EmployeeDto> getAllEmployees() {
        Iterable<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> results = new ArrayList<>();

        employees.forEach(result -> results.add(EmployeeDto.builder()
                .id(result.getId())
                .name(result.getName())
                .departmentId(result.getDepartmentId().getId())
                .managerId(result.getManagerId())
                .email(result.getEmail())
                .build()));

        return results;
    }
    public List<EmployeeDto> getAllEmployeesPerDepartment(Integer id) {
        Iterable<Employee> employees = employeeRepository.findAllByDepartmentId_Id(id);
        List<EmployeeDto> results = new ArrayList<>();

        employees.forEach(result -> results.add(EmployeeDto.builder()
                .id(result.getId())
                .name(result.getName())
                .departmentId(result.getDepartmentId().getId())
                .managerId(result.getManagerId())
                .email(result.getEmail())
                .build()));

        return results;
    }
    public List<EmployeeDto> getAllManagersPerDepartment(Integer id) {
        List<Employee> managers = employeeRepository.findAllByDepartmentId_IdAndIdIn(id, employeeRepository.findManagerIds());
        List<EmployeeDto> results = new ArrayList<>();

        managers.forEach(result -> results.add(EmployeeDto.builder()
                .id(result.getId())
                .name(result.getName())
                .departmentId(result.getDepartmentId().getId())
                .managerId(result.getManagerId())
                .email(result.getEmail())
                .build()));

        return results;
    }
    public EmployeeDto getEmployeeById(Integer id) {

        Employee employee=employeeRepository.findById(id).orElseThrow(() -> new CrudOperationException("Employee does not exist"));

        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .departmentId(employee.getDepartmentId().getId())
                .managerId(employee.getManagerId())
                .email(employee.getEmail())
                .build();
    }

    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Department department = departmentRepository.findById(employeeDto.getDepartmentId()).orElseThrow(()-> new CrudOperationException("Department does not exist"));
        Employee product = Employee.builder()
                .id(employeeDto.getId())
                .name(employeeDto.getName())
                .departmentId(department)
                .managerId(employeeDto.getManagerId())
                .email(employeeDto.getEmail())
                .build();
        employeeRepository.save(product);
        employeeDto.setId(product.getId());
        return employeeDto;
    }

    public EmployeeDto removeEmployee(Integer id){
        Employee employee =  employeeRepository.findById(id).orElseThrow(()->{
            throw new CrudOperationException("Employee does not exist");
        });
        employeeRepository.deleteById(id);
        return EmployeeDto.builder()
                .id(employee.getId())
                .departmentId(employee.getDepartmentId().getId())
                .managerId(employee.getManagerId())
                .name(employee.getName())
                .email(employee.getEmail())
                .build();
    }
    public EmployeeDto updateEmployee(Integer id, EmployeeDto employeeDto){
        Employee employee=employeeRepository.findById(id).orElseThrow(() -> new CrudOperationException("Employee does not exist"));
        Department department = departmentRepository.findById(employeeDto.getDepartmentId()).orElseThrow(()-> new CrudOperationException("Category does not exist"));
        employee.setEmail(employeeDto.getEmail());
        employee.setName(employeeDto.getName());
        employee.setManagerId(employeeDto.getManagerId());
        employee.setDepartmentId(department);
        employeeRepository.save(employee);
        employeeDto.setId(employee.getId());
        return employeeDto;
    }

}
