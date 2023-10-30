package inu.thebite.toryaba.repository;

import inu.thebite.toryaba.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {

    @Query(value = "SELECT point_rslt_cd FROM tb_point WHERE sto_seq = :stoId and point_round = :round", nativeQuery = true)
    List<String> findPointsByStoIdAndRound(Long stoId, int round);

    Optional<Point> findByStoIdAndRound(Long stoId, int round);
}
