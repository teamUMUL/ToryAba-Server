package inu.thebite.toryaba.repository;

import inu.thebite.toryaba.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {

    @Query(value = "SELECT p.point_rslt_cd FROM tb_point t JOIN point_points p WHERE t.point_round = :round AND p.point_point_seq = :pointId", nativeQuery = true)
    List<String> findPointsByStoIdAndRound(@Param("round") int round, @Param("pointId") Long pointId);

    Optional<Point> findByStoIdAndRound(Long stoId, int round);
}
