package biz.ideasoft.strservice.stub.mock;

import biz.ideasoft.strservice.stub.api.StringProcessor;
import biz.ideasoft.services.domain.LengthResult;

/**
 * Calcula sólo para el caso "hello", en otro caso retorna length = -1.
 */
public class StringProcessorMock implements StringProcessor {

  @Override
  public LengthResult calculateLength(String str) {
    return "hello".equals(str) ? new LengthResult(str, 5) : new LengthResult(str, -1);
  }
}
