package Employee;

public abstract class Employee {
    private static int id = 0;

    protected int employee_id;
    protected String name;
    protected String email;
    protected float salary;

    static {
        id++;
    }

    {
        employee_id = id;
    }

    public Employee() {

    }
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Employee(String name, String email, float salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public abstract void setRole(Roles role);

    public abstract void addPrLang(String lang);

    @Override
    public String toString() {
        return "ID: " + this.employee_id + " NAME: " + this.name + " EMAIL: " + this.email;
    }
}