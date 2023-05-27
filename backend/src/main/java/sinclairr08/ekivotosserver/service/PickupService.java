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
    public PickupDto findCurrent() {
        List<Pickup> pickups = pickupRepository.findCurrent(LocalDate.now());
        List<String> names = new ArrayList<>();

        LocalDate startDate = pickups.get(0).getStartDate();
        LocalDate endDate = pickups.get(0).getEndDate();

        for (Pickup pickup : pickups) {
            names.add(pickup.getStudent().getName());
        }

        return new PickupDto(startDate, endDate, names);
    }

    @Transactional(readOnly = true)
    public List<PickupDto> findAll() {
        List<Pickup> pickups = pickupRepository.findAll();
        List<PickupDto> results = new ArrayList<>();
        List<String> names = new ArrayList<>();
        LocalDate prevStart = pickups.get(0).getStartDate();
        LocalDate prevEnd = pickups.get(0).getEndDate();

        for (Pickup pickup: pickups) {
            LocalDate currentStart = pickup.getStartDate();
            LocalDate currentEnd = pickup.getEndDate();
            String currentName = pickup.getStudent().getName();

            if (!prevStart.equals(currentStart)) {
                results.add(new PickupDto(prevStart, prevEnd, names));
                names = new ArrayList<>();

                prevStart = currentStart;
                prevEnd = currentEnd;
            }

            names.add(currentName);
        }

        results.add(new PickupDto(prevStart, prevEnd, names));
        return results;
    }

}
