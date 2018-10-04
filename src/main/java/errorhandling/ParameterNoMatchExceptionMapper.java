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
public class ParameterNoMatchExceptionMapper implements ExceptionMapper<ParameterNoMatchException>{
         static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    ServletContext context;

    @Override
    public Response toResponse(ParameterNoMatchException ex) {
        boolean isDebug = context.getInitParameter("debug").equals("true");
        ErrorMessage err = new ErrorMessage(ex, 400, isDebug);
        err.setDescription("You entered a wrong parameter...");
        return Response.status(400)
                .entity(gson.toJson(err))
                .type(MediaType.APPLICATION_JSON).build();
    }
}