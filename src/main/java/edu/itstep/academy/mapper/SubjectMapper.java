package edu.itstep.academy.mapper;

import edu.itstep.academy.dto.SubjectOutDTO;
import edu.itstep.academy.entity.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    SubjectOutDTO toOutDTO(Subject subject);
}
