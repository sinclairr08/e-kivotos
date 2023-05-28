package sinclairr08.ekivotosserver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinclairr08.ekivotosserver.dto.RecruitDto;
import sinclairr08.ekivotosserver.service.RecruitService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/recruit")
@Slf4j
public class RecruitController {
    private final RecruitService recruitService;

    @GetMapping
    public List<RecruitDto> getRecruitInfos() {
        return recruitService.getRecruits();
    }
}
