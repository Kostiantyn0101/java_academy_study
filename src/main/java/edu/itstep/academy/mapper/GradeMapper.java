package edu.itstep.academy.mapper;

import edu.itstep.academy.dto.GradeInDTO;
import edu.itstep.academy.dto.GradeOutDTO;
import edu.itstep.academy.entity.Grade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GradeMapper {

    GradeOutDTO toOutDTO(Grade grade);

    @Mapping(source = "studentId", target = "student.id")
    @Mapping(source = "subjectId", target = "subject.id")
    @Mapping(source = "teacherId", target = "teacher.id")
    Grade toEntity(GradeInDTO gradeInDTO);
}


