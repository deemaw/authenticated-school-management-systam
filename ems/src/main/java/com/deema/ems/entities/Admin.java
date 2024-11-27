package com.deema.ems.entities;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@JsonTypeName("admin")
public class Admin extends User {
    public Admin() {
        super();
    }
}
