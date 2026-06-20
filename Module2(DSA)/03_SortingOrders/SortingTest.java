import java.util.Arrays;

public class SortingTest {
    public static void main(String[] args) {
        Order[] ordersForBubble = {
                new Order(1, "Dhruv", 2500.00),
                new Order(2, "Sahil", 750.00),
                new Order(3, "Arnab", 4300.00),
                new Order(4, "Priya", 1200.00),
                new Order(5, "Ravi", 990.00)
        };

        Order[] ordersForQuick = Arrays.copyOf(ordersForBubble, ordersForBubble.length);

        System.out.println("--- Before sorting ---");
        printOrders(ordersForBubble);

        BubbleSort.sort(ordersForBubble);
        System.out.println("\n--- After Bubble Sort (by totalPrice) ---");
        printOrders(ordersForBubble);

        QuickSort.sort(ordersForQuick);
        System.out.println("\n--- After Quick Sort (by totalPrice) ---");
        printOrders(ordersForQuick);
    }

    private static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
