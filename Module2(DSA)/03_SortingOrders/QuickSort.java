public class QuickSort {
    public static void sort(Order[] orders) {
        if (orders == null || orders.length < 2) {
            return;
        }
        quickSort(orders, 0, orders.length - 1);
    }

    private static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivotValue = orders[high].getTotalPrice(); 
        int i = low - 1; 

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivotValue) {
                i++;
                swap(orders, i, j);
            }
        }
        swap(orders, i + 1, high);
        return i + 1;
    }

    private static void swap(Order[] orders, int i, int j) {
        Order temp = orders[i];
        orders[i] = orders[j];
        orders[j] = temp;
    }
}
