package biz.ideasoft.strservice.core;

import biz.ideasoft.strservice.api.StringProcessor;
import biz.ideasoft.strservice.data.LengthResult;

public class CalcStringLength implements StringProcessor {

  public LengthResult calculateLength(String str) {
    if (str == null) {
      return new LengthResult("Hello, World!");
    } else {
      return new LengthResult(str);
    }
  }
}

