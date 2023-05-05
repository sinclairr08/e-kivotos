package sinclairr08.ekivotosserver.dto;

import lombok.Getter;

@Getter
public class StudentRecruitDto {
    private String name;
    private Integer star;
    private Boolean isLimited;

    public StudentRecruitDto() {
    }

    public StudentRecruitDto(String name, Integer star, Boolean isLimited) {
        this.name = name;
        this.star = star;
        this.isLimited = isLimited;
    }
}


