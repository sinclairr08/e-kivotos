package sinclairr08.ekivotosserver.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PickupDto {
    private LocalDate startDate;
    private LocalDate endDate;

    private String name;

    public PickupDto(LocalDate startDate, LocalDate endDate, String name) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
    }
}
