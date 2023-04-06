package Commands;

import Project.Project;
import Service.GlobalService;
import Department.*;

import java.util.ArrayList;
import java.util.Date;

public class CreateProject implements Command{
    private String name;
    private Date deadline;
    private String description;
    private int team_id;

    public CreateProject(String line) {
        String[] lines = line.split(" ");
        this.name = lines[1];
        this.deadline = new Date(lines[2]);
        this.team_id = Integer.parseInt(lines[3]);
        StringBuilder aux = new StringBuilder();
        for (int i=4; i< lines.length; i++) {
            aux.append(lines[i]).append(" ");
        }
        this.description = aux.toString();
    }

    @Override
    public void execute() {
        departmentIT.get().getTeams().get(team_id).addProject(new Project(this.name, this.deadline, this.description, this.team_id));
    }
}
