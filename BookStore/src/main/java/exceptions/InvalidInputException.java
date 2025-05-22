/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

import javax.ws.rs.WebApplicationException;

/**
 *
 * @author User
 */
public class InvalidInputException extends WebApplicationException {

    public InvalidInputException(String message) {
        super(message);
    }
}

