package inu.thebite.toryaba.repository;



import inu.thebite.toryaba.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
    void deleteByClassName(String name);

    Optional<Class> findByClassName(String className);
}
