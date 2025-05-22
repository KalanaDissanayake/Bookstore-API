/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package books;

import authors.AuthorModel;
import authors.AuthorRepository;
import exceptions.AuthorNotFoundException;
import exceptions.InvalidInputException;
import java.time.Year;
/**
 *
 * @author User
 */
public class BookDataValidation {
    
    private static AuthorRepository authoRepository = AuthorRepository.getInstance();
    
    public void validateAuthorId(int authorId){
        AuthorModel author = authoRepository.findAuthorById(authorId);
        if(author == null)
            throw new AuthorNotFoundException(String.format("Author with ID %d does not exist", authorId));
    }
    
    public void isValidPublicationYear(int year){
        
         int currentYear = Year.now().getValue();
         
         if (year > currentYear)
             throw new InvalidInputException("Publication year cannot be in the future.");
        
    }
    
}
