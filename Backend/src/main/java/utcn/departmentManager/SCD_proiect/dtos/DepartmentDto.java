package utcn.departmentManager.SCD_proiect.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class DepartmentDto {
    private Integer id;
    private String description;
    private Integer parentId;
}
