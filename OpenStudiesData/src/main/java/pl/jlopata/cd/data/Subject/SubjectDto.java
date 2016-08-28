package pl.jlopata.cd.data.Subject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDto implements Serializable {

    private static final long serialVersionUID = -8458323828519822691L;

    private Long id;

    private Long departmentId;
    private String name;
    private String description;
}
