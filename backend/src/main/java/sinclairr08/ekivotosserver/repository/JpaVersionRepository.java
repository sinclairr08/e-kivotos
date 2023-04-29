package sinclairr08.ekivotosserver.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import sinclairr08.ekivotosserver.domain.Version;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaVersionRepository implements VersionRepository {

    private final EntityManager em;

    @Override
    public List<Version> findAll() {
        return em
                .createQuery("select v from Version v", Version.class)
                .getResultList();
    }

    @Override
    public void save(Version version) {
        em.persist(version);
    }
}
