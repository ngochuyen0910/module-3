package service.customer_type;

import model.CustomerType;
import repository.customer_type.CustomerTypeRepository;
import repository.customer_type.ICustomerTypeRepository;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    private ICustomerTypeRepository customerTypeRepository= new CustomerTypeRepository();
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
