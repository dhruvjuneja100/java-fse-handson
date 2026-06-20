public class ProxyTest {
    public static void main(String[] args) {
        Image image = new ProxyImage("vacation_photo.png");

        System.out.println("Image object created. No loading has happened yet.\n");

        System.out.println("First call to display():");
        image.display();

        System.out.println("\nSecond call to display():");
        image.display();
    }
}
