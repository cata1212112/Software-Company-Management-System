package Commands;

import Employee.Employee;
import Team.Team;

import java.util.Optional;

public class SalaryTeam implements Command{
    private int team_id;

    public SalaryTeam(String line) {
        String[] lines = line.split(" ");
        this.team_id = Integer.parseInt(lines[1]);
    }

    @Override
    public void execute() {
        Optional<Team> teamOptional = departmentIT.get().getTeams().values().stream()
                .filter(t -> t.getId() == this.team_id).findFirst();

        float sum = 0;
        if (teamOptional.isPresent()) {
            Team team = teamOptional.get();
            for (Employee e: team.getEmployees().values()) {
                sum += e.getSalary();
            }
        }
        System.out.println(sum);
    }
}
