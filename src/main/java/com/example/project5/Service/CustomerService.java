package com.example.project5.Service;

import com.example.project5.Exception.APIException;
import com.example.project5.Model.Customer;
import com.example.project5.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private CustomerRepository customerRepository;


    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerBy(Integer customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer == null)
            throw new APIException("Customer not found");
        return customer;
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Integer customerId, Customer customer) {
        Customer storedCustomer = getCustomerBy(customerId);

        storedCustomer.setName(customer.getName());
        customerRepository.save(storedCustomer);
    }

    public void deleteCustomer(Integer customerId) {
        getCustomerBy(customerId);
        customerRepository.deleteById(customerId);
    }
}
