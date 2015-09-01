package biz.ideasoft.services.api;

/**
 * Created by daniel on 31/8/15.
 */

import biz.ideasoft.domain.Message;


  public interface Messenger {

    Message saySomething(String aType);
  }

