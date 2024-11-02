package edu.itstep.academy.service;

import edu.itstep.academy.dto.*;
import edu.itstep.academy.entity.*;
import edu.itstep.academy.exeption.GradeNotFoundException;
import edu.itstep.academy.mapper.*;
import edu.itstep.academy.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeMapper gradeMapper;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    SubjectMapper subjectMapper;

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    public StudentService studentService;

    @Autowired
    public SubjectService subjectService;

    @Autowired
    public TeacherService teacherService;

    @Autowired
    public UserService userService;

    @Override
    public List<Grade> getAll() {
        return gradeRepository.getAll();
    }

    @Override
    public void add(Grade grade) {
        gradeRepository.saveOrUpdate(grade);
    }

    @Override
    public Grade getById(Long id) {
        return gradeRepository
                .getById(id);
    }

    @Override
    public List<Grade> getGradesByStudentId(Long studentId,
                                            int page, int pageSize) {
        return gradeRepository.getByStudentId(studentId, page, pageSize);
    }

    @Override
    public List<Grade> getGradesByStudentIdAndSubjectId(Long studentId, Long subjectId,
                                                        int page, int pageSize) {
        return gradeRepository.getByStudentIdAndSubjectId(studentId, subjectId, page, pageSize);
    }

    @Override
    public List<Grade> getGradesByStudentIdAndDate(Long studentId, LocalDate date,
                                                   int page, int pageSize) {
        return gradeRepository.getByStudentIdAndDate(studentId, date, page, pageSize);
    }

    @Override
    public List<Grade> getGradesByStudentIdAndSubjectIdAndDate(Long studentId, Long subjectId, LocalDate date,
                                                               int page, int pageSize) {
        return gradeRepository.getByStudentIdAndSubjectIdAndDate(studentId, subjectId, date, page, pageSize);
    }

    @Override
    public List<Grade> getGradesByTeacherId(Long teacherId,
                                            int page, int pageSize) {
        return gradeRepository.getByTeacherId(teacherId, page, pageSize);
    }

    @Override
    public List<Grade> getGradesByTeacherIdAndSubjectId(Long teacherId, Long subjectId,
                                                        int page, int pageSize) {
        return gradeRepository.getByTeacherIdAndSubjectId(teacherId, subjectId, page, pageSize);
    }

    @Override
    public List<Grade> getGradesByTeacherIdAndDate(Long teacherId, LocalDate date,
                                                   int page, int pageSize) {
        return gradeRepository.getByTeacherIdAndDate(teacherId, date, page, pageSize);
    }

    @Override
    public List<Grade> getGradesByTeacherIdAndSubjectIdAndDate(Long teacherId, Long subjectId, LocalDate date,
                                                               int page, int pageSize) {
        return gradeRepository.getByTeacherIdAndSubjectIdAndDate(teacherId, subjectId, date, page, pageSize);
    }

    @Override
    public void update(Grade grade) {
        gradeRepository.saveOrUpdate(grade);
    }

    @Override
    public void deleteById(Long gradeId) {
        gradeRepository.deleteById(gradeId);
    }

    @Override
    public void saveGradeDTO(GradeInDTO gradeInDTO) {
        Grade grade = gradeMapper.toEntity(gradeInDTO);
        grade.setStudent(studentService.getById(gradeInDTO.getStudentId()));
        grade.setSubject(subjectService.getById(gradeInDTO.getSubjectId()));
        grade.setTeacher(teacherService.getById(gradeInDTO.getTeacherId()));
        gradeRepository.saveOrUpdate(grade);
    }

    @Override
    public void prepareGradePage(Model model, GradeOutDTO gradeOutDTO, Long subjectId, String dateStr,
                                 int page, int pageSize) {
        List<Student> students = studentService.getAll();
        List<StudentOutDTO> studentOutDTOS = students
                .stream()
                .map(studentMapper::toOutDTO)
                .toList();

        List<Subject> subjects = subjectService.getAll();
        List<SubjectOutDTO> subjectOutDTOS = subjects
                .stream()
                .map(subjectMapper::toOutDTO)
                .toList();

        User user = userService.getCurrentUser();
        Teacher teacher = teacherService.getByUserNameId(user.getId());

        if (teacher != null) {
            TeacherOutDTO teacherOutDTO = teacherMapper.toOutDTO(teacher);
            List<GradeOutDTO> grades = getGradesByTeacherIdAndFilters(subjectId, dateStr, teacher.getId(), page, pageSize)
                    .stream()
                    .map(gradeMapper::toOutDTO)
                    .toList();
            prepareGradeModel(model, grades, studentOutDTOS, subjectOutDTOS, teacherOutDTO, gradeOutDTO, dateStr, null, page, pageSize);
        } else {
            Student student = studentService.getByUserNameId(user.getId());
            StudentOutDTO studentOutDTO = studentMapper.toOutDTO(student);
            List<GradeOutDTO> grades = getGradesByStudentIdAndFilters(subjectId, dateStr, student.getId(), page, pageSize)
                    .stream()
                    .map(gradeMapper::toOutDTO)
                    .toList();

            prepareGradeModel(model, grades, studentOutDTOS, subjectOutDTOS, null, gradeOutDTO, dateStr,
                    studentOutDTO, page, pageSize);
        }
    }

    @Override
    public void prepareGradeModel(Model model, List<GradeOutDTO> grades, List<StudentOutDTO> students,
                                  List<SubjectOutDTO> subjects, TeacherOutDTO teacher, GradeOutDTO gradeOutDTO,
                                  String dateStr, StudentOutDTO student, int page, int pageSize) {

        model.addAttribute("grades", grades);
        model.addAttribute("students", students);
        model.addAttribute("subjects", subjects);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", pageSize);
        if (teacher != null) {
            model.addAttribute("teacher", teacher);
        } else {
            model.addAttribute("student", student);
        }
        model.addAttribute("gradeOutDTO", gradeOutDTO);
        if (dateStr != null && !dateStr.isEmpty()) {
            model.addAttribute("dateStr", dateStr);
        }
    }

    public void prepareValidPage(GradeInDTO gradeInDTO, Model model) {
        List<Student> students = studentService.getAll();
        List<StudentOutDTO> studentOutDTOS = students
                .stream()
                .map(studentMapper::toOutDTO)
                .toList();

        List<Subject> subjects = subjectService.getAll();
        List<SubjectOutDTO> subjectOutDTOS = subjects
                .stream()
                .map(subjectMapper::toOutDTO)
                .toList();

        Teacher teacher = teacherService.getById(gradeInDTO.getTeacherId());

        model.addAttribute("students", studentOutDTOS);
        model.addAttribute("subjects", subjectOutDTOS);
        model.addAttribute("gradeInDTO", gradeInDTO);
        model.addAttribute("teacher", teacher);
    }


    @Override
    public void prepareEditPage(Model model, Long gradeId) {
        Grade grade = getById(gradeId);
        if (grade == null)
        {
            throw new GradeNotFoundException(gradeId);
        }
        GradeOutDTO gradeOutDTO = gradeMapper.toOutDTO(grade);
        prepareGradePage(model, gradeOutDTO, null, null, 0, 0);
    }

    @Override
    public List<Grade> getGradesByTeacherIdAndFilters(Long subjectId, String dateStr, Long teacherId,
                                                      int page, int pageSize) {
        LocalDate date = null;
        if (dateStr != null && !dateStr.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            date = LocalDate.parse(dateStr, formatter);
        }

        if (subjectId != null && date != null) {
            return getGradesByTeacherIdAndSubjectIdAndDate(teacherId, subjectId, date, page, pageSize);
        } else if (subjectId != null) {
            return getGradesByTeacherIdAndSubjectId(teacherId, subjectId, page, pageSize);
        } else if (date != null) {
            return getGradesByTeacherIdAndDate(teacherId, date, page, pageSize);
        } else {
            return getGradesByTeacherId(teacherId, page, pageSize);
        }
    }

    @Override
    public List<Grade> getGradesByStudentIdAndFilters(Long subjectId, String dateStr, Long studentId,
                                                      int page, int pageSize) {
        LocalDate date = null;
        if (dateStr != null && !dateStr.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            date = LocalDate.parse(dateStr, formatter);
        }

        if (subjectId != null && date != null) {
            return getGradesByStudentIdAndSubjectIdAndDate(studentId, subjectId, date, page, pageSize);
        } else if (subjectId != null) {
            return getGradesByStudentIdAndSubjectId(studentId, subjectId, page, pageSize);
        } else if (date != null) {
            return getGradesByStudentIdAndDate(studentId, date, page, pageSize);
        } else {
            return getGradesByStudentId(studentId, page, pageSize);
        }
    }


}
