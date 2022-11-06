package com.ty.BirthdayApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.BirthdayApp.dto.Team;
import com.ty.BirthdayApp.repository.TeamRepository;

@Repository
public class TeamDao {

	private static final Optional<Team> Team = null;
	@Autowired
	TeamRepository teamRepository;

	public Team saveTeam(Team team) {
		return teamRepository.save(team);
	}

	public List<Team> getAllTeams() {
		return teamRepository.findAll();
	}

	public Team getTeamById(int id) {
		Optional<Team> optional = teamRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}
	public Team updateTeam(Team team, int id) {
		team.setId(id);
		return teamRepository.save(team);
	}

	public String deleteTeam(int id) {
		Optional<Team> optional = teamRepository.findById(id);

		if (optional.isPresent()) {
			teamRepository.delete(optional.get());
			return "Person data has been deleted successfully";
		} else {
			return "Person with this ID doesn't exist";
		}
	}

}
