package sinclairr08.ekivotosserver.repository;

import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sinclairr08.ekivotosserver.domain.Pickup;
import sinclairr08.ekivotosserver.domain.Student;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class JpaPickupRepositoryTest {
    @Autowired
    EntityManager em;

    @DisplayName("현재 픽업이 반드시 존재해야 함")
    @Test
    @Transactional(readOnly = true)
    void findCurrentTest() {
        // given
        PickupRepository pickupRepository = new JpaPickupRepository(em);

        // when
        List<Pickup> current = pickupRepository.findCurrent(LocalDate.now());

        // then
        assertThat(current.size()).isGreaterThan(0);
    }

    @DisplayName("새 픽업이 저장되어야 함")
    @Test
    void saveTest() {
        // given
        PickupRepository pickupRepository = new JpaPickupRepository(em);
        StudentRepository studentRepository = new JpaStudentRepository(em);
        int originalSize = pickupRepository.findAll().size();

        Pickup pickup = new Pickup();
        pickup.setPickup(LocalDate.parse("2900-01-01"), LocalDate.parse("2900-01-02"), studentRepository.findByName("요시미"));

        // when
        pickupRepository.save(pickup);
        int addedSize = pickupRepository.findAll().size();

        // then
        assertThat(originalSize + 1).isEqualTo(addedSize);
    }
}