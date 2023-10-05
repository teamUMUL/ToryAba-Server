package inu.thebite.toryaba.service.serviceImpl;

import inu.thebite.toryaba.entity.Center;
import inu.thebite.toryaba.model.center.CenterRequest;
import inu.thebite.toryaba.repository.CenterRepository;
import inu.thebite.toryaba.service.CenterService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class CenterServiceImplTest {

    @InjectMocks
    private CenterServiceImpl centerService;

    @Mock
    private CenterRepository centerRepository;

    @Test
    @DisplayName("센터 저장")
    public void saveCenter() {
        // given
        CenterRequest centerRequest = new CenterRequest();
        centerRequest.setName("송도점");

        Center center = Center.createCenter("송도점");
        given(centerRepository.save(any())).willReturn(center);

        // when
        Center savedCenter = centerService.addCenter(centerRequest);

        // then
        assertThat(savedCenter.getName()).isEqualTo("송도점");
        then(centerRepository).should(times(1)).save(any());
    }

    @Test
    @DisplayName("센터 조회")
    public void getCenterList() {
        // given
        CenterRequest centerRequest = new CenterRequest();
        centerRequest.setName("송도점");
        Center center = Center.createCenter("송도점");
        given(centerRepository.save(any())).willReturn(center);
        centerService.addCenter(centerRequest);
        centerRequest.setName("부평점");
        Center center2 = Center.createCenter("부평점");
        given(centerRepository.save(any())).willReturn(center2);
        centerService.addCenter(centerRequest);

        // when
        List<Center> centerList = centerService.getCenterList();

        // then
        assertThat(centerList.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("센터 삭제")
    public void deleteCenter() {
        // given
        CenterRequest centerRequest = new CenterRequest();
        centerRequest.setName("송도점");

        Center center = Center.createCenter("송도점");
        given(centerRepository.save(any())).willReturn(center);
        centerService.addCenter(centerRequest);

        // when
        centerService.deleteCenter(centerRequest);

        // then
        List<Center> result = centerRepository.findAll();
        assertThat(result).isEmpty();
    }
}