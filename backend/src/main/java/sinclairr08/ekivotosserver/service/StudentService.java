package sinclairr08.ekivotosserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinclairr08.ekivotosserver.domain.Student;
import sinclairr08.ekivotosserver.dto.StudentCostDto;
import sinclairr08.ekivotosserver.dto.StudentRecruitDto;
import sinclairr08.ekivotosserver.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional(readOnly = true)
    public List<StudentCostDto> findAllCost() {
        List<Student> students = studentRepository.findAll();
        List<StudentCostDto> results = new ArrayList<>();

        for(Student s: students) {
            results.add(new StudentCostDto(s.getName(), s.getCost()));
        }
        return results;
    }

    @Transactional(readOnly = true)
    public List<StudentRecruitDto> findAllRecruit() {
        List<Student> students = studentRepository.findAll();
        List<StudentRecruitDto> results = new ArrayList<>();

        for(Student s: students) {
            results.add(new StudentRecruitDto(s.getName(), s.getStar(), s.getIsLimited()));
        }
        return results;
    }

}
