/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
/**
 *
 * @author User
 */
public class BookNotFoundExceptionMapper implements ExceptionMapper<BookNotFoundException> {
    @Override
    public Response toResponse(BookNotFoundException exception) {
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(exception.getMessage())
                .type("text/plain")
                .build();
    }
}
