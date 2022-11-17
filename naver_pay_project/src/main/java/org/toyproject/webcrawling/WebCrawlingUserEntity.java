package org.toyproject.webcrawling;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class WebCrawlingUserEntity {

    //User
    private String userId;
    private String userPw;
    private String userName;
    private String userPhone;
    private String userAddress;
    private int userPoint;
}
