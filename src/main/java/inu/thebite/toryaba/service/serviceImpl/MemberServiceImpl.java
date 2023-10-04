package inu.thebite.toryaba.service.serviceImpl;

import inu.thebite.toryaba.entity.Member;
import inu.thebite.toryaba.model.member.JoinMemberRequest;
import inu.thebite.toryaba.model.member.UpdateMemberStatusRequest;
import inu.thebite.toryaba.repository.MemberRepository;
import inu.thebite.toryaba.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public Member joinMember(JoinMemberRequest joinMemberRequest) {

        // id 중복 확인
        if(memberRepository.findByMemberId(joinMemberRequest.getId()).isPresent()) {
            throw new IllegalStateException("이미 가입된 아이디 입니다.");
        }
        Member member = Member.createMember(joinMemberRequest.getId(), joinMemberRequest.getPassword(), joinMemberRequest.getName(), joinMemberRequest.getEmail(), joinMemberRequest.getPhone());
        memberRepository.save(member);
        return member;
    }

}
