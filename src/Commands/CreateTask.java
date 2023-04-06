package Commands;

import Project.*;
import Team.Team;
import Service.GlobalService;

public class CreateTask implements Command {

    private String description;
    private int priority;
    private int teamID;

    private int project_id;
    private int employee_id;

    public CreateTask(String line) {
        String lines[] = line.split(" ");
        this.priority = Integer.parseInt(lines[1]);
        this.teamID = Integer.parseInt(lines[2]);
        this.project_id = Integer.parseInt(lines[3]);
        this.employee_id = Integer.parseInt(lines[4]);
        StringBuilder aux = new StringBuilder();
        for (int i=5; i< lines.length; i++) {
            aux.append(lines[i]).append(" ");
        }
    }

    @Override
    public void execute() {
        Team team = departmentIT.get().getTeams().get(teamID);
        Project project = team.getProjectByID(this.project_id);
        project.addTaskToProject(new Task(this.description, this.priority, this.employee_id, this.project_id));
    }
}
