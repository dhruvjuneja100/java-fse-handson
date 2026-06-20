public class InventoryTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addProduct(new Product(101, "Wireless Mouse", 50, 799.00));
        inventory.addProduct(new Product(102, "Mechanical Keyboard", 30, 2499.00));
        inventory.addProduct(new Product(103, "USB-C Hub", 75, 1299.00));

        inventory.displayAll();

        System.out.println("\nUpdating product 102...");
        inventory.updateProduct(102, 25, 2299.00);

        System.out.println("\nDeleting product 101...");
        inventory.deleteProduct(101);

        System.out.println();
        inventory.displayAll();
    }
}
