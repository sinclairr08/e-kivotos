package sinclairr08.ekivotosserver.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class VersionDto {
    private String versionString;
    private LocalDate releaseDate;
    private List<String> updates;

    public VersionDto(String versionString, LocalDate releaseDate, List<String> updates) {
        this.versionString = versionString;
        this.releaseDate = releaseDate;
        this.updates = updates;
    }
}
