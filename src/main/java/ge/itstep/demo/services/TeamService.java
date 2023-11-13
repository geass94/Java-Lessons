package ge.itstep.demo.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ge.itstep.demo.models.Student;
import ge.itstep.demo.repositories.StudentRepository;

@Service
public class TeamService {
    @Autowired
    private StudentRepository studentRepository;

    public List<List<Student>> createTeams() {
        List<Student> allStudents = studentRepository.findAll();

        int teamCount = allStudents.size() / 3;
        List<List<Student>> teams = new ArrayList<>();

        double maxPowerDifference = 2.0;
        double currentMaxDifference = 0.0;

        while (currentMaxDifference <= maxPowerDifference) {
            teams.clear();

            for (int i = 0; i < teamCount; i++) {
                List<Student> team = new ArrayList<>();
                team.add(allStudents.get(i * 3));
                team.add(allStudents.get(i * 3 + 1));
                team.add(allStudents.get(i * 3 + 2));
                teams.add(team);
            }

            // Check if teams have a power difference within the limit
            if (isTeamsPowerDifferenceValid(teams, currentMaxDifference)) {
                return teams;
            }
            // Shuffle the students to ensure randomness in team assignment
            Collections.shuffle(allStudents);
            currentMaxDifference += 0.1;
        }

        return teams; // This will contain teams with the maximum allowed power difference
    }

    private boolean isTeamsPowerDifferenceValid(List<List<Student>> teams, double maxDifference) {
        for (List<Student> team : teams) {
            double teamPower = calculateTeamPower(team);
            for (List<Student> otherTeam : teams) {
                if (team != otherTeam) {
                    double otherTeamPower = calculateTeamPower(otherTeam);
                    if (Math.abs(teamPower - otherTeamPower) > maxDifference) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private double calculateTeamPower(List<Student> team) {
        double totalPower = 0;
        for (Student student : team) {
            totalPower += student.getPower();
        }
        return totalPower / team.size();
    }
}
