package sinclairr08.ekivotosserver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sinclairr08.ekivotosserver.dto.VersionDto;
import sinclairr08.ekivotosserver.service.VersionService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
public class VersionController {
    private final VersionService versionService;

    @GetMapping(value = "/api/versions")
    public List<VersionDto> versions() {
        return versionService.findAll();
    }

}
