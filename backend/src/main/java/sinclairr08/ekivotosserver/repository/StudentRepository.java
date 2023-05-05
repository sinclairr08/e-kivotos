package sinclairr08.ekivotosserver.repository;

import sinclairr08.ekivotosserver.domain.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();

    void save(Student student);
}
