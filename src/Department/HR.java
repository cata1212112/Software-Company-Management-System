package Department;

public class HR extends Department{
    private static HR instance = null;

    private HR() {
        super();
    }

    public static HR getInstance() {
        if (instance == null) {
            instance = new HR();
        }

        return instance;
    }
}
