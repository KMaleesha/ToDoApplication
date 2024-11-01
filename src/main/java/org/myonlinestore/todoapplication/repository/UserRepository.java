package org.myonlinestore.todoapplication.repository;

import org.myonlinestore.todoapplication.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    public Optional<UserEntity> findByUsername(String username);
    public Optional<UserEntity> findByEmail(String email);
    public Boolean existsByEmail(String email);
    public Boolean existsByUsername(String username);
}
