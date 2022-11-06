package com.ty.BirthdayApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.ty.BirthdayApp.dao.ProfileDao;
import com.ty.BirthdayApp.dto.Profile;
import com.ty.BirthdayApp.dto.ResponseStructure;
import com.ty.BirthdayApp.dto.User;

@Service
public class ProfileService {
	@Autowired
	ProfileDao profileDao;

	public ResponseStructure<Profile> saveProfile(Profile profile) {
		ResponseStructure<Profile> responseStructure = new ResponseStructure<Profile>();

		Profile profile1 = profileDao.saveProfile(profile);

		if (profile1 != null) {

			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMsg("Data added into db successfully");
			responseStructure.setData(profile1);
		}

		return responseStructure;
	}

	public ResponseStructure<List<Profile>> getAllProfileData() {

		ResponseStructure<List<Profile>> responseStructure = new ResponseStructure<List<Profile>>();

		List<Profile> profileList = profileDao.getAllProfiles();

		if (profileList.isEmpty()) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("No data present in the db");
			responseStructure.setData(null);
		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Profile Details");
			responseStructure.setData(profileList);
		}
		return responseStructure;
	}

	public ResponseStructure<Profile> getProfileById(int id) {

		ResponseStructure<Profile> responseStructure = new ResponseStructure<Profile>();

		Profile profile = profileDao.getProfileById(id);

		if (profile != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Profiles Details Obtained");
			responseStructure.setData(profile);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Profile Details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;
	}

	public ResponseStructure<Profile> updateProfile(Profile profile, int id) {

		ResponseStructure<Profile> responseStructure = new ResponseStructure<Profile>();

		Profile p1 = profileDao.getProfileById(id);

		if (p1 == null) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Profile data missing");
			responseStructure.setData(null);

		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Profile is present");
			responseStructure.setData(profileDao.updateProfile(profile));

		}
		return responseStructure;

	}
	
//	public ResponseStructure<Profile> getUserProfileById(int id) {
//
//		ResponseStructure<Profile> responseStructure = new ResponseStructure<Profile>();
//
//		Profile profile = profileDao.getUserProfileById(id);
//
//		if (profile != null) {
//			responseStructure.setStatusCode(HttpStatus.FOUND.value());
//			responseStructure.setMsg("Profiles Details Obtained");
//			responseStructure.setData(profile);
//		} else {
//			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
//			responseStructure.setMsg("Profile Details Not Found");
//			responseStructure.setData(null);
//		}
//		return responseStructure;
//	}

}
