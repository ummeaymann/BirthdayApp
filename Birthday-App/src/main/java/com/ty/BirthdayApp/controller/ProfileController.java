package com.ty.BirthdayApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.BirthdayApp.dto.Profile;
import com.ty.BirthdayApp.dto.ResponseStructure;
import com.ty.BirthdayApp.dto.User;
import com.ty.BirthdayApp.service.ProfileService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProfileController {
	@Autowired
	ProfileService profileService;

	@PostMapping("/profile")
	public ResponseStructure<Profile> saveProfile(@RequestBody Profile profile) {
		return profileService.saveProfile(profile);
	}

	@GetMapping("/profiles")
	public ResponseStructure<List<Profile>> getAllProfiles() {
		return profileService.getAllProfileData();
	}

	@GetMapping("/profile/{id}")
	public ResponseStructure<Profile> getProfileById(@PathVariable int id) {
		return profileService.getProfileById(id);
	}

	@PutMapping("/profile/{id}")
	public ResponseStructure<Profile> updateProfile(@RequestBody Profile profile, @PathVariable int id) {
		System.out.println(profile);
		return profileService.updateProfile(profile, id);
	}
	
//	@GetMapping("/userprofile/{userid}")
//	public ResponseStructure<Profile> getUserById(@PathVariable int userid) {
//		return profileService.getUserProfileById(userid);
//	}

}
