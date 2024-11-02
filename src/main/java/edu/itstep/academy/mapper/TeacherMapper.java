package edu.itstep.academy.mapper;

import edu.itstep.academy.dto.TeacherOutDTO;
import edu.itstep.academy.entity.Teacher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherOutDTO toOutDTO(Teacher teacher);
}
