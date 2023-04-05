package Commands;

import Department.*;


import java.util.function.Supplier;

public interface Command {

    Supplier<IT> departmentIT = IT::getInstance;
    Supplier<HR> departmentHR = HR::getInstance;
    Supplier<Marketing> departmentMarketing = Marketing::getInstance;
    public void execute();
}
