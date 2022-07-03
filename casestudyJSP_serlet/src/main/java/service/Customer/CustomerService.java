package service.Customer;

import model.Customer;
import repository.Customer.CustomerRepository;
import repository.Customer.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void create(Customer customer) {
        customerRepository.create(customer);
    }

    @Override
    public Customer findById(int customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public void edit(Customer customer) {
        customerRepository.edit(customer);
    }

    @Override
    public void delete(int customerId) {
        customerRepository.delete(customerId);
    }
}
