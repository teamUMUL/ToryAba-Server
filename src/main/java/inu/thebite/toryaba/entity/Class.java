package inu.thebite.toryaba.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_class")
public class Class extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_seq", length = 11, nullable = false)
    private Long id;

    @Column(name = "center_seq", length = 11, nullable = false)
    private int number;

    @Column(name = "class_name", length = 45)
    private String name;
}
