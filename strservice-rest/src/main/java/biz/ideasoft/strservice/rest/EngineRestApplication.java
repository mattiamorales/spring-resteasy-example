package biz.ideasoft.strservice.rest;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class EngineRestApplication extends Application {

  private Set<Object> singletons = new HashSet<>();

  public EngineRestApplication() {
    singletons.add(new Engine());
  }

  @Override public Set<Object> getSingletons() {
    return singletons;
  }
}

