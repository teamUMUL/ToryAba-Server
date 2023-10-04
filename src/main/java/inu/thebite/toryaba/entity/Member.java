package inu.thebite.toryaba.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_member")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_seq", length = 11, nullable = false)
    private Long id;

    @Column(name = "member_id", length = 11, nullable = false)
    private String member_id;

    @Column(name = "member_pw", length = 45, nullable = false)
    private String password;

    @Column(name = "member_name", length = 45, nullable = false)
    private String name;

    @Column(name = "member_email", length = 45)
    private String email;

    @Column(name = "member_cp", length = 11)
    private String phone;

    @Column(name = "member_auth_cd", length = 6)
    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @ColumnDefault("N")
    @Column(name = "member_approval_yn", length = 1)
    private String approvalYN;

    @Column(name = "member_reg_dt")
    private String registerDate;

    public static Member createMember(String member_id, String password, String name, String email, String phone) {
        Member member = new Member();
        member.member_id = member_id;
        member.password = password;
        member.name = name;
        member.email = email;
        member.phone = phone;
        member.status = MemberStatus.LEVEL1;        // default setting -> 나중에 case 별로 구분 필요
        member.registerDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        return member;
    }

}
