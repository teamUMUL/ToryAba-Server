package inu.thebite.toryaba.service;

import inu.thebite.toryaba.entity.Member;
import inu.thebite.toryaba.model.member.JoinMemberRequest;
import inu.thebite.toryaba.model.member.UpdateMemberStatusRequest;

public interface MemberService {
    Member joinMember(JoinMemberRequest joinMemberRequest);

}
