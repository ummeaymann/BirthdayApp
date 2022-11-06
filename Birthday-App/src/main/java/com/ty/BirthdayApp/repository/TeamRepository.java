package com.ty.BirthdayApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.BirthdayApp.dto.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}
