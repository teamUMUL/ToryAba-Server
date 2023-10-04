package inu.thebite.toryaba.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_domain")
public class Domain extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "domain_seq", length = 11, nullable = false)
    private Long id;

    // 템플릿 번호
    @Column(name = "tmpl_seq", length = 11)
    private int templateNumber;

    // 학생 번호
    @Column(name = "student_seq", length = 11)
    private int studentNumber;

    // 영역 타입
    @Column(name = "domain_tp_cd", nullable = false, length = 3)
    private String type;

    // 영역 상태
    @Column(name = "domain_status", nullable = false, length = 3)
    private String status;

    // 영역 이름
    @Column(name = "domain_name", nullable = false, length = 200)
    private String name;

    // 영역 내용
    @Column(name = "domain_content", length = 200)
    private String content;

    // 사용 여부
    @ColumnDefault("Y")
    @Column(name = "domain_use_yn", nullable = false, length = 1)
    private String useYN;

    // 삭제 여부
    @ColumnDefault("N")
    @Column(name = "del_yn", nullable = false, length = 1)
    private String deleteYN;

    // 등록 일자
    @Column(name = "domain_reg_dt", nullable = false)
    private LocalDateTime registerDate;
}
