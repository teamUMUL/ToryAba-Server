package inu.thebite.toryaba.repository;

import inu.thebite.toryaba.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {

    @Query(value = "SELECT point_rslt_cd FROM tb_point WHERE sto_seq = :stoId and student_seq = :studentId and point_round = :round", nativeQuery = true)
    List<String> findByStudentIdAndStoIdAndRound(Long stoId, Long studentId, int round);
}
