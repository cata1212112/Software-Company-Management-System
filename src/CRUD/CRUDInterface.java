package CRUD;

import java.util.ArrayList;

public interface CRUDInterface<T> {
    T create(T Entity);

    ArrayList<T> read();

    T update(T Entity);

    void delete(int id);
}
