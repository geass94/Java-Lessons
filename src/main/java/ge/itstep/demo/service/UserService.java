package ge.itstep.demo.service;

import ge.itstep.demo.dto.UpdatePasswordRequest;
import ge.itstep.demo.dto.UserDTO;
import ge.itstep.demo.model.User;

public interface UserService {

    void saveUser(UserDTO userDto);

    User findUserByEmail(String email);

    User updatePassword(UpdatePasswordRequest request, String email);


}
