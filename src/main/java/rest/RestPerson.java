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
import entity.CityInfo;
import entity.Person;
import entity.PersonDTO;
import errorhandling.*;
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
import java.util.List;

/**
 * REST Web Service
 *
 * @author thoma
 */
@Path("data")
public class RestPerson {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    JsonParser jsonParser = new JsonParser();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    FacadePerson fp = new FacadePerson(emf);
    FacadeCityInfo fc = new FacadeCityInfo(emf);

    @Context
    private UriInfo context;

    public RestPerson() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "This is a restful API.";
    }

    //tester
    @Path("test/{hej}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String testPathParam(@PathParam("hej") String hej) {
        return gson.toJson(hej);
    }

    @Path("getPersonWithHobby/{hobbyName}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonWithHobby(@PathParam("hobbyName") String hobbyName) throws PersonNotFoundException {

        List<PersonDTO> persons = null;
        String json = "";
        try {
            persons = fp.getPersonWithHobby(hobbyName);
            json = gson.toJson(persons, PersonDTO.class);
            return Response.ok(json).build();
        } catch (Exception e) {
            throw new PersonNotFoundException("person not found with this hobby");
        }
    }

    @Path("person/{phoneNum}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonDTO getPersonByPhone(@PathParam("phoneNum") String phoneNum) {
        return fp.getPersonByPhone(phoneNum);
    }
    
    @Path("getAllPersonsByZip/{zipCode}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersonsByZip(@PathParam("zipCode") String zipCode) throws PersonNotFoundException, InternalException {
        List<PersonDTO> persons = null;
        String json = "";
        try {
            List<CityInfo> allZips = fc.getAllZipCodes();
            if (allZips.contains(zipCode)) {
                persons = fp.getAllPersonsByZip(zipCode);
                json = gson.toJson(persons, PersonDTO.class);
                return Response.ok(json).build();
            } else {
                throw new PersonNotFoundException("No persons found with this zipCode");
            }
        } catch (Exception e) {
            throw new InternalException("something went wrong try Remember to vote Saxton");
        }
    }

    @Path("createPerson")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPerson(String json) throws ParamaterNoMatchException {
        Person p = gson.fromJson(json, Person.class);

        if (p.getFirstName() == null || p.getLastName() == null || p.getEmail() == null) {
            throw new ParamaterNoMatchException("Please enter a valid firstname, lastname or email.s");
        } else if ((p.getFirstName().length() <= 1) || (p.getLastName().length() <= 1)) {
            throw new ParamaterNoMatchException("Your firstname and lastname must be at least 2 characters long.");
        }
        fp.addPerson(p);
        return Response.ok(json).build();
    }

//    @Path("editPerson/{phoneNumber}")
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response editPerson(@PathParam("newName") String newName, @PathParam("phoneNumber") String phoneNumber) throws ParamaterNoMatchException {
//        
//      //  fp.
//       // fp.editPerson(person, newName);
//    }
    
    
    @Path("zipcodes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CityInfo> getAllCitys() {
        return fc.getAllZipCodes();
    }

    @Path("cityinfo")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CityInfo> getAllCityInfo() {
        return fc.getAllCityInfo();
    }
}
