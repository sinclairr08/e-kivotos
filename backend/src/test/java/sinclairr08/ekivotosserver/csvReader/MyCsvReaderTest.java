package sinclairr08.ekivotosserver.csvReader;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import sinclairr08.ekivotosserver.domain.Pickup;
import sinclairr08.ekivotosserver.domain.Student;
import sinclairr08.ekivotosserver.domain.Version;
import sinclairr08.ekivotosserver.repository.JpaPickupRepository;
import sinclairr08.ekivotosserver.repository.JpaStudentRepository;
import sinclairr08.ekivotosserver.repository.JpaVersionRepository;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
public class MyCsvReaderTest {
    @Autowired
    EntityManager em;

    public boolean compare(String filePath, int repoSize) throws Exception {
        List<String[]> csvResult = MyCsvReader.readData(filePath);
        return  csvResult.size() == repoSize;
    }

    @DisplayName("CSV 기록과 DB의 버전 내용이 일치해야 함")
    @Test
    @Transactional(readOnly = true)
    public void compareVersion() throws Exception {
        // given
        JpaVersionRepository repository = new JpaVersionRepository(em);

        // when
        boolean compareResult = compare("csv/versions.csv", repository.findAll().size());

        // then
        assertThat(compareResult).isTrue();
    }

    @DisplayName("CSV 기록과 DB의 학생 내용이 일치해야 함")
    @Test
    @Transactional(readOnly = true)
    public void compareStudent() throws Exception {
        // given
        JpaStudentRepository repository = new JpaStudentRepository(em);

        // when
        boolean compareResult = compare("csv/students.csv", repository.findAll().size());

        // then
        assertThat(compareResult).isTrue();
    }

    @DisplayName("CSV 기록과 DB의 픽업 내용이 일치해야 함")
    @Test
    @Transactional(readOnly = true)
    public void comparePickup() throws Exception {
        // given
        JpaPickupRepository repository = new JpaPickupRepository(em);

        // when
        boolean compareResult = compare("csv/pickups.csv", repository.findAll().size());

        // then
        assertThat(compareResult).isTrue();
    }

//    @Test
    @Rollback(value = false)
    public void addVersion() throws Exception {
        JpaVersionRepository repository = new JpaVersionRepository(em);

        List<String[]> csvResult = MyCsvReader.readData("csv/versions.csv");
        List<Version> repoResult = repository.findAll();

        for (int i = repoResult.size(); i < csvResult.size(); i++) {
            String[] line = csvResult.get(i);

            Version v = new Version();
            v.setVersion(line[0], LocalDate.parse(line[1]), line[2]);
            repository.save(v);
        }
    }

//    @Test
    @Rollback(value = false)
    public void addStudent() throws Exception {
        JpaStudentRepository repository = new JpaStudentRepository(em);

        List<String[]> csvResult = MyCsvReader.readData("csv/students.csv");
        List<Student> repoResult = repository.findAll();

        for (int i = repoResult.size(); i < csvResult.size(); i++) {
            String[] line = csvResult.get(i);

            assertThat(repository.findByName(line[0])).isNull();

            Student s = new Student();
            s.setStudent(line[0], line[4], Integer.parseInt(line[1]), Integer.parseInt(line[2]), Boolean.parseBoolean(line[3]));
            repository.save(s);
        }
    }

//    @Test
    @Rollback(value = false)
    public void addPickup() throws Exception {
        JpaPickupRepository repository = new JpaPickupRepository(em);
        JpaStudentRepository studentRepository = new JpaStudentRepository(em);

        List<String[]> csvResult = MyCsvReader.readData("csv/pickups.csv");
        List<Pickup> repoResult = repository.findAll();

        for (int i = repoResult.size(); i < csvResult.size(); i++) {
            String[] line = csvResult.get(i);

            assertThat(studentRepository.findByName(line[2])).isNotNull();

            Pickup p = new Pickup();
            p.setPickup(LocalDate.parse(line[0]), LocalDate.parse(line[1]), studentRepository.findByName(line[2]));
            repository.save(p);
        }
    }

}
