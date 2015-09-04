package biz.ideasoft.strservice.core;

import biz.ideasoft.strservice.api.StringProcessor;
import biz.ideasoft.strservice.data.LengthResult;

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

