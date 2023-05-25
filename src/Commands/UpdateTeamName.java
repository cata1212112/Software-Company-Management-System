package Commands;

import Exceptions.*;
import Repositories.TeamRepository;
import Model.Team.Team;

import java.util.Optional;

public class UpdateTeamName implements Command{

    private int teamID;
    private String newName;

    public UpdateTeamName(String line) {
        String[] lines = line.split(" ");
        this.teamID = Integer.parseInt(lines[1]);
        this.newName = lines[2];
    }

    @Override
    public void execute() throws EmployeeNotFound, TaskNotFound, IllegalPosition, TeamNotFound, ProjectNotFound, IllegalDepartment, TeamHasEmployees, ProjectHasTasks, NameAlreadyInUse {
        long cnt1 = departmentIT.get().getTeams().values().stream().filter(t -> t.getName().equals(this.newName)).count();
        long cnt2 = departmentHR.get().getTeams().values().stream().filter(t -> t.getName().equals(this.newName)).count();
        long cnt3 = departmentMarketing.get().getTeams().values().stream().filter(t -> t.getName().equals(this.newName)).count();

        if (cnt1 > 0 || cnt2 > 0 || cnt3 > 0) {
            throw new NameAlreadyInUse(this.newName);
        }


        Optional<Team> teamOptional1 = departmentIT.get().getTeams().values().stream()
                .filter(t -> t.getId() == this.teamID).findFirst();

        Optional<Team> teamOptional2 = departmentHR.get().getTeams().values().stream()
                .filter(t -> t.getId() == this.teamID).findFirst();

        Optional<Team> teamOptional3 = departmentMarketing.get().getTeams().values().stream()
                .filter(t -> t.getId() == this.teamID).findFirst();

        Optional<Team> teamOptional = teamOptional1;
        if (teamOptional2.isPresent()) {
            teamOptional = teamOptional2;
        }
        if (teamOptional3.isPresent()) {
            teamOptional = teamOptional3;
        }
        if (teamOptional.isPresent()) {
            Team team = teamOptional.get();
            team.setName(this.newName);
            TeamRepository.getInstance().update(team);
        } else {
            throw new TeamNotFound(this.teamID);
        }
    }
}
