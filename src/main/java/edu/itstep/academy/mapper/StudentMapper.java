package edu.itstep.academy.mapper;

import edu.itstep.academy.dto.StudentOutDTO;
import edu.itstep.academy.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentOutDTO toOutDTO(Student student);
}
