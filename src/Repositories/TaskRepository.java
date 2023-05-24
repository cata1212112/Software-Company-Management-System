package Repositories;

import CRUD.CRUDInterface;
import Project.*;
import Service.DatabaseService;

import java.sql.Connection;
import java.util.ArrayList;

public class TaskRepository implements CRUDInterface<Task> {

    private static TaskRepository instance = null;
    private static Connection conn = DatabaseService.conn;

    private TaskRepository() {

    }

    public TaskRepository getInstance() {
        if (instance == null) {
            instance = new TaskRepository();
        }
        return instance;
    }

    @Override
    public Task create(Task Entity) {
        return null;
    }

    @Override
    public ArrayList<Task> read() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Task update(Task Entity) {
        return null;
    }
}
