public class TaskManagementTest {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(new Task(1, "Prepare resume", "In Progress"));
        taskList.addTask(new Task(2, "Revise DSA - Arrays", "Pending"));
        taskList.addTask(new Task(3, "Mock interview", "Pending"));

        taskList.traverse();

        System.out.println("\nSearching for task ID 2:");
        Task found = taskList.searchTask(2);
        System.out.println(found != null ? found : "Not found");

        System.out.println("\nDeleting task ID 1:");
        taskList.deleteTask(1);

        System.out.println();
        taskList.traverse();
    }
}
