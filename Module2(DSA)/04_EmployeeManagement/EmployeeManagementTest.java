public class EmployeeManagementTest {
    public static void main(String[] args) {
        EmployeeArrayManager manager = new EmployeeArrayManager(2);

        manager.add(new Employee(1, "Dhruv Juneja", "Software Engineer", 60000));
        manager.add(new Employee(2, "Sahil Kumar", "QA Engineer", 50000));
        manager.add(new Employee(3, "Arnab Datta", "DevOps Engineer", 55000));

        manager.traverse();

        System.out.println("\nSearching for employee ID 2:");
        Employee found = manager.search(2);
        System.out.println(found != null ? found : "Not found");

        System.out.println("\nDeleting employee ID 1:");
        manager.delete(1);

        System.out.println();
        manager.traverse();
    }
}
