package Department;

public class HR extends Department{
    private static HR instance = null;

    private HR() {

    }

    public static HR getInstance() {
        if (instance == null) {
            instance = new HR();
        }

        return instance;
    }
}
