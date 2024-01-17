package utcn.departmentManager.SCD_proiect.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class EmployeeDto {
    private Integer id;
    private String name;
    private Integer departmentId;
    private Integer managerId;
    private String email;
}