package inu.thebite.toryaba.repository;

import inu.thebite.toryaba.entity.Lto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LtoRepository extends JpaRepository<Lto, Long> {

    Optional<Lto> findByTemplateNum(int ltoNumber);

    // * 말고 필요한 내용만 가져올 수 있도록 수정
    @Query(value = "SELECT * FROM tb_lto WHERE domain_seq = :domainNumber", nativeQuery = true)
    List<Lto> findLtoByDomainId(int domainNumber);

    void deleteByTemplateNum(int ltoNumber);
}
