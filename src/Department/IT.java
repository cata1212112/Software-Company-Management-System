package Department;

public class IT extends Department{
    private static IT instance = null;

    private IT() {

    }

    public static IT getInstance() {
        if (instance == null) {
            instance = new IT();
        }

        return instance;
    }
}
