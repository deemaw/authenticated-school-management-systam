package com.deema.ems.entities;

import com.deema.ems.dtos.RegistrationType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class Registration {
    @Enumerated(EnumType.ORDINAL)
    private RegistrationType registrationType;
    private LocalDateTime registrationDate;
    private String description;
}
