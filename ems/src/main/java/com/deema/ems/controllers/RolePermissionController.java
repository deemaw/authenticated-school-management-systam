package com.deema.ems.controllers;

import com.deema.ems.entities.Role;
import com.deema.ems.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/role")
@RestController
public class RolePermissionController {
@Autowired
private RoleService roleService;
    @PostMapping()
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        Role rolepermission = roleService.add(role);

        return ResponseEntity.ok(rolepermission);
    }
}
