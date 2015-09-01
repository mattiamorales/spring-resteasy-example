package biz.ideasoft.domain;

public class Message {

  private String content;

  public Message(String aContent) {
    this.content = aContent;
  }

  @Override
  public String toString() {
    return content;
  }
}
