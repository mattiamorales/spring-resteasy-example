package biz.ideasoft.services.rest;

/**
 * Created by daniel on 31/8/15.
 */

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class CommunicatorApplication extends Application {

  private Set<Object> singletons = new HashSet<Object>();

  public CommunicatorApplication() {
    singletons.add(new Communicator());
  }

  @Override public Set<Object> getSingletons() {
    return singletons;
  }
}

