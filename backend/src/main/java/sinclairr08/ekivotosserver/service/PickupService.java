package sinclairr08.ekivotosserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinclairr08.ekivotosserver.domain.Pickup;
import sinclairr08.ekivotosserver.domain.Student;
import sinclairr08.ekivotosserver.dto.PickupDto;
import sinclairr08.ekivotosserver.dto.StudentCostDto;
import sinclairr08.ekivotosserver.dto.StudentRecruitDto;
import sinclairr08.ekivotosserver.repository.PickupRepository;
import sinclairr08.ekivotosserver.repository.StudentRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PickupService {
    private final PickupRepository pickupRepository;

    @Transactional(readOnly = true)
    public List<PickupDto> findCurrentPickup() {
        List<Pickup> pickups = pickupRepository.findCurrent(LocalDate.now());
        List<PickupDto> results = new ArrayList<>();

        for (Pickup pickup : pickups) {
            results.add(new PickupDto(pickup.getStartDate(), pickup.getEndDate(), pickup.getStudent().getName()));
        }

        return results;
    }

    @Transactional(readOnly = true)
    public List<PickupDto> findAll() {
        List<Pickup> pickups = pickupRepository.findAll();
        List<PickupDto> results = new ArrayList<>();

        for (Pickup pickup : pickups) {
            results.add(new PickupDto(pickup.getStartDate(), pickup.getEndDate(), pickup.getStudent().getName()));
        }

        return results;
    }

}
