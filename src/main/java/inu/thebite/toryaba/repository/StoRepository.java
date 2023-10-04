package inu.thebite.toryaba.repository;

import inu.thebite.toryaba.entity.Sto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoRepository extends JpaRepository<Sto, Long> {
}
