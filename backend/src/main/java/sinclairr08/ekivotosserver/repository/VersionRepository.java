package sinclairr08.ekivotosserver.repository;

import sinclairr08.ekivotosserver.domain.Version;

import java.util.List;

public interface VersionRepository {
    List<Version> findAll();

    void save(Version version);
}
