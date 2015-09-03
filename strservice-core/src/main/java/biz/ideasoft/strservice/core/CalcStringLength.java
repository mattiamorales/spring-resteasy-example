package biz.ideasoft.strservice.core;

import biz.ideasoft.strservice.data.LengthResult;
import biz.ideasoft.strservice.api.StringProcessor;

public class CalcStringLength implements StringProcessor {

  public LengthResult calculateLength(String aType) {
    if (aType == null) {
      return new LengthResult("Hello, World!");
    } else {
      return new LengthResult(aType);
    }
  }
}

