package inu.thebite.toryaba.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_sto")
public class Sto extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sto_seq", length = 11, nullable = false)
    private Long id;

    // 템플릿 번호
    @Column(name = "tmpl_seq", length = 11)
    private int templateNum;

    // 단기 목표 상태
    @Column(name = "sto_status", nullable = false, length = 3)
    private String status;

    // 단기 목표 이름
    @Column(name = "sto_name", nullable = false, length = 200)
    private String name;

    // 단기 목표 내용
    @Column(name = "sto_contents", length = 200)
    private String contents;

    // 단기 목표 시도 수
    @Column(name = "sto_trial_cnt", nullable = false, length = 11)
    private int count;

    // 단기 목표 도달 기준
    @Column(name = "sto_arr_std_cnt", nullable = false, length = 11)
    private int goal;

    // 단기 목표 준거도달기준 -> 90%로 고정 -> 데이터 format을 어떻게 할지 고민 중
    @Column(name = "sto_arr_std_pst", nullable = false, length = 11)
    private int goalPercent;

    // 단기 목표 도달 여부
    @ColumnDefault("N")
    @Column(name = "sto_arr_yn", nullable = false, length = 1)
    private int achievementOrNot;

    // 촉구 타입
    @Column(name = "sto_urge_tp_cd", length = 3)
    private String urgeType;

    // 촉구 내용
    @Column(name = "sto_urge_contents", length = 500)
    private String urgeContent;

    // 강화 내용
    @Column(name = "sto_enforce_contents", length = 500)
    private String enforceContent;

    // 메모 내용
    @Column(name = "sto_memo_contents", length = 500)
    private String memo;

    // 단기 목표 도달 일자
    @ColumnDefault("")
    @Column(name = "sto_arr_dt")
    private String hitGoalDate;

    // 등록 일자
    @Column(name = "sto_reg_dt", nullable = false)
    private String registerDate;

    // 삭제 여부
    @ColumnDefault("N")
    @Column(name = "del_yn", nullable = false, length = 1)
    private String delYN;

    @ManyToOne
    @JoinColumn(name = "lto_seq")
    private Lto lto;

    public static Sto createSto(int templateNum, String name, String content, int count, int goal, Lto lto) {
        Sto sto  = new Sto();
        sto.templateNum = templateNum;
        sto.name = name;
        sto.contents = content;
        sto.count = count;
        sto.goal = goal;
        sto.registerDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/mm/dd HH:mm:ss"));
        sto.lto = lto;
        return sto;
    }

    // update STO status when sto status is "stop" or "in progress"
    public void updateStoStatus(String status) {
        this.status = status;
    }

    // update STO status when sto status is "hit"
    public void updateStoHitStatus(String status) {
        this.status = status;
        this.hitGoalDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/mm/dd HH:mm:ss"));;
    }

    // update STO contents
    public void updateSto(String urgeType, String urgeContent, String enforceContent, String memo) {
        this.urgeType = urgeType;
        this.urgeContent = urgeContent;
        this.enforceContent = enforceContent;
        this.memo = memo;
    }

}
