public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
                new Product(105, "Bluetooth Speaker", "Electronics"),
                new Product(101, "Wireless Mouse", "Electronics"),
                new Product(110, "Yoga Mat", "Fitness"),
                new Product(103, "USB-C Hub", "Electronics"),
                new Product(108, "Running Shoes", "Footwear")
        };

        int targetId = 103;

        // Linear search works on the unsorted array as-is
        long startLinear = System.nanoTime();
        Product foundLinear = SearchAlgorithms.linearSearch(products, targetId);
        long endLinear = System.nanoTime();
        System.out.println("Linear search found: " + foundLinear);
        System.out.println("Linear search time: " + (endLinear - startLinear) + " ns");

        // Binary search requires sorted data first
        SearchAlgorithms.sortById(products);
        long startBinary = System.nanoTime();
        Product foundBinary = SearchAlgorithms.binarySearch(products, targetId);
        long endBinary = System.nanoTime();
        System.out.println("\nBinary search found: " + foundBinary);
        System.out.println("Binary search time: " + (endBinary - startBinary) + " ns");

        System.out.println("\n(Note: for such a tiny dataset, timing differences are negligible. " +
                "The advantage of binary search only becomes significant as n grows large.)");
    }
}
