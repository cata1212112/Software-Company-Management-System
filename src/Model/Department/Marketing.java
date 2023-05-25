package Model.Department;

public class Marketing extends Department{
    private static Marketing instance = null;

    private Marketing() {
        super();
    }

    public static Marketing getInstance() {
        if (instance == null) {
            instance = new Marketing();
        }

        return instance;
    }
}
