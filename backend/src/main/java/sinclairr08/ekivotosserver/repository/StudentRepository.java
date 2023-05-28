package sinclairr08.ekivotosserver.repository;

import sinclairr08.ekivotosserver.domain.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();

    List<Student> findNormalOrPickup(List<String> names);

    Student findByName(String name);

    void save(Student student);
}
