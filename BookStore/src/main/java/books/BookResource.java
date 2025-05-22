/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package books;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author User
 */
@Path("/books")
public class BookResource {

    private static final BookService service = new BookService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookModel> getBooks() {
        return service.getBooks();
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response geteBookById(@PathParam("id") int id) {
        BookModel createdBook = service.findBookById(id);
        return Response
                .status(Response.Status.CREATED)
                .entity(createdBook)
                .build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBook(BookModel book) {
        System.out.println(book.getId()+" "+book.getTitle());
        BookModel createdBook = service.createBook(book);
        System.out.println(createdBook.getId()+" "+createdBook.getTitle());
        return Response
                .status(Response.Status.CREATED) // 201 Created
                .entity(createdBook) // include the created book
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBook(BookModel book) {
        return service.updateBook(book);

    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBook(@PathParam("id") int id) {
        return service.deleteBook(id);

    }

}
