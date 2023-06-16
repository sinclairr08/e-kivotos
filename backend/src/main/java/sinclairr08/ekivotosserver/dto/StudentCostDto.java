package sinclairr08.ekivotosserver.dto;

import lombok.Getter;

@Getter
public class StudentCostDto {
    private String name;
    private Integer cost;

    public StudentCostDto(String name, Integer cost) {
        this.name = name;
        this.cost = cost;
    }
}
