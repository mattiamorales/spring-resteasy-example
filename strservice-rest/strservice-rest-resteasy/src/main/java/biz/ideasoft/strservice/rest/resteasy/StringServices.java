package biz.ideasoft.strservice.rest.resteasy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface StringServices {

  @GET
  @Path("/calclength/{str: (.*)?}")
  @Produces(MediaType.APPLICATION_JSON)
  Response calculateLength(@PathParam("str") String str);
}

