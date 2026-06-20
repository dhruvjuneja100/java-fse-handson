import java.util.Arrays;

public class EmployeeArrayManager {
    private Employee[] employees;
    private int size; 

    public EmployeeArrayManager(int initialCapacity) {
        employees = new Employee[initialCapacity];
        size = 0;
    }

    // O(1) 
    public void add(Employee employee) {
        if (size == employees.length) {
            resize();
        }
        employees[size] = employee;
        size++;
        System.out.println("Added: " + employee);
    }

    private void resize() {
        int newCapacity = employees.length * 2;
        employees = Arrays.copyOf(employees, newCapacity);
        System.out.println("(Array resized to capacity " + newCapacity + ")");
    }

    // O(n) 
    public Employee search(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // O(n)
    public void traverse() {
        System.out.println("--- Employee Records ---");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // O(n)
    public boolean delete(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[size - 1] = null; 
                size--;
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }
}
