package ru.mail.park.responseInJson;

/**
 * Created by serqeycheremisin on 27/10/2016.
 */
public class IdResponse {
  private Long userid;

  public IdResponse(Long id) {
    this.userid = id;
  }

  public void setId(Long id) {
    this.userid = id;
  }

  public Long getId() {

    return userid;
  }
}
