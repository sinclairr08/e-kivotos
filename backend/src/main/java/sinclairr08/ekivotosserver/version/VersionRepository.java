package sinclairr08.ekivotosserver.version;

import java.util.List;

public interface VersionRepository {
    List<Version> findAll();
}
