package dev.synchrony.user.user.repository;

import dev.synchrony.user.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);  // Custom query to find users by username
    Optional<User> findByPhoneNumber(String phoneNumber);
}