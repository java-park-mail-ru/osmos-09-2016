package ru.mail.park.ResponseInJson;

/**
 * Created by serqeycheremisin on 27/10/2016.
 */
public class IdResponse {
  private Integer userid;

  public IdResponse(Integer id) {
    this.userid = id;
  }

  public void setId(Integer id) {
    this.userid = id;
  }

  public Integer getId() {

    return userid;
  }
}
