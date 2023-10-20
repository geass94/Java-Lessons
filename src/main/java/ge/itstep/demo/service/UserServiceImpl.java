package ge.itstep.demo.service;

import ge.itstep.demo.dto.UserDTO;
import ge.itstep.demo.model.Role;
import ge.itstep.demo.model.User;
import ge.itstep.demo.repository.RoleRepository;
import ge.itstep.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(UserDTO dto) {
        Role role = roleRepository.findRoleByName("ROLE_USER");
        if (role == null) {
            role = roleRepository.save(new Role("ROLE_USER"));
        }
        String hashedPassword = passwordEncoder.encode(dto.getPassword());

        User user = new User(dto.getName(), dto.getEmail(), hashedPassword);
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
