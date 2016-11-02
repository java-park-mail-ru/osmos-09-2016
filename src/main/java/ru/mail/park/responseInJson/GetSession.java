package ru.mail.park.responseInJson;

/**
 * Created by serqeycheremisin on 27/10/2016.
 */
public class GetSession {
    private Integer userid;

    public GetSession(Integer userid) {
        this.userid = userid;
    }

    public Integer getUserId() {

        return userid;
    }
}
