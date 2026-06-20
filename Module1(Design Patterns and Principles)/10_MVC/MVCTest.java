public class MVCTest {
    public static void main(String[] args) {
        Student student = new Student("Dhruv Juneja", "RA2311030010184", "A");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(student, view);

        System.out.println("Initial record:");
        controller.updateView();

        controller.setStudentName("Dhruv J.");
        controller.setStudentGrade("A+");

        System.out.println("\nAfter update via controller:");
        controller.updateView();
    }
}
