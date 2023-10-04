package inu.thebite.toryaba.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_lto")
public class Lto extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lto_seq", length = 11, nullable = false)
    private Long id;

    // 템플릿 번호
    @Column(name = "tmpl_seq", length = 11)
    private int templateNum;

    // 장기 목표 상태
    @Column(name = "lto_status", nullable = false, length = 3)
    private String status;

    // 장기 목표 이름
    @Column(name = "lto_name", nullable = false, length = 200)
    private String name;

    // 장기 목표 내용
    @Column(name = "lto_contents", length = 200)
    private String content;

    // 장기 목표 도달 일자
    @Column(name = "lto_arr_dt")
    private String achieveDate;

    // 등록 일자
    @Column(name = "lto_reg_dt", nullable = false)
    private String registerDate;

    // 삭제 여부
    @Column(name = "del_yn", nullable = false, length = 1)
    private String delYN;

    @ManyToOne
    @JoinColumn(name = "domain_seq")
    private Domain domain;

    public static Lto createLto(int templateNum, String name, String content, Domain domain) {
        Lto lto = new Lto();
        lto.templateNum = templateNum;
        lto.status = "Ready";
        lto.name = name;
        lto.content = content;
        lto.achieveDate = "Not yet";
        lto.registerDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/mm/dd HH:mm:ss"));
        lto.delYN = "N";
        lto.domain = domain;
        return lto;
    }

    public void updateLtoStatus(String status) {
        this.status = status;
    }
}
