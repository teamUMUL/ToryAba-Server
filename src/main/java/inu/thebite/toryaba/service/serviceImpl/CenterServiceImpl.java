package inu.thebite.toryaba.service.serviceImpl;


import inu.thebite.toryaba.entity.Center;
import inu.thebite.toryaba.model.center.CenterRequest;
import inu.thebite.toryaba.repository.CenterRepository;
import inu.thebite.toryaba.service.CenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CenterServiceImpl implements CenterService {

    private final CenterRepository centerRepository;

    @Transactional
    @Override
    public Center addCenter(CenterRequest centerRequest) {
        Center center = Center.createCenter(centerRequest.getName());
        centerRepository.save(center);
        return center;
    }

    @Override
    public void deleteCenter(CenterRequest centerRequest) {

        if(centerRepository.findByCenterName(centerRequest.getName()).isPresent()) {
            throw new IllegalStateException("존재하지 않는 센터입니다.");
        } else {
            centerRepository.deleteByName(centerRequest.getName());
        }
    }
}
