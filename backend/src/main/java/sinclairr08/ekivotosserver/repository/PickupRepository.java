package sinclairr08.ekivotosserver.repository;

import sinclairr08.ekivotosserver.domain.Pickup;
import sinclairr08.ekivotosserver.domain.Student;

import java.time.LocalDate;
import java.util.List;

public interface PickupRepository {
    List<Pickup> findAll();
    List<Pickup> findCurrent(LocalDate date);

    void save(Pickup pickup);
}
