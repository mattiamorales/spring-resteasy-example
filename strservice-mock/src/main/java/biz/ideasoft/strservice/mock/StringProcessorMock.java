package biz.ideasoft.strservice.mock;

import biz.ideasoft.strservice.api.StringProcessor;
import biz.ideasoft.strservice.data.LengthResult;

/**
 * Calcula sólo para el caso "hello", en otro caso retorna length = -1.
 */
public class StringProcessorMock implements StringProcessor {

  @Override
  public LengthResult calculateLength(String str) {
    return "hello".equals(str) ? new LengthResult(str, 5) : new LengthResult(str, -1);
  }
}
