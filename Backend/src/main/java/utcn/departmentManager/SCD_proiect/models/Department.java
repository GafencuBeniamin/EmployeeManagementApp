package utcn.departmentManager.SCD_proiect.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String description;
    private Integer parentId;

    @OneToMany(mappedBy = "departmentId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Employee> employees;

    @Override
    public String toString() {
        return "Department {department id=" + id + ", parentId='" + parentId + "', description='" + description + "'}";
    }

    public Integer getDepartmentId(){
        return id;
    }
}
