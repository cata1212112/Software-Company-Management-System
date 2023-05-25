package Commands;

import Model.Employee.Employee;
import Exceptions.TeamNotFound;
import Model.Team.Team;

import java.util.Optional;

public class SalaryTeam implements Command{
    private int team_id;

    public SalaryTeam(String line) {
        String[] lines = line.split(" ");
        this.team_id = Integer.parseInt(lines[1]);
    }

    @Override
    public void execute() throws TeamNotFound {
        Optional<Team> teamOptional1 = departmentIT.get().getTeams().values().stream()
                .filter(t -> t.getId() == this.team_id).findFirst();

        Optional<Team> teamOptional2 = departmentHR.get().getTeams().values().stream()
                .filter(t -> t.getId() == this.team_id).findFirst();

        Optional<Team> teamOptional3 = departmentMarketing.get().getTeams().values().stream()
                .filter(t -> t.getId() == this.team_id).findFirst();

        Optional<Team> teamOptional = teamOptional1;
        if (teamOptional2.isPresent()) {
            teamOptional = teamOptional2;
        }
        if (teamOptional3.isPresent()) {
            teamOptional = teamOptional3;
        }
        float sum = 0;
        if (teamOptional.isPresent()) {
            Team team = teamOptional.get();
            for (Employee e: team.getEmployees().values()) {
                sum += e.getSalary();
            }
        } else {
            throw new TeamNotFound(this.team_id);
        }
        System.out.println(sum);
    }
}
