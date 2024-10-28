package edu.itstep.academy.service;

import edu.itstep.academy.entity.Student;
import edu.itstep.academy.entity.Teacher;
import edu.itstep.academy.entity.User;
import edu.itstep.academy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void saveOrUpdate(User user) {
        userRepository.saveOrUpdate(user);
    }

    @Override
    public void registerUser(String username, String password, String role, String firstName, String lastName) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEnabled(true);

        saveOrUpdate(user);

        if ("teacher".equalsIgnoreCase(role)) {
            Teacher teacher = new Teacher();
            teacher.setFirstName(firstName);
            teacher.setLastName(lastName);
            teacher.setUser(user);
            teacherService.saveOrUpdate(teacher);
        } else if ("student".equalsIgnoreCase(role)) {
            Student student = new Student();
            student.setFirstName(firstName);
            student.setLastName(lastName);
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
}
