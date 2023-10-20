package ge.itstep.demo.dto;

import jakarta.validation.constraints.NotEmpty;

public record UpdatePasswordRequest(@NotEmpty
                                           String password,
                                    @NotEmpty
                                           String confirmPassword) {

}
