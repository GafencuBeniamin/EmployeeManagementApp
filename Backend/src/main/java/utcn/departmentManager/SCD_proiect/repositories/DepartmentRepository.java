package utcn.departmentManager.SCD_proiect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utcn.departmentManager.SCD_proiect.models.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
