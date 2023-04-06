package Commands;

public class CommandFactory {
    private CommandFactory() {

    }

    public static Command createCommand(String line) {
        if (line.contains("add-team")) {
            return new CreateTeam(line);
        } else if (line.contains("add-project")) {
            return new CreateProject(line);
        } else if (line.contains("add-task")) {
            return new CreateTask(line);
        } else if (line.contains("add-employee-in-team")) {
            return new AddEmployeeToTeam(line);
        } else if (line.contains("show-employees")) {
            return new ShowEmployees(line);
        } else if (line.contains("show-teams")) {
            return new ShowTeams(line);
        } else if (line.contains("show-projects")) {
            return new ShowProjects(line);
        } else if (line.contains("show-tasks")) {
            return new ShowTasks(line);
        } else if (line.contains("salary-department")) {
            return new SalaryDepartment(line);
        } else if (line.contains("salary-team")) {
            return new SalaryTeam(line);
        } else if (line.contains("add-employee-to-task")) {
            return new AddEmployeeToTask(line);
        } else if (line.contains("finish-task")) {
            return new FinishTask(line);
        } else if (line.contains("finish-project")) {
            return new FinishProject(line);
        }
        return null;
    }
}
