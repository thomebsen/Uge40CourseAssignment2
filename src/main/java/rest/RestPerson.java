/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import entity.Address;
import entity.Person;
import entity.PersonDTO;
import errorhandling.ParamaterNoMatchException;
import facade.FacadePerson;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jdk.nashorn.internal.parser.JSONParser;
import facade.*;

/**
 * REST Web Service
 *
 * @author thoma
 */
@Path("person")
public class RestPerson {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    JsonParser jsonParser = new JsonParser();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    FacadePerson fp = new FacadePerson(emf);

    @Context
    private UriInfo context;

    public RestPerson() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return gson.toJson("This is a restful API");
    }
//
//    @Path("getByPhoneNumber/{number}")
//    @GET
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getPersonByPhoneNumber(String json, @PathParam("phoneNum") String phoneNum) {
//        Person p = gson.fromJson(json, Person.class);
//        fp.getPersonByPhone(phoneNum);
//        return Response.ok(json).build();
//    }

    @Path("createPerson")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPerson(String json) throws ParamaterNoMatchException {
        Person p = gson.fromJson(json, Person.class);

        if (p.getFirstName()== null || p.getLastName() == null || p.getEmail() == null) {
            throw new ParamaterNoMatchException("Please enter a valid firstname, lastname or email.s");
        } else if ((p.getFirstName().length() <= 1) || (p.getLastName().length() <= 1)) {
            throw new ParamaterNoMatchException("Your firstname and lastname must be at least 2 characters long.");
        }
        fp.addPerson(p);
        return Response.ok(json).build();
    }
}
