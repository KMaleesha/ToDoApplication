package org.myonlinestore.todoapplication.service.Impl;

import org.myonlinestore.todoapplication.model.Role;
import org.myonlinestore.todoapplication.repository.RoleRepository;
import org.myonlinestore.todoapplication.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {
        String roleName = role.getName();
        if (!roleName.equals("ADMIN") && !roleName.equals("USER")) {
            throw new IllegalArgumentException("Invalid role name");
        }
        role.setName(roleName);
        return roleRepository.save(role);
    }

    @Override
    public Optional<Role> getRoleById(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public List<Role> getAllRoles(Role role) {
        return roleRepository.findAll();
    }
}
