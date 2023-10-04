package inu.thebite.toryaba.model.member;


import inu.thebite.toryaba.entity.MemberStatus;
import lombok.Data;

@Data
public class UpdateMemberStatusRequest {

    private String id;

    private MemberStatus status;
}
