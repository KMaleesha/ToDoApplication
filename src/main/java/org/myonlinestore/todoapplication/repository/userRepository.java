package org.myonlinestore.todoapplication.repository;

import org.myonlinestore.todoapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User, Integer> {
}
