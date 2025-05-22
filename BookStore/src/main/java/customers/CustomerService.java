/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customers;

import carts.CartRepository;
import exceptions.CustomerNotFoundException;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author User
 */
public class CustomerService {

    private CustomerRepository repository = CustomerRepository.getInstance();

    public CustomerModel createCustomer(CustomerModel customer) {
        
        return repository.createCustomer(customer);
    }

    public List<CustomerModel> getCustomers() {
        return repository.getCustomers();
    }
    
    public Response getCustomerById(int id){
        CustomerModel existingCustomer = findCustomerById(id);
        return Response.ok(existingCustomer).build();
    }

    public Response updateCustomer(CustomerModel customer) {

        CustomerModel existingCustomer = findCustomerById(customer.getId());
        updateCustomerValues(existingCustomer, customer);
        CustomerModel updatedCustomer = repository.updateCustomer(existingCustomer);
        return Response.ok(updatedCustomer).build();

    }

    public Response deleteCustomer(int id) {

        CustomerModel existingCustomer = findCustomerById(id);
        return Response.ok(repository.deleteCustomer(existingCustomer)).build();
    }

    public CustomerModel findCustomerById(int id) {

        CustomerModel existingCustomer = repository.findCustomerById(id);

        if (existingCustomer == null) {
            throw new CustomerNotFoundException(String.format("Customer with ID %d does not exist.", id));
        }

        return existingCustomer;
    }

    private void updateCustomerValues(CustomerModel existingCustomer, CustomerModel newCustomer) {
        existingCustomer.setName(newCustomer.getName());
        existingCustomer.setPassword(newCustomer.getPassword());
    }

}
