package sinclairr08.ekivotosserver.dto;

import lombok.Getter;

import java.util.List;
import java.util.Optional;

@Getter
public class RecruitDto {
    private String type;
    private Optional<String> pickupName;
    private List<StudentRecruitDto> allProb;
    private List<StudentRecruitDto> finalProb;

    public RecruitDto(String type, List<StudentRecruitDto> allProb, List<StudentRecruitDto> finalProb) {
        this.type = type;
        this.allProb = allProb;
        this.finalProb = finalProb;
    }

    public void setPickupName(String pickupName) {
        this.pickupName = Optional.of(pickupName);
    }
}
