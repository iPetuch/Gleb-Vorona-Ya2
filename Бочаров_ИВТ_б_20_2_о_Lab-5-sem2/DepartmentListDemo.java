public class DepartmentListDemo {

    public static void main (String[ ] args){
        Department gr1 = new DepartmentStaticList("Статический список сотрудников", 10);
        Department gr2 = new DepartmentDynamicList("Динамический список инженеров");

        System.out.println("СТАТИЧЕСКИЙ СВЯЗНЫЙ СПИСОК:");

        gr1.addEmployee(new Employee(1232,"Рудников Кирилл Глебович", 1998, 54000));
        gr1.addEmployee(new Employee(6531,"Баранецкий Всеволод Викторович", 1999, 50000));
        gr1.addEmployee(new Employee(4122,"Петров Максим Алексеевич", 1989, 62000));
        gr1.addEmployee(new Employee(7563,"Зоря Алина Александровна", 2000, 57000));

        gr1.putDepartment();
        gr1.aboveAvgSalary().putDepartment();
        gr1.betweenSalary(52000,62000).putDepartment();

        gr1.deleteEmployee(12345);
        System.out.println("\nПосле удаления сотрудника:");
        gr1.putDepartment();
        System.out.println();
        System.out.println("\nПроверка наличия сотрудников:");
        int n = 23345;
        Employee s1 = gr1.getEmployeeById(n);
        if (s1 == null) System.out.printf("\nНет сотрудника с заданным номером %d\n", n);
        else System.out.println(s1);

        System.out.println("ДИНАМИЧЕСКИЙ СВЯЗНЫЙ СПИСОК:");

        gr2.addEmployee(new Employee(1231,"Рудников Кирилл Глебович", 1998, 54000));
        gr2.addEmployee(new Employee(6536,"Баранецкий Всеволод Викторович", 1988, 50000));
        gr2.addEmployee(new Employee(4122,"Петров Максим Алексеевич", 1998, 62000));
        gr2.addEmployee(new Employee(7563,"Зоря Алина Александровна", 1989, 57000));
        
        gr2.putDepartment();
        gr2.aboveAvgSalary().putDepartment();
        gr2.betweenSalary(52000,62000).putDepartment();

        gr2.deleteEmployee(12345);
        System.out.println("\nПосле удаления сотрудника:");
        gr2.putDepartment();
        System.out.println("\nПроверка наличия сотрудников:");
        int n1 = 23345;
        Employee s2 = gr2.getEmployeeById(n);
        if (s2 == null) System.out.printf("\nНет сотрудников с заданным номером %d\n", n);
        else System.out.println(s2);
    }
}
