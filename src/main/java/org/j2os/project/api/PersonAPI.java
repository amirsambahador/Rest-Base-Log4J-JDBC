package org.j2os.project.api;

import org.j2os.project.common.ErrorWrapper;
import org.j2os.project.domain.Person;
import org.j2os.project.service.PersonService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/person")

public class PersonAPI {
    @Path("/save")
    @GET
    @Produces("application/json")
    public Object save(@QueryParam("name") String name, @QueryParam("family") String family) {
        try {
            PersonService.getInstance().save(Person.builder().name(name).family(family).build());
            return findAll();
        } catch (Exception e) {
            return ErrorWrapper.getError(e);
        }
    }
    @Path("/update")
    @GET
    @Produces("application/json")
    public Object update(@QueryParam("id")String id,@QueryParam("name") String name, @QueryParam("family") String family) {
        try {
            PersonService.getInstance().update(Person.builder().id(Long.parseLong(id)).name(name).family(family).build());
            return findAll();
        } catch (Exception e) {
            return ErrorWrapper.getError(e);
        }
    }
    @Path("/remove")
    @GET
    @Produces("application/json")
    public Object remove(@QueryParam("id")String id) {
        try {
            PersonService.getInstance().remove(Person.builder().id(Long.parseLong(id)).build());
            return findAll();
        } catch (Exception e) {
            return ErrorWrapper.getError(e);
        }
    }
    @Path("/findAll")
    @GET
    @Produces("application/json")
    public Object findAll() {
        try {
            return PersonService.getInstance().findAll();
        } catch (Exception e) {
            return ErrorWrapper.getError(e);
        }
    }
}
