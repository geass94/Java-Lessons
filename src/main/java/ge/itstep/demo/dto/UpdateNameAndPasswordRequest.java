package ge.itstep.demo.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UpdateNameAndPasswordRequest {
    private String name;
    private String password;
    private String confirmPassword;
}
