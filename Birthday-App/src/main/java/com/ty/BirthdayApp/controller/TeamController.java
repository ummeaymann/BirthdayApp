package com.ty.BirthdayApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.BirthdayApp.dto.ResponseStructure;
import com.ty.BirthdayApp.dto.Team;
import com.ty.BirthdayApp.dto.User;
import com.ty.BirthdayApp.service.TeamService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TeamController {
	@Autowired
	TeamService teamService;

	@PostMapping("/teams")
	public ResponseStructure<Team> saveTeam(@RequestBody Team team) {
		return teamService.saveTeam(team);
	}

	@GetMapping("/teams")
	public ResponseStructure<List<Team>> getAllTeams() {
		return teamService.getAllTeamData();
	}

	@GetMapping("/teams/{id}")
	public ResponseStructure<Team> getTeamById(@PathVariable int id) {
		return teamService.getTeamById(id);
	}
	@PutMapping("/teams/{id}")
	public ResponseStructure<Team> updateTeam(@RequestBody Team team,@PathVariable int id) {
		return teamService.updateTeam(team,id);
	}
	

	@DeleteMapping("/teams/{id}")
	public ResponseStructure<String> deleteUser(@PathVariable int id) {
		return teamService.deleteUser(id);

	}

}
