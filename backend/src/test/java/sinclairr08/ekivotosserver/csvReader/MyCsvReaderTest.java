package sinclairr08.ekivotosserver.csvReader;

import jakarta.persistence.EntityManager;
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

    @Test
    public void compareVersion() throws Exception {
        //given
        JpaVersionRepository repository = new JpaVersionRepository(em);

        //when
        List<String[]> csvResult = MyCsvReader.readData("csv/versions.csv");
        List<Version> repoResult = repository.findAll();

        //then
        assertThat(csvResult.size()).isEqualTo(repoResult.size());
    }

    @Test
    public void compareStudent() throws Exception {
        //given
        JpaStudentRepository repository = new JpaStudentRepository(em);

        //when
        List<String[]> csvResult = MyCsvReader.readData("csv/students.csv");
        List<Student> repoResult = repository.findAll();

        //then
        assertThat(csvResult.size()).isEqualTo(repoResult.size());
    }

    @Test
    public void comparePickup() throws Exception {
        //given
        JpaPickupRepository repository = new JpaPickupRepository(em);

        //when
        List<String[]> csvResult = MyCsvReader.readData("csv/pickups.csv");
        List<Pickup> repoResult = repository.findAll();

        //then
        assertThat(csvResult.size()).isEqualTo(repoResult.size());
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
            v.setVersion(line[0], line[1], line[2]);
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
            s.setStudent(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]), Boolean.parseBoolean(line[3]));
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
