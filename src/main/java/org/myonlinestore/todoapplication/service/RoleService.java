package org.myonlinestore.todoapplication.service;

import org.myonlinestore.todoapplication.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RoleService {

    public Role saveRole(Role role);

    public Optional<Role> getRoleById(int id);

    public List<Role> getAllRoles(Role role);
}