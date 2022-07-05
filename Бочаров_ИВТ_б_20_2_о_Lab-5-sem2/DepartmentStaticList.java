public class DepartmentStaticList implements Department {

    private final static int MIN_NUM = 5;

    private final static String STATICDEPARTMENTLIST_FORMAT_STRING = "Вычислительный центр: число сотрудников: %3d";
    private Employee[] emps;
    private int num;
    private String listName;

    public DepartmentStaticList() {
        num = 0;
        emps = new Employee[MIN_NUM];
    }

    public DepartmentStaticList(String listName, int numMax) {
        num = 0;
        emps = new Employee[numMax];
    }

    public int getNum() {
        return num;
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
        return getNum();
    }

    @Override
    public Employee getEmployeeById(int id) {
        for (int i = 0; i < num; i++)
            if (emps[i].getId() == id) return emps[i];
        return null;
    }

    public String toString() {
        return String.format(STATICDEPARTMENTLIST_FORMAT_STRING, num);
    }

    @Override
    public boolean addEmployee (Employee emp) {
        if (num == emps.length) return false;
        for (int i = 0; i < num; i++)
            if (emps[i].getId() == emp.getId()) return false;
        emps[num] = emp;
        num++;
        return true;
    }

    @Override
    public boolean deleteEmployee(int id) {
        int i;
        for (i = 0; i < num; i++)
            if (emps[i].getId() == id) break;
        if (i == num) return false;
        for (i = i + 1; i < num; i++)
            emps[i - 1] = emps[i];
        emps[i - 1] = null;
        num--;
        return true;
    }

    @Override
    public double getAvgSalary() {
        if (num == 0) return 0;
        double avg = 0;
        for (int i = 0; i < num; i++) {
            avg = avg + emps[i].getSalary();
        }
        return avg / num;
    }

    @Override
    public DepartmentStaticList aboveAvgSalary() {
        double avg = getAvgSalary();
        DepartmentStaticList list = new DepartmentStaticList(String.format("Сотрудники, у которых зарплата выше средней %.2f", avg), num);
        for (int i = 0; i < num; i++) {
            if (emps[i].getSalary() > avg) {
                list.addEmployee(emps[i]);
            }
        }
        return list;
    }

    @Override
    public DepartmentStaticList betweenSalary(double b1, double b2) {
        DepartmentStaticList list = new DepartmentStaticList(String.format("Сотрудники, у которых зарплата в диапазоне от %.2f до %.2f", b1, b2), num);
        for (int i = 0; i < num; i++) {
            double b = emps[i].getSalary();
            if ((b >= b1) && (b <= b2)) {
                list.addEmployee(emps[i]);
            }
        }
        return list;
    }

    @Override
    public void putDepartment() {
        if (num != 0) {
            System.out.printf("%5s%17s%11s%14s%17s\n", "Номер", "ID", "Год рождения", "ФИО", "Зарплата");
            for (int i = 0; i < num; i++) {
                System.out.printf("  %-7d  %-15d  %-16s %-7d %-10.2f\n", i + 1, emps[i].getId(), emps[i].getSurname(), emps[i].getYear(), emps[i].getSalary());
            }
        }
    }

}
