package inu.thebite.toryaba.repository;



import inu.thebite.toryaba.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {

    List<Class> findAllByCenterId(Long centerId);

}
