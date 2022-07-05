public class Employee {

    private final static String EMPLOYEE_FORMAT_STRING = "Сотрудник: %8d, %15s, %8d, %5.2f";
    private int id;
    private String surname;
    private int year;
    private double salary;

    public Employee() {
        id = 0;
        surname = "";
        year = 0;
        salary = 0.0;
    }

    public Employee(int id, String surname, int year, double salary) {
        this.id = id;
        this.surname = surname;
        this.year = year;
        this.salary = salary;
    }

    public Employee (Employee emp) {
        id = emp.id;
        surname = emp.surname;
        year = emp.year;
        salary = emp.salary;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }
    
    public int getYear() {
        return year;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public void setYear(int year) {
        this.year = year;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return String.format(EMPLOYEE_FORMAT_STRING, id, surname, year, salary);
    }
}
