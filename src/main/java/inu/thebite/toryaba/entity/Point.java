package inu.thebite.toryaba.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_point")
@Getter
public class Point extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_seq", length = 11, nullable = false)
    private Long id;

    // 포인트 회차
    @Column(name = "point_round", length = 11)
    private int round;

    // 포인트 결과
    @Column(name = "point_rslt_cd", nullable = false)
    @ElementCollection
    private List<String> points = new ArrayList<>();

    // 등록자
    @Column(name = "point_reg_mbr_seq", length = 11, nullable = false)
    private String registrant;

    // 등록일자
    @Column(name = "point_reg_dt", nullable = false)
    private String registerDate;

    @ManyToOne
    @JoinColumn(name = "sto_seq")
    private Sto sto;

    public static Point createPoint(String registrant, Sto sto) {
        Point point = new Point();
        point.round = 1;
        point.registrant = registrant;
        point.registerDate = LocalDateTime.now(ZoneId.of("Asia/Seoul")).format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        point.sto = sto;
        return point;
    }

    public void addPoint(String point, String registrant) {
        this.points.add(point);
        this.registrant = registrant;
        this.registerDate = LocalDateTime.now(ZoneId.of("Asia/Seoul")).format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
    }

    public void updatePoint(List<String> points, String registrant) {
        this.points = points;
        this.registrant = registrant;
        this.registerDate = LocalDateTime.now(ZoneId.of("Asia/Seoul")).format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
    }
}