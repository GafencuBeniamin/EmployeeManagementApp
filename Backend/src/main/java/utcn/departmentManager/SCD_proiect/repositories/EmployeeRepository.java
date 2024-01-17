package utcn.departmentManager.SCD_proiect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import utcn.departmentManager.SCD_proiect.models.Department;
import utcn.departmentManager.SCD_proiect.models.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByDepartmentId_Id(Integer departmentId);
    @Query("SELECT e.managerId FROM Employee e WHERE e.managerId IS NOT NULL")
    List<Integer> findManagerIds();

    List<Employee> findAllByDepartmentId_IdAndIdIn(Integer departmentId, List<Integer> managerIds);
}
