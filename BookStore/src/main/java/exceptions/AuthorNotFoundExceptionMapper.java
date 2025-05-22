/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author User
 */
@Provider 
public class AuthorNotFoundExceptionMapper implements ExceptionMapper<AuthorNotFoundException> {

    @Override
    public Response toResponse(AuthorNotFoundException exception) {
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(exception.getMessage())
                .type("text/plain")
                .build();
    }
}
