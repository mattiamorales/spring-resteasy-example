package biz.ideasoft.strservice.rest;

import biz.ideasoft.strservice.data.LengthResult;
import biz.ideasoft.strservice.api.StringProcessor;
import biz.ideasoft.strservice.api.StringProcessorMock;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/strengine")
@Service
public class StrEngine implements StringServices {

  @Resource(name = "strProcessor")
  private StringProcessor stringProcessor;

  @SuppressWarnings("unused")
  public void setStringProcessor(StringProcessor stringProcessor) {
      this.stringProcessor = stringProcessor;
    }

  public Response calculateLength(String str) {
    LengthResult result = stringProcessor.calculateLength((str.equals("")) ? null : str);
    return Response.status(Response.Status.OK).entity(result).build();
  }
}

