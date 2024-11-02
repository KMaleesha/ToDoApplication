package org.myonlinestore.todoapplication.controller;

import jakarta.validation.Valid;
import org.myonlinestore.todoapplication.model.Role;
import org.myonlinestore.todoapplication.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/role")
@Validated
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/save")
    public Role save(@Valid @RequestBody Role role) {
        return roleService.saveRole(role);
    }

    @GetMapping(value = "/get/{id}")
    public Optional<Role> getRole(@PathVariable int id) {
        return roleService.getRoleById(id);
    }

    @GetMapping(value = "/get/all")
    public List<Role> getAllRoles(Role role) {
        return roleService.getAllRoles(role);
    }
}
