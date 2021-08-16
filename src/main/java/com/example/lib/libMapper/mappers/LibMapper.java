package com.example.lib.libMapper.mappers;

import com.example.lib.libMapper.dtos.StudentSlimDto;
import com.example.lib.model.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LibMapper {
    List<StudentSlimDto> studentToStudentSlimDto(List<Student> student);

    List<Student> studentSlimDtoToStudent(List<StudentSlimDto> student);

    Student studentSlimDtoToStudent1(StudentSlimDto student);
}
