package biz.ideasoft.strservice.stub.core;

import biz.ideasoft.strservice.stub.api.StringProcessor;
import biz.ideasoft.services.domain.LengthResult;

/**
 * Calcula el largo de un string.
 */
public class StringProcessorImpl implements StringProcessor {

  public LengthResult calculateLength(String str) {
    if (str == null) {
      return new LengthResult("", 0);
    } else {
      return new LengthResult(str, str.length());
    }
  }


}

