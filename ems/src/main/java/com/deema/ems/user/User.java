package com.deema.ems.user;

import com.deema.ems.admin.Admin;
import com.deema.ems.student.Student;
import com.deema.ems.teacher.Teacher;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@JsonDeserialize
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Admin.class, name = "admin"),
        @JsonSubTypes.Type(value = Teacher.class, name = "teacher"),
        @JsonSubTypes.Type(value = Student.class, name = "student")
})
public abstract class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .toList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Update logic if needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Update logic if needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Update logic if needed
    }

    @Override
    public boolean isEnabled() {
        return true; // Update logic if needed
    }
}
