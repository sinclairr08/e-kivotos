package sinclairr08.ekivotosserver.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class VersionDto {
    private String versionString;
    private String releaseDate;
    private List<String> updates;

    public VersionDto() {
    }

    public VersionDto(String versionString, String releaseDate, List<String> updates) {
        this.versionString = versionString;
        this.releaseDate = releaseDate;
        this.updates = updates;
    }
}