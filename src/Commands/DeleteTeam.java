package Commands;

import Exceptions.*;
import Model.Project.*;
import Repositories.TeamRepository;
import Model.Team.Team;

import java.util.ArrayList;
import java.util.Optional;

public class DeleteTeam implements Command{

    private int teamID;

    public DeleteTeam(String line) {
        String[] lines = line.split(" ");
        this.teamID = Integer.parseInt(lines[1]);
    }
    @Override
    public void execute() throws EmployeeNotFound, TaskNotFound, IllegalPosition, TeamNotFound, ProjectNotFound, IllegalDepartment, TeamHasEmployees {
        Optional<Team> teamOptional1 = departmentIT.get().getTeams().values().stream()
                .filter(t -> t.getId() == this.teamID).findFirst();

        Optional<Team> teamOptional2 = departmentHR.get().getTeams().values().stream()
                .filter(t -> t.getId() == this.teamID).findFirst();

        Optional<Team> teamOptional3 = departmentMarketing.get().getTeams().values().stream()
                .filter(t -> t.getId() == this.teamID).findFirst();

        if (teamOptional1.isPresent()) {
            if (teamOptional1.get().getEmployees().size() > 0) {
                throw new TeamHasEmployees("Team " + this.teamID + " has employees!");
            } else {
                for (Project pr : teamOptional1.get().getProjects()) {
                    for (Task task:new ArrayList<Task>(pr.getTasks())) {
                        pr.removeTask(task);
                    }
                }
                for (Project pr : new ArrayList<Project>(teamOptional1.get().getProjects())) {
                    teamOptional1.get().removeProject(pr);
                }

                departmentIT.get().getTeams().remove(this.teamID);
                TeamRepository.getInstance().delete(this.teamID);

            }
        }

        if (teamOptional2.isPresent()) {
            if (teamOptional1.get().getEmployees().size() > 0) {
                throw new TeamHasEmployees("Team " + this.teamID + " has employees!");
            } else {
                departmentHR.get().getTeams().remove(this.teamID);
                TeamRepository.getInstance().delete(this.teamID);
            }
        }

        if (teamOptional3.isPresent()) {
            if (teamOptional1.get().getEmployees().size() > 0) {
                throw new TeamHasEmployees("Team " + this.teamID + " has employees!");
            } else {
                departmentMarketing.get().getTeams().remove(this.teamID);
                TeamRepository.getInstance().delete(this.teamID);

            }
        }
    }
}
