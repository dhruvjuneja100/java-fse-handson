import java.util.Arrays;
import java.util.Comparator;

public class SearchAlgorithms {

    // Linear Search: O(n) — checks each element one by one until found.
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }
        return null; // not found
    }

    // Binary Search: O(log n) — requires the array to be sorted by productId.
    public static Product binarySearch(Product[] sortedProducts, int targetId) {
        int low = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midId = sortedProducts[mid].getProductId();

            if (midId == targetId) {
                return sortedProducts[mid];
            } else if (midId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null; // not found
    }

    // Helper to sort an array of products by productId before binary search.
    public static void sortById(Product[] products) {
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));
    }
}
