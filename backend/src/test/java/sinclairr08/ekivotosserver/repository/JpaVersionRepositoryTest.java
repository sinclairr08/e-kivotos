package sinclairr08.ekivotosserver.repository;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sinclairr08.ekivotosserver.domain.Student;
import sinclairr08.ekivotosserver.domain.Version;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class JpaVersionRepositoryTest {
    @Autowired
    EntityManager em;

    @DisplayName("새 버전이 저장되어야 함")
    @Test
    void saveTest() {
        // given
        VersionRepository versionRepository = new JpaVersionRepository(em);
        int originalSize = versionRepository.findAll().size();

        Version version = new Version();
        version.setVersion("-1", LocalDate.parse("2900-01-01"), "테스트");

        // when
        versionRepository.save(version);
        int addedSize = versionRepository.findAll().size();

        // then
        assertThat(originalSize + 1).isEqualTo(addedSize);
    }
}