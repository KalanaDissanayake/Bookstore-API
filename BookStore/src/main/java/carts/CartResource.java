/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carts;

import books.BookModel;
import customers.CustomerModel;
import customers.CustomerRepository;
import exceptions.CustomerNotFoundException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author User
 */
@Path("/customers")
public class CartResource {
    
    CartRepository cartRepository = CartRepository.getInstance();
    CustomerRepository customerRepository = CustomerRepository.getInstance();
    
    
    @POST
    @Path("/{customerId}/cart/items")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
   public Response addItemToCart(@PathParam("customerId") int customerId, CartItemModel cartItem) {
        
        CustomerModel customer = customerRepository.findCustomerById(customerId);
        if(customer==null){
            throw new CustomerNotFoundException(String.format("Customer with ID %d does not exist.", customerId));
        }
        
        if(customer.getCart()==null){
            CartModel cart = new CartModel();
            customer.setCart(cart);
        }
        
        customer.getCart().AddToCart(cartItem.getBookId(), cartItem.getBookQuantity());

        
        return Response
                .status(Response.Status.CREATED)
                .entity(customer.getCart())
                .build();

    }
    
}
