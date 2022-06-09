package com.amazon.repository;

import com.amazon.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface IUserRepository extends JpaRepository<User, UUID> {
}
