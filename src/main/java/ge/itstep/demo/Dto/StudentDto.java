package ge.itstep.demo.Dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    @Getter
    @Setter
    private Long id;
    @NotNull
    @Getter
    @Setter
    private String fullName;
    @NotNull
    @Getter
    @Setter
    private int power;
}
