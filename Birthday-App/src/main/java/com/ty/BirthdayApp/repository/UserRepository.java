package com.ty.BirthdayApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.BirthdayApp.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

     User findByEmailAndPassword(String email, String password);
     
     List <User> findByRole(String role);

}
