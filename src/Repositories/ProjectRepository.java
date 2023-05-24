package Repositories;

import CRUD.CRUDInterface;
import Project.*;
import Service.DatabaseService;

import java.sql.Connection;
import java.util.ArrayList;

public class ProjectRepository implements CRUDInterface<Project> {

    private static ProjectRepository instance = null;
    private static Connection conn = DatabaseService.conn;

    private ProjectRepository() {

    }

    public ProjectRepository getInstance() {
        if (instance == null) {
            instance = new ProjectRepository();
        }
        return instance;
    }

    @Override
    public Project create(Project Entity) {
        return null;
    }

    @Override
    public ArrayList<Project> read() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Project update(Project Entity) {
        return null;
    }
}
