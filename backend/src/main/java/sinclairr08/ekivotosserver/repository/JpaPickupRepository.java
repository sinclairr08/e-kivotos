package sinclairr08.ekivotosserver.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import sinclairr08.ekivotosserver.domain.Pickup;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaPickupRepository implements PickupRepository {

    private final EntityManager em;

    @Override
    public List<Pickup> findAll() {
        return em
                .createQuery("select p from Pickup p join fetch p.student", Pickup.class)
                .getResultList();
    }

    @Override
    public List<Pickup> findCurrent(LocalDate date) {
        return em
                .createQuery("select p from Pickup p where p.startDate <= :date and p.endDate > :date", Pickup.class)
                .setParameter("date", date)
                .getResultList();
    }

    @Override
    public void save(Pickup pickup) {
        em.persist(pickup);
    }
}
