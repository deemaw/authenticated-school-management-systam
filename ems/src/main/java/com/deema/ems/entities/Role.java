package com.deema.ems.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Collection<Permissions> privileges = new ArrayList<>();
}
