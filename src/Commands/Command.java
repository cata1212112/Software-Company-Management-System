package Commands;

import Model.Department.*;
import Exceptions.*;


import java.util.function.Supplier;

public interface Command {

    Supplier<IT> departmentIT = IT::getInstance;
    Supplier<HR> departmentHR = HR::getInstance;
    Supplier<Marketing> departmentMarketing = Marketing::getInstance;
    public void execute() throws EmployeeNotFound, TaskNotFound, IllegalPosition, TeamNotFound, ProjectNotFound, IllegalDepartment, TeamHasEmployees, ProjectHasTasks, NameAlreadyInUse, EmailAlreadyInUse, ProjectHasAssignedTasks;
}
