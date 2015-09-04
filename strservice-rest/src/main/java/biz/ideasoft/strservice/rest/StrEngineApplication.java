package biz.ideasoft.strservice.rest;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class StrEngineApplication extends Application {

  private Set<Object> singletons = new HashSet<>();

  public StrEngineApplication() {
    singletons.add(new StrEngine());
  }

  @Override
  public Set<Object> getSingletons() {
    return singletons;
  }
}

