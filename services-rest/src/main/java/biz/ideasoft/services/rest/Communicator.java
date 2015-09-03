package biz.ideasoft.services.rest;

import biz.ideasoft.domain.Message;
import biz.ideasoft.services.api.Messenger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/communicator")
@Service
public class Communicator implements Communication {

  @Resource(name = "messenger")
  private Messenger messenger;

  public void setMessenger(Messenger messenger) {
    this.messenger = messenger;
  }

  public Response saySomething(String aType) {
    Message message = messenger.saySomething(aType);
    //    return Response.ok("{type: \"" + aType + "\"}").build();
    return Response.status(Response.Status.OK).entity(message).build();
  }
}

