/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package books;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class BookRepository {

    private static BookRepository instance;
    private int lastIndex = 0;
    private Map<Integer, BookModel> BookMap = new HashMap<>();

    private BookRepository() {
    }
    
    

    public static BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }

        return instance;
    }

    public BookModel createBook(BookModel book) {
        book.setId(lastIndex);
        BookMap.put(lastIndex++, book);
        return book;
    }

    public BookModel findBookById(int id) {
        BookModel existingBook = BookMap.get(id);
        if (isInvalidId(id) || isBookNull(id)) {
            return null;
        }

        return BookMap.get(id);
    }

    public List<BookModel> getBooks() {
        return new ArrayList<>(BookMap.values());
    }

    public BookModel updateBook(BookModel book) {
        BookMap.put(book.getId(), book);
        return BookMap.get(book.getId());
    }

    public BookModel deleteBook(BookModel book) {
        BookMap.replace(book.getId(), book, null);
        return book;
    }

    private boolean isInvalidId(int id) {
        return id >= lastIndex;
    }

    private boolean isBookNull(int id) {
        return BookMap.get(id) == null;
    }

}
