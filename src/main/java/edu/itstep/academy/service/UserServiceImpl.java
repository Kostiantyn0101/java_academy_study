package edu.itstep.academy.service;

import edu.itstep.academy.dto.UserOutDTO;
import edu.itstep.academy.dto.UserRegistrationInDTO;
import edu.itstep.academy.entity.*;
import edu.itstep.academy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private RoleNameService roleNameService;
    @Autowired
    private RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void saveOrUpdate(User user) {
        userRepository.saveOrUpdate(user);
    }

    @Override
    public List<User> getAll(){
        return userRepository.getAll();
    }
    @Override
    public void registerUser(UserRegistrationInDTO userRegistrationInDTO) {
        User user = new User();
        user.setUsername(userRegistrationInDTO.getUserName());
        user.setPassword(passwordEncoder.encode(userRegistrationInDTO.getPassword()));
        user.setEnabled(true);
        saveOrUpdate(user);

        RoleName roleName = roleNameService.getRoleNameById(userRegistrationInDTO.getRoleId());

        RoleRoleNameId roleRoleNameId = new RoleRoleNameId();
        roleRoleNameId.setUserId(user.getId());
        roleRoleNameId.setRoleId(userRegistrationInDTO.getRoleId());

        Role roleEntity = new Role();
        roleEntity.setId(roleRoleNameId);
        roleEntity.setUser(user);
        roleEntity.setRoleName(roleName);
        roleService.saveOrUpdate(roleEntity);


        if ("role_teacher".equalsIgnoreCase(roleName.getName())) {
            Teacher teacher = new Teacher();
            teacher.setFirstName(userRegistrationInDTO.getFirstName());
            teacher.setLastName(userRegistrationInDTO.getLastName());
            teacher.setUser(user);
            teacherService.saveOrUpdate(teacher);
        } else if ("role_student".equalsIgnoreCase(roleName.getName())) {
            Student student = new Student();
            student.setFirstName(userRegistrationInDTO.getFirstName());
            student.setLastName(userRegistrationInDTO.getLastName());
            student.setUser(user);
            studentService.saveOrUpdate(student);
        }
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = null;

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            username = userDetails.getUsername();
        }
        return userRepository.getUserByUsername(username);
    }

    @Override
    public void prepareRegisterPage(Model model, UserRegistrationInDTO userRegistrationInDTO, int page, int pageSize) {
        List<User> users = getAll();

        List<UserOutDTO> userDTOs = users.stream()
                .map(this::convertToUserOutDTO).toList();

        model.addAttribute("userRegistrationInDTO", userRegistrationInDTO);
        model.addAttribute("userDTOs", userDTOs);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
    }

    private UserOutDTO convertToUserOutDTO(User user) {
        UserOutDTO dto = new UserOutDTO();
        dto.setUserId(user.getId());
        dto.setUserName(user.getUsername());

        List<Role> roles = roleService.getByUserId(user.getId());
        List<RoleName> roleNames = new ArrayList<>();
        for (Role role : roles) {
            roleNames.add(role.getRoleName());
        }
        dto.setRoles(roleNames);

        if (user.getTeacher() != null) {
            dto.setFirstName(user.getTeacher().getFirstName());
            dto.setLastName(user.getTeacher().getLastName());
        } else if (user.getStudent() != null) {
            dto.setFirstName(user.getStudent().getFirstName());
            dto.setLastName(user.getStudent().getLastName());
        }
        return dto;
    }

}
