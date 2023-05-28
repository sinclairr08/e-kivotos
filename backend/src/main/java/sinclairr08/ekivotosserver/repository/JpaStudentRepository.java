package sinclairr08.ekivotosserver.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import sinclairr08.ekivotosserver.domain.Student;

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
    public List<Student> findNormalOrPickup(List<String> names) {
        return em
                .createQuery("select s from Student s where s.isLimited = FALSE or s.name in :names", Student.class)
                .setParameter("names", names)
                .getResultList();
    }

    @Override
    public Student findByName(String name) {
        List<Student> resultList = em
                .createQuery("select s from Student s where s.name=:name", Student.class)
                .setParameter("name", name)
                .getResultList();

        if (resultList.size() == 0) {
            return null;
        }

        return resultList.get(0);
    }

    @Override
    public void save(Student student) {
        em.persist(student);
    }
}
