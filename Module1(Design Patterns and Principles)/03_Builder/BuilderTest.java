public class BuilderTest {
    public static void main(String[] args) {
        Computer office = new Computer.Builder()
                .setCpu("Intel i5")
                .setRam("8GB")
                .setStorage("512GB SSD")
                .build();

        Computer gaming = new Computer.Builder()
                .setCpu("AMD Ryzen 9")
                .setRam("32GB")
                .setStorage("2TB SSD")
                .setGpu("NVIDIA RTX 4080")
                .setWifi(true)
                .build();

        System.out.println("Office PC: " + office);
        System.out.println("Gaming PC: " + gaming);
    }
}
