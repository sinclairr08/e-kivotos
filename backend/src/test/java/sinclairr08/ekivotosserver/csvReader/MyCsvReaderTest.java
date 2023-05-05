package sinclairr08.ekivotosserver.csvReader;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import sinclairr08.ekivotosserver.domain.Student;
import sinclairr08.ekivotosserver.domain.Version;
import sinclairr08.ekivotosserver.repository.JpaStudentRepository;
import sinclairr08.ekivotosserver.repository.JpaVersionRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
public class MyCsvReaderTest {
    @Autowired
    EntityManager em;

    @Test
    public void versionCompareTest() throws Exception {
        //given
        JpaVersionRepository repository = new JpaVersionRepository(em);

        //when
        List<Version> csvResult = MyCsvReader.readVersion();
        List<Version> result = repository.findAll();

        //then
        assertThat(csvResult.size()).isEqualTo(result.size());
    }

    @Test
    public void studentCompareTest() throws Exception {
        //given
        JpaStudentRepository repository = new JpaStudentRepository(em);

        //when
        List<Student> csvResult = MyCsvReader.readStudent();
        List<Student> result = repository.findAll();

        //then
        assertThat(csvResult.size()).isEqualTo(result.size());

        for (int i = result.size(); i < csvResult.size(); i++) {
            repository.save(csvResult.get(i));
        }
    }

//    @Test
    @Rollback(value = false)
    public void addVersion() throws Exception {
        JpaVersionRepository repository = new JpaVersionRepository(em);

        List<Version> csvResult = MyCsvReader.readVersion();
        List<Version> result = repository.findAll();

        if (csvResult.size() < result.size()) {
            return;
        }

        for (int i = result.size(); i < csvResult.size(); i++) {
            repository.save(csvResult.get(i));
        }
    }

//    @Test
    @Rollback(value = false)
    public void addStudent() throws Exception {
        JpaStudentRepository repository = new JpaStudentRepository(em);

        List<Student> csvResult = MyCsvReader.readStudent();
        List<Student> result = repository.findAll();

        if (csvResult.size() < result.size()) {
            return;
        }

        for (int i = result.size(); i < csvResult.size(); i++) {
            repository.save(csvResult.get(i));
        }
    }

}
