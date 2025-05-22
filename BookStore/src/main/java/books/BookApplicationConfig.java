/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package books;

import authors.AuthorResource;
import carts.CartResource;
import customers.CustomerResource;
import exceptions.AuthorNotFoundExceptionMapper;
import exceptions.BookNotFoundException;
import exceptions.BookNotFoundExceptionMapper;
import exceptions.CustomerNotFoundException;
import exceptions.CustomerNotFoundExceptionMapper;
import exceptions.InvalidInputException;
import exceptions.InvalidInputExceptionMapper;
import java.util.Set;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author User
 */
public class BookApplicationConfig extends ResourceConfig {

    public BookApplicationConfig(Set<Class<?>> classes) {
//      
        register(AuthorResource.class);
        register(BookResource.class);
        register(CustomerResource.class);
        register(CartResource.class);
        register(NoClassDefFoundError.class);
        register(AuthorNotFoundExceptionMapper.class);
        register(BookNotFoundException.class);
        register(BookNotFoundExceptionMapper.class);
        register(InvalidInputException.class);
        register(InvalidInputExceptionMapper.class);
        register(CustomerNotFoundException.class);
        register(CustomerNotFoundExceptionMapper.class);

    }

}
