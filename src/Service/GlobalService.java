package Service;

import Project.Project;

import java.util.ArrayList;

public class GlobalService {

    private static ArrayList<Project> openProjects = new ArrayList<>();
    private GlobalService() {

    }

    public static void addProject(Project pr) {
        openProjects.add(pr);
    }

    public static void showOpenProjects() {

    }
}
