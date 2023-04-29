package sinclairr08.ekivotosserver.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Entity
public class Version {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "version_id")
    private Long id;

    private String versionString;
    private String releaseDate;
    private String updates;

    public void setVersion(String versionString, String releaseDate, String updates) {
        this.versionString = versionString;
        this.releaseDate = releaseDate;
        this.updates = updates;
    }
}
