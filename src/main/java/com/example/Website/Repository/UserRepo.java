package com.example.Website.Repository;

import com.example.Website.Database.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserDetails,Long> {
    Optional<UserDetails> findByEmailAndPassword(String email,String password);
    Optional<UserDetails> findByPhoneNumberAndPassword(Long phNo,String password);
}
