package com.sit.swprocess.DogeCommerce.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
    public Optional<User> getOneByEmail(String email);
}
