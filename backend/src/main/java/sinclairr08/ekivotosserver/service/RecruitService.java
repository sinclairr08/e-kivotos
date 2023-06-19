package sinclairr08.ekivotosserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinclairr08.ekivotosserver.domain.Pickup;
import sinclairr08.ekivotosserver.domain.Student;
import sinclairr08.ekivotosserver.dto.RecruitDto;
import sinclairr08.ekivotosserver.dto.StudentCostDto;
import sinclairr08.ekivotosserver.dto.StudentRecruitDto;
import sinclairr08.ekivotosserver.repository.PickupRepository;
import sinclairr08.ekivotosserver.repository.StudentRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecruitService {
    private final StudentRepository studentRepository;
    private final PickupRepository pickupRepository;

    @Autowired
    public RecruitService(StudentRepository studentRepository, PickupRepository pickupRepository) {
        this.studentRepository = studentRepository;
        this.pickupRepository = pickupRepository;
    }

    @Transactional(readOnly = true)
    public List<RecruitDto> getRecruits() {
        List<Pickup> currentPickups = pickupRepository.findCurrent(LocalDate.now());
        List<String> names = currentPickups.stream().map((e) -> e.getStudent().getName()).toList();
        List<Student> students = studentRepository.findNormalOrPickup(names);

        List<RecruitDto> results = new ArrayList<>();

        // 상시 모집 추가

        results.add(getNormalStudentList(students));

        // 픽업 모집 추가

        for (String name: names) {
            results.add(getPickupStudentList(students, name));
        }

        return results;
    }

    public RecruitDto getNormalStudentList(List<Student> students) {
        List<StudentRecruitDto> allProb = new ArrayList<>();
        List<StudentRecruitDto> finalProb = new ArrayList<>();

        int[] cnt = new int[4];
        double[] allPercentage = {0.0, 78.5, 18.5, 3.0};
        double[] finalPercentage = {0.0, 0.0, 97.0, 3.0};

        for (Student s: students) {
            if (s.getIsLimited()) {
                continue;
            }

            cnt[s.getStar()]++;
        }

        for (int i = 1; i <= 3; i++) {
            allPercentage[i] /= cnt[i];
            finalPercentage[i] /= cnt[i];
        }

        double currentAllProb = 0.0;
        double currentFinalProb = 0.0;

        for (Student s: students) {
            if (s.getIsLimited()) {
                continue;
            }

            currentAllProb += allPercentage[s.getStar()];
            allProb.add(new StudentRecruitDto(s.getName(), s.getCode(), s.getStar(), currentAllProb));

            if (s.getStar() == 1) {
                continue;
            }

            currentFinalProb += finalPercentage[s.getStar()];
            finalProb.add(new StudentRecruitDto(s.getName(), s.getCode(), s.getStar(), currentFinalProb));
        }

        RecruitDto recruitDto = new RecruitDto("상시 모집", allProb, finalProb);
        return recruitDto;
    };

    public RecruitDto getPickupStudentList(List<Student> students, String name) {
        List<StudentRecruitDto> allProb = new ArrayList<>();
        List<StudentRecruitDto> finalProb = new ArrayList<>();

        int[] cnt = new int[5];
        double[] allPercentage = {0.0, 78.5, 18.5, 2.3, 0.7};
        double[] finalPercentage = {0.0, 0.0, 97.0, 2.3, 0.7};

        for (Student s: students) {
            int star;
            if (s.getName().equals(name)) {
                star = 4;
            }
            else {
                star = s.getStar();
            }
            cnt[star]++;
        }

        for (int i = 1; i <= 4; i++) {
            allPercentage[i] /= cnt[i];
            finalPercentage[i] /= cnt[i];
        }

        double currentAllProb = 0.0;
        double currentFinalProb = 0.0;

        for (Student s: students) {
            int star;
            if (s.getName().equals(name)) {
                star = 4;
            }
            else {
                star = s.getStar();
            }

            currentAllProb += allPercentage[star];
            allProb.add(new StudentRecruitDto(s.getName(), s.getCode(), s.getStar(), currentAllProb));

            if (s.getStar() == 1) {
                continue;
            }

            currentFinalProb += finalPercentage[star];
            finalProb.add(new StudentRecruitDto(s.getName(), s.getCode(), s.getStar(), currentFinalProb));
        }

        RecruitDto recruitDto = new RecruitDto(name + " 픽업 모집", allProb, finalProb);
        recruitDto.setPickupName(name);
        return recruitDto;
    };

}
