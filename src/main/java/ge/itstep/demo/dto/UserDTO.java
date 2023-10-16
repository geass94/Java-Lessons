package ge.itstep.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @Getter
    @Setter
    private Long id;
    @NotEmpty(message = "Oe")
    @Getter
    @Setter
    private String name;
    @NotEmpty(message = "Oe")
    @Email
    @Getter
    @Setter
    private String email;
    @NotEmpty(message = "Oe")
    @Getter
    @Setter
    private String password;
}
