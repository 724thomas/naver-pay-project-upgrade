package org.toyproject.webcrawling;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WebCrawlingUserEntity {

    //User
    private String userId;
    private String userPw;
    private String userName;
    private String userPhone;
    private String userAddress;
    private int userPoint;
}
