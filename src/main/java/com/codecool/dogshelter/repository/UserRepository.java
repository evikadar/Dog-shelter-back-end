package com.codecool.dogshelter.repository;

import com.codecool.dogshelter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
