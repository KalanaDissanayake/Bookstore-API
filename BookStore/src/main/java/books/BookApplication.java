/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package books;

import authors.AuthorResource;
import carts.CartResource;
import customers.CustomerResource;
import exceptions.AuthorNotFoundException;
import exceptions.AuthorNotFoundExceptionMapper;
import exceptions.BookNotFoundException;
import exceptions.BookNotFoundExceptionMapper;
import exceptions.CustomerNotFoundException;
import exceptions.CustomerNotFoundExceptionMapper;
import exceptions.InvalidInputException;
import exceptions.InvalidInputExceptionMapper;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author User
 */
@ApplicationPath("book")
public class BookApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {

        Set<Class<?>> classes = new HashSet<>();

        classes.add(AuthorResource.class);
        classes.add(BookResource.class);
        classes.add(CustomerResource.class);
        classes.add(CartResource.class);
        classes.add(AuthorNotFoundException.class);
        classes.add(AuthorNotFoundExceptionMapper.class);
        classes.add(BookNotFoundException.class);
        classes.add(BookNotFoundExceptionMapper.class);
        classes.add(InvalidInputException.class);
        classes.add(InvalidInputExceptionMapper.class);
        classes.add(CustomerNotFoundException.class);
        classes.add(CustomerNotFoundExceptionMapper.class);
        return classes;
    }

}
