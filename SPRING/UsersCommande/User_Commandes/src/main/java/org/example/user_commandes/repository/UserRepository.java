package org.example.user_commandes.repository;

import org.example.user_commandes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
