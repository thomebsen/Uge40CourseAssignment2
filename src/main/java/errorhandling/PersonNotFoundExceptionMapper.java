/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errorhandling;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author thoma
 */
@Provider
public class PersonNotFoundExceptionMapper implements ExceptionMapper<PersonNotFoundException> {
     static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    ServletContext context;

    @Override
    public Response toResponse(PersonNotFoundException ex) {
        boolean isDebug = context.getInitParameter("debug").equals("true");
        ErrorMessage err = new ErrorMessage(ex, 404, isDebug);
        err.setDescription("You tried to find a person, but something went wrong.");
        return Response.status(404)
                .entity(gson.toJson(err))
                .type(MediaType.APPLICATION_JSON).build();
    }

}