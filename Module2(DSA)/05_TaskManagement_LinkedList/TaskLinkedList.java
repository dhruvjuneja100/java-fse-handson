public class TaskLinkedList {
    private TaskNode head;
    private int size;

    // O(1) 
    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("Added: " + task);
    }

    // O(n)
    public Task searchTask(int taskId) {
        TaskNode current = head;
        while (current != null) {
            if (current.data.getTaskId() == taskId) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    // O(n) 
    public void traverse() {
        System.out.println("--- Task List ---");
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // O(n)
    public boolean deleteTask(int taskId) {
        TaskNode current = head;
        TaskNode previous = null;

        while (current != null) {
            if (current.data.getTaskId() == taskId) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public int getSize() {
        return size;
    }
}
