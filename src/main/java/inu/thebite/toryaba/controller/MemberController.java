package inu.thebite.toryaba.controller;


import inu.thebite.toryaba.entity.Member;
import inu.thebite.toryaba.model.member.JoinMemberRequest;
import inu.thebite.toryaba.model.member.UpdateMemberStatusRequest;
import inu.thebite.toryaba.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // join member
    @PostMapping("/member/join")
    public ResponseEntity joinMember(@RequestBody JoinMemberRequest joinMemberRequest) {
        Member member = memberService.joinMember(joinMemberRequest);
        return ResponseEntity.ok(member);
    }

    // update member status

}
