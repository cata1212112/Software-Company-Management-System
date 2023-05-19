package Commands;

import Employee.Role;
import Team.Team;

public class ShowProjects implements Command{

    private Integer teamId;

    public ShowProjects(String line) {
        String[] lines = line.split(" ");
        this.teamId = Integer.parseInt(lines[1]);
    }

    @Override
    public void execute() {
        Team team = departmentIT.get().getTeams().get(teamId);

        team.showProjects();
    }

}
