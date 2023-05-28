package sinclairr08.ekivotosserver.repository;

import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sinclairr08.ekivotosserver.domain.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class JpaStudentRepositoryTest {
    @Autowired
    EntityManager em;

    @DisplayName("한정 캐릭터 픽업이 아닌 경우 한정 캐릭터가 선택이 되면 안됨")
    @Test
    void findNormalOrPickupTestNoPickup() {
        StudentRepository studentRepository = new JpaStudentRepository(em);
        List<String> names = new ArrayList<>();

        List<Student> normalOrPickup = studentRepository.findNormalOrPickup(names);

        for (Student student : normalOrPickup) {
            assertThat(student.getIsLimited()).isFalse();
        }
    }

    @DisplayName("한정 캐릭터 픽업인 경우 해당 한정 캐릭터만 선택돼야 함")
    @Test
    void findNormalOrPickupTestHasPickup() {
        StudentRepository studentRepository = new JpaStudentRepository(em);
        List<String> names = new ArrayList<>();
        names.add("유우카(체육복)");
        names.add("이즈나(수영복)");

        List<Student> normalOrPickup = studentRepository.findNormalOrPickup(names);

        for (Student student : normalOrPickup) {
            if (student.getIsLimited()) {
                assertThat(names).contains(student.getName());
            }
        }
    }
}