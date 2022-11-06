package com.ty.BirthdayApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.BirthdayApp.dto.Profile;
import com.ty.BirthdayApp.dto.User;
import com.ty.BirthdayApp.repository.ProfileRepository;

@Repository
public class ProfileDao {

	private static final Optional<Profile> Profile = null;
	@Autowired
	ProfileRepository profileRepository;

	public Profile saveProfile(Profile profile) {
		return profileRepository.save(profile);
	}

	public List<Profile> getAllProfiles() {
		return profileRepository.findAll();
	}

	public Profile getProfileById(int id) {
		Optional<Profile> optional = profileRepository.findById(id);

		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	public Profile updateProfile(Profile profile) {
		return profileRepository.save(profile);
	}
	
//	public Profile getUserProfileById(int id) {
//		Profile optional = profileRepository.findByUserId(id);
//
//			return optional;
//	}

}
