package inu.thebite.toryaba.repository;

import inu.thebite.toryaba.entity.Sto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoRepository extends JpaRepository<Sto, Long> {

    @Query(value = "SELECT * FROM tb_sto WHERE lto_seq = :ltoNumber", nativeQuery = true)
    List<Sto> findByLtoSeq(int ltoNumber);

    Optional<Sto> findByTemplateNum(int stoNumber);

    void deleteByTemplateNum(int stoNumber);
}
