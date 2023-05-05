package sinclairr08.ekivotosserver.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import sinclairr08.ekivotosserver.domain.Student;
import sinclairr08.ekivotosserver.domain.Version;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaStudentRepository implements StudentRepository {

    private final EntityManager em;

    @Override
    public List<Student> findAll() {
        return em
                .createQuery("select s from Student s", Student.class)
                .getResultList();
    }

    @Override
    public void save(Student student) {
        em.persist(student);
    }
}