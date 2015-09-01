package biz.ideasoft.services.core;

import biz.ideasoft.domain.Message;
import biz.ideasoft.services.api.Messenger;

/**
 * Created by daniel on 31/8/15.
 */

public class SimpleMessenger implements Messenger {

  public Message saySomething(String aType) {
    if ("hello".equalsIgnoreCase(aType)) {
      return new Message("Hello, World!");
    } else {
      return new Message("What's up?");
    }
  }
}

