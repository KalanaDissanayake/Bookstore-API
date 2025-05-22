/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package authors;

import exceptions.AuthorNotFoundException;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author User
 */
public class AuthorService {

    private  AuthorRepository repository = AuthorRepository.getInstance();

    public AuthorModel createAuthor(AuthorModel author) {
        return repository.createAuthor(author);
    }

    public List<AuthorModel> getAuthors() {
        return repository.getAuthors();
    }
    
    public Response getAutherById(int id){
        AuthorModel existingAuthor = findAuthorById(id);
        return Response.ok(existingAuthor).build();
    }

    public Response updateAuthor(AuthorModel author) {

        AuthorModel existingAuthor = findAuthorById(author.getId());
        updateAuthorValues(existingAuthor, author);
        AuthorModel updatedAuthor = repository.updateAuthor(existingAuthor);
        return Response.ok(updatedAuthor).build();

    }

    public Response deleteAuthor(int id) {

        AuthorModel existingAuthor = findAuthorById(id);
        return Response.ok(repository.deleteAuthor(existingAuthor)).build();
    }

    public AuthorModel findAuthorById(int id) {

        AuthorModel existingAuthor = repository.findAuthorById(id);

        if (existingAuthor == null) {
            throw new AuthorNotFoundException(String.format("Author with ID %d does not exist.", id));
        }
        
        return existingAuthor;
    }
    
    private void updateAuthorValues(AuthorModel existingAuthor, AuthorModel newgAuthor){
        existingAuthor.setName(newgAuthor.getName());
        existingAuthor.setBiography(newgAuthor.getBiography());
    }

}
