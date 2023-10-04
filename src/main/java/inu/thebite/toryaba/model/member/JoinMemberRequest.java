package inu.thebite.toryaba.model.member;

import lombok.Data;

@Data
public class JoinMemberRequest {

    private String id;

    private String password;

    private String name;

    private String email;

    private String phone;
}
