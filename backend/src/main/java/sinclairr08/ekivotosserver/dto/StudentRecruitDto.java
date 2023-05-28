package sinclairr08.ekivotosserver.dto;

import lombok.Getter;

@Getter
public class StudentRecruitDto {
    private String name;
    private Integer star;
    private Double prob;

    public StudentRecruitDto() {
    }

    public StudentRecruitDto(String name, Integer star, Double prob) {
        this.name = name;
        this.star = star;
        this.prob = prob;
    }
}


