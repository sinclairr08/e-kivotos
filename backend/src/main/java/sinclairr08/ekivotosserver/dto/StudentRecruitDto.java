package sinclairr08.ekivotosserver.dto;

import lombok.Getter;

@Getter
public class StudentRecruitDto {
    private String name;
    private String code;
    private Integer star;
    private Double prob;

    public StudentRecruitDto(String name, String code, Integer star, Double prob) {
        this.name = name;
        this.code = code;
        this.star = star;
        this.prob = prob;
    }
}


