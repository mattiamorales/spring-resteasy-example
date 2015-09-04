package biz.ideasoft.strservice.data;

public class LengthResult {

  private String content;

  private int length;

  public LengthResult(String str, int length) {
    this.content = str;
    this.length = length;
    }

  public String getContent() {
    return content;
  }

  public int getLength() {
    return length;
  }

  @Override
  public String toString() {
    return content + ":" + length;
  }

}
