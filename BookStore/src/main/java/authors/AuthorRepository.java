/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package authors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author User
 */
public class AuthorRepository {

    private int lastIndex = 0;
    private Map<Integer, AuthorModel> authorMap = new HashMap<>();
    private static AuthorRepository instance;

    private AuthorRepository() {
    }
    
    
    public static AuthorRepository getInstance(){
        if(instance == null)
            instance = new AuthorRepository();
        return instance;
    }

    public AuthorModel createAuthor(AuthorModel author) {
        author.setId(lastIndex);
        authorMap.put(lastIndex++, author);
        return author;
    }

    public AuthorModel findAuthorById(int id) {
        AuthorModel existingAuthor = authorMap.get(id);
        if (isInvalidId(id) || isAuthorNull(id)) {
            return null;
        }

        return authorMap.get(id);
    }

    public List<AuthorModel> getAuthors() {
        return new ArrayList<>(authorMap.values());
    }

    public AuthorModel updateAuthor(AuthorModel author) {
        authorMap.put(author.getId(), author);
        return authorMap.get(author.getId());
    }

    public AuthorModel deleteAuthor(AuthorModel author) {
        authorMap.replace(author.getId(), author, null);
        return author;
    }

    private boolean isInvalidId(int id) {
        return id >= lastIndex;
    }

    private boolean isAuthorNull(int id) {
        return authorMap.get(id) == null;
    }

}
