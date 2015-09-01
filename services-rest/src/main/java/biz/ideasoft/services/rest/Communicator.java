package biz.ideasoft.services.rest;

import biz.ideasoft.domain.Message;
import biz.ideasoft.services.core.SimpleMessenger;
import biz.ideasoft.services.api.Messenger;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by daniel on 31/8/15.
 */
@Path("/communicator") public class Communicator implements Communication {

  public Response saySomething(String aType) {
    Messenger messenger = new SimpleMessenger();
    Message message = messenger.saySomething(aType);
    return Response.status(Response.Status.OK).entity(message).build();
  }
}

