package ge.itstep.demo.service;

import ge.itstep.demo.dto.UserDTO;
import ge.itstep.demo.model.User;

public interface UserService {

    void saveUser(UserDTO dto);

    User findUserByEmail(String email);


}
