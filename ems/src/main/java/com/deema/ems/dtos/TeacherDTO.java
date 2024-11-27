package com.deema.ems.dtos;


import com.deema.ems.entities.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeacherDTO {
    private Long id;
    private String username;
    private String subjectSpecialization;
    private List<Subject> subjects;
}

