import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<Integer, Product> products = new HashMap<>();

    // O(1) average case
    public void addProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            System.out.println("Product ID " + product.getProductId() + " already exists. Use updateProduct() instead.");
            return;
        }
        products.put(product.getProductId(), product);
        System.out.println("Added: " + product);
    }

    // O(1) average case
    public void updateProduct(int productId, int newQuantity, double newPrice) {
        Product product = products.get(productId);
        if (product == null) {
            System.out.println("Product ID " + productId + " not found.");
            return;
        }
        product.setQuantity(newQuantity);
        product.setPrice(newPrice);
        System.out.println("Updated: " + product);
    }

    // O(1) average case
    public void deleteProduct(int productId) {
        Product removed = products.remove(productId);
        if (removed == null) {
            System.out.println("Product ID " + productId + " not found.");
        } else {
            System.out.println("Deleted: " + removed);
        }
    }

    // O(1) average case
    public Product getProduct(int productId) {
        return products.get(productId);
    }

    // O(n) - must visit every entry to print them all
    public void displayAll() {
        System.out.println("--- Current Inventory ---");
        for (Product p : products.values()) {
            System.out.println(p);
        }
    }
}
