package com.ty.BirthdayApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.BirthdayApp.dto.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	
//	public Profile findByUserId(int id);

}
