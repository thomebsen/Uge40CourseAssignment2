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
public class ParameterNoMatchException extends RuntimeException{
    private String message;

    public ParameterNoMatchException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
