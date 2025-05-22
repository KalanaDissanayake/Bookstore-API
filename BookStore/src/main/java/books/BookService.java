/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package books;

import exceptions.BookNotFoundException;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author User
 */
public class BookService {

    private  BookRepository repository = BookRepository.getInstance();

    public BookModel createBook(BookModel book) {
        validateBookData(book);
        return repository.createBook(book);
    }

    public List<BookModel> getBooks() {
        return repository.getBooks();
    }

    public Response updateBook(BookModel book) {

        BookModel existingBook = findBookById(book.getId());
        updateBookValues(existingBook, book);
        BookModel updatedBook = repository.updateBook(existingBook);
        return Response.ok(updatedBook).build();

    }

    public Response deleteBook(int id) {

        BookModel existingBook = findBookById(id);
        return Response.ok(repository.deleteBook(existingBook)).build();
    }

    public BookModel findBookById(int id) {

        BookModel existingBook = repository.findBookById(id);

        if (existingBook == null) {
            throw new BookNotFoundException(String.format("Book with ID %d does not exist.", id));
        }

        return existingBook;
    }

    private void updateBookValues(BookModel existingBook, BookModel newBook) {

        existingBook.setTitle(newBook.getTitle());
        existingBook.setAuthorId(newBook.getAuthorId());
        existingBook.setIsbn(newBook.getIsbn());
        existingBook.setPublicationYear(newBook.getPublicationYear());
        existingBook.setPrice(newBook.getPrice());
        existingBook.setStock(newBook.getStock());

    }

    private void validateBookData(BookModel book) {
        BookDataValidation validation = new BookDataValidation();
        validation.validateAuthorId(book.getAuthorId());
        validation.isValidPublicationYear(book.getPublicationYear());
    }

}
