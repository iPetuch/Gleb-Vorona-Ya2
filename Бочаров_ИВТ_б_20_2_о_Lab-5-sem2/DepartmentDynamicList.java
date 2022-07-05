public class DepartmentDynamicList implements Department {

    private final static String LIST_FORMAT_STRING = "Вычислительный отдел\n: Количество сотрудников: %d";

    private Employee emp;
    private DepartmentDynamicList next;

    private String listName = "";

    public DepartmentDynamicList() {
        this.emp = null;
        this.next = null;
    }

    public DepartmentDynamicList(String name) {
        this.emp = new Employee();
        this.emp.setId(0);
        this.emp.setSalary(0.0);
        this.emp.setYear(0);
        this.emp.setSurname(name);
        this.next = null;
    }

    public DepartmentDynamicList(Employee emp) {
        this.emp = emp;
        this.next = null;
    }

    public Employee getEmployee(int id) {
        if (next == null) return null;
        DepartmentDynamicList next = this.next;
        while (next != null) {
            if (next.emp.getId() == id) return next.emp;
            next = next.next;
        }
        return null;
    }

    @Override
    public void setListName(String listName) {
        this.listName = listName;
    }

    @Override
    public String getListName() {
        return listName;
    }

    @Override
    public int getEmployeeNum() {
        int i = 0;
        DepartmentDynamicList next = this.next;
        while (next != null) {
            i++;
            next = next.next;
        }
        return i;
    }

    @Override
    public Employee getEmployeeById(int id) {
        DepartmentDynamicList next = this.next;
        while (next != null) {
            if (next.emp.getId() == id) {
                return next.emp;
            }
            next = next.next;
        }
        return null;
    }

    @Override
    public boolean addEmployee(Employee engineer) {
        if (getEmployee(emp.getId()) != null) return false;
        DepartmentDynamicList next = new DepartmentDynamicList(emp);
        if (this.next == null) this.next = next;
        else {
            DepartmentDynamicList previous = this.next;
            this.next = next;
            next.next = previous;
        }
        return true;
    }

    @Override
    public boolean deleteEmployee(int id) {
        DepartmentDynamicList next = this;
        while (next.next != null) {
            if (next.next.emp.getId() == id) {
                next.next = next.next.next;
                return true;
            }
            next = next.next;
        }
        return false;
    }

    @Override
    public double getAvgSalary() {
        if (this.next == null) return 0.0;
        double avg = 0.0;
        int num = 0;
        DepartmentDynamicList next = this.next;
        while (next != null) {
            avg = avg + next.emp.getSalary();
            num = num + 1;
            next = next.next;
        }
        return avg / num;
    }

    @Override
    public DepartmentDynamicList aboveAvgSalary() {
        double avg = getAvgSalary();
        DepartmentDynamicList head = new DepartmentDynamicList(String.format("\nСотрудника, у которых зарплата выше средней зарплаты вычислительного центра: %.2f", avg));
        DepartmentDynamicList next = this.next;
        while (next != null) {
            if (next.emp.getSalary() > avg) head.addEmployee(next.emp);
            next = next.next;
        }
        return head;
    }

    @Override
    public DepartmentDynamicList betweenSalary(double b1, double b2) {
        DepartmentDynamicList head = new DepartmentDynamicList(String.format("\nСотрудники, у которых зарплата в диапазоне от %.2f до %.2f:", b1, b2));
        DepartmentDynamicList next = this.next;
        while (next != null) {
            double b = next.emp.getSalary();
            if ((b >= b1) &&(b <= b2)) head.addEmployee(new Employee(next.emp));
            next = next.next;
        }
        return head;
    }
    @Override
    public void putDepartment() {
        System.out.println(emp.getSurname());
        System.out.printf("%5s%17s%10s%11s%17s\n", "Номер", "ID", "ФИО", "Год рождения", "Зарплата");
        DepartmentDynamicList next = this.next;
        int i = 1;
        while (next != null) {
            System.out.printf("%-7d%-15d%-16s%-15d%-10.2f\n", i, next.emp.getId(), next.emp.getSurname(), next.emp.getYear(), next.emp.getSalary());
            next = next.next;
            i = i + 1;
        }
    }
}
