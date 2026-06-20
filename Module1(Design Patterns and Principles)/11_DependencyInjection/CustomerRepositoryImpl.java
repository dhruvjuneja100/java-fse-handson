import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private final Map<Integer, String> customers = new HashMap<>();

    public CustomerRepositoryImpl() {
        customers.put(1, "Dhruv Juneja");
        customers.put(2, "Sahil Kumar");
        customers.put(3, "Arnab Datta");
    }

    @Override
    public String findCustomerById(int id) {
        return customers.getOrDefault(id, "Customer not found");
    }
}
