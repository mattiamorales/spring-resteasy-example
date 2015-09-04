package biz.ideasoft.strservice.api;

import biz.ideasoft.strservice.data.LengthResult;


public class StringProcessorMock implements StringProcessor {

  public LengthResult calculateLength(String str) {
    if (str == null) {
      return new LengthResult("I'm a mock object!");
    } else {
      return new LengthResult(str);
    }
  }
}

