package Commands;

import Project.Project;
import Service.GlobalService;

import java.util.Date;

public class CreateProject implements Command{
    private String name;
    private Date deadline;
    private String description;

    @Override
    public void execute() {
        GlobalService.addProject(new Project(name, deadline, description));
    }
}
