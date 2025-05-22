/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customers;

import authors.AuthorModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class CustomerRepository {

    private int lastIndex = 0;
    private Map<Integer, CustomerModel> customerMap = new HashMap<>();
    private static CustomerRepository instance;

    private CustomerRepository() {
    }

    public static CustomerRepository getInstance() {
        if (instance == null) {
            instance = new CustomerRepository();
        }
        return instance;
    }

    public CustomerModel createCustomer(CustomerModel customer) {
        customer.setId(lastIndex);
        customerMap.put(lastIndex++, customer);
        return customer;
    }

    public CustomerModel findCustomerById(int id) {
        CustomerModel existingCustomer = customerMap.get(id);
        if (isInvalidId(id) || isCustomerNull(id)) {
            return null;
        }

        return customerMap.get(id);
    }

    public List<CustomerModel> getCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    public CustomerModel updateCustomer(CustomerModel customer) {
        customerMap.put(customer.getId(), customer);
        return customerMap.get(customer.getId());
    }

    public CustomerModel deleteCustomer(CustomerModel customer) {
        customerMap.replace(customer.getId(), customer, null);
        return customer;
    }

    private boolean isInvalidId(int id) {
        return id >= lastIndex;
    }

    private boolean isCustomerNull(int id) {
        return customerMap.get(id) == null;
    }
}
