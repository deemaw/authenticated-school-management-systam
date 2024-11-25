package com.deema.ems.services;

import com.deema.ems.entities.Role;
import com.deema.ems.repositories.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    @Transactional
    public Role add(Role role) {
        return roleRepository.save(role);
    }
}
