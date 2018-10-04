/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errorhandling;

/**
 *
 * @author thoma
 */
public class InternalException extends RuntimeException{
    private String message;

    public InternalException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
