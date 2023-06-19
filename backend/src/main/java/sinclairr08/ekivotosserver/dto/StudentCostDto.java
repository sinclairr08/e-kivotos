package sinclairr08.ekivotosserver.dto;

import lombok.Getter;

@Getter
public class StudentCostDto {
    private String name;
    private String code;
    private Integer cost;

    public StudentCostDto(String name, String code, Integer cost) {
        this.name = name;
        this.code = code;
        this.cost = cost;
    }
}
