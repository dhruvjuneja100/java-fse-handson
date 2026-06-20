public class DependencyInjectionTest {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(repository);

        System.out.println("Customer #1: " + customerService.getCustomerName(1));
        System.out.println("Customer #2: " + customerService.getCustomerName(2));
        System.out.println("Customer #99: " + customerService.getCustomerName(99));
    }
}
