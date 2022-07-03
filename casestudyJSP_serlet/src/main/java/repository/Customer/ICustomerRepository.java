package repository.Customer;

import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    void create(Customer customer);

    Customer findById(int customerId);

    void edit(Customer customer);

    void delete(int customerId);
}
