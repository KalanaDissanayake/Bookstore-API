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
public class InvalidInputExceptionMapper implements ExceptionMapper<InvalidInputException> {
    
    @Override
    public Response toResponse(InvalidInputException exception) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(exception.getMessage())
                .type("text/plain")
                .build();
    }
}
 
