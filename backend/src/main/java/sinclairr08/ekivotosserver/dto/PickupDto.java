package sinclairr08.ekivotosserver.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class PickupDto {
    private LocalDate startDate;
    private LocalDate endDate;

    private List<String> names;

    public PickupDto(LocalDate startDate, LocalDate endDate, List<String> names) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.names = names;
    }
}
