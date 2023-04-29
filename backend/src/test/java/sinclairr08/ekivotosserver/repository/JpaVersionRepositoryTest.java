package sinclairr08.ekivotosserver.repository;

import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sinclairr08.ekivotosserver.domain.Version;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class JpaVersionRepositoryTest {
    @Autowired
    EntityManager em;

    @Test
    public void jpaVersionRepositoryTest() throws Exception{
        JpaVersionRepository repository = new JpaVersionRepository(em);

        List<Version> result = repository.findAll();

        assertThat(result.size()).isGreaterThan(0);
        assertThat(result.get(0).getUpdates().length()).isGreaterThan(0);
    }
}
