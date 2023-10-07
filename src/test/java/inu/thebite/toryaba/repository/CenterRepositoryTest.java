package inu.thebite.toryaba.repository;

import inu.thebite.toryaba.entity.Center;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class CenterRepositoryTest {

    @Autowired
    private CenterRepository centerRepository;

    @Test
    @DisplayName("센터 저장")
    public void saveCenter() {
        // given
        Center center = Center.createCenter("송도점");

        // when
        Center savedCenter = centerRepository.save(center);

        // then
        Assertions.assertNotNull(savedCenter.getId());
    }

    @Test
    @DisplayName("센터 삭제")
    public void deleteCenter() {
        // given
        Center center = Center.createCenter("송도점");
        Center savedCenter = centerRepository.save(center);

        // when
        centerRepository.deleteByName(savedCenter.getName());

        // then
        List<Center> centerList = centerRepository.findAll();
        assertThat(centerList.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("센터 이름으로 조회")
    public void findCenterByName() {
        // given
        Center center = Center.createCenter("송도점");
        Center savedCenter = centerRepository.save(center);

        // when
        Center findCenter = centerRepository.findByName(savedCenter.getName()).get();

        // then
        assertThat(findCenter.getName()).isEqualTo("송도점");

    }

    @Test
    @DisplayName("센터 조회")
    public void getCenterList() {
        // given
        Center 송도점 = Center.createCenter("송도점");
        Center 부평점 = Center.createCenter("부평점");
        Center 부천점 = Center.createCenter("부천점");

        centerRepository.save(송도점);
        centerRepository.save(부평점);
        centerRepository.save(부천점);

        // when
        List<Center> centerList = centerRepository.findAll();

        // then
        assertThat(centerList.size()).isEqualTo(3);
    }

}