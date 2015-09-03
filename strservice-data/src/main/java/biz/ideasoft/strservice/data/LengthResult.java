package biz.ideasoft.strservice.data;

public class LengthResult {

  private String content;

  private int length;

  public LengthResult(String aContent) {
    this.content = aContent;
    this.length = (content == null) ? 0 : content.length();
    }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
    this.length = (content == null) ? 0 : content.length();
  }

  public int getLength() {
    return length;
  }

  @Override
  public String toString() {
    return content + ":" + length;
  }

}
