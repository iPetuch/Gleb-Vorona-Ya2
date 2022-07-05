public interface Department {

    void setListName(String listName);
    String getListName();
    int getEmployeeNum();
    Employee getEmployeeById(int id);
    boolean addEmployee(Employee emp);
    boolean deleteEmployee(int id);
    double getAvgSalary();
    Department aboveAvgSalary();
    Department betweenSalary(double b1, double b2);
    void putDepartment();
}