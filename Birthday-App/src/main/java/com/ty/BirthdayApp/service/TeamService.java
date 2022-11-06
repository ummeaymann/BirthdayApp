package com.ty.BirthdayApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.BirthdayApp.dao.TeamDao;
import com.ty.BirthdayApp.dto.ResponseStructure;
import com.ty.BirthdayApp.dto.Team;
import com.ty.BirthdayApp.dto.User;

@Service
public class TeamService {
	@Autowired
	TeamDao teamDao;

	public ResponseStructure<Team> saveTeam(Team team) {
		ResponseStructure<Team> responseStructure = new ResponseStructure<Team>();

		Team team1 = teamDao.saveTeam(team);

		if (team1 != null) {

			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMsg("Data added into db successfully");
			responseStructure.setData(team1);
		}

		return responseStructure;

	}

	public ResponseStructure<List<Team>> getAllTeamData() {

		ResponseStructure<List<Team>> responseStructure = new ResponseStructure<List<Team>>();

		List<Team> teamList = teamDao.getAllTeams();

		if (teamList.isEmpty()) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("No data present in the db");
			responseStructure.setData(null);
		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Team Details");
			responseStructure.setData(teamList);
		}
		return responseStructure;
	}

	public ResponseStructure<Team> getTeamById(int id) {

		ResponseStructure<Team> responseStructure = new ResponseStructure<Team>();

		Team team = teamDao.getTeamById(id);

		if (team != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("User Details Obtained");
			responseStructure.setData(team);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Team Details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;
	}
	public ResponseStructure<Team> updateTeam(Team team,int id) {
		
		ResponseStructure<Team> responseStructure = new ResponseStructure<Team>();
		
		Team t1 = teamDao.getTeamById(id);
//		team.setPassword(t1.getPassword());
		
		if (t1 == null) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Team data missing");
			responseStructure.setData(null);

		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Team is present");
			responseStructure.setData(teamDao.updateTeam(team,id));

		}
		return responseStructure;

	}
	

	public ResponseStructure<String> deleteUser(int id) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();

		Team team = teamDao.getTeamById(id);

		if (team != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Team Details Deleted Successfully");
			responseStructure.setData(teamDao.deleteTeam(id));
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Team Details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;

	}

}
