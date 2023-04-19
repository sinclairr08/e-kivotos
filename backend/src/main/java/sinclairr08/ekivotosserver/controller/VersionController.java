package sinclairr08.ekivotosserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sinclairr08.ekivotosserver.version.Version;
import sinclairr08.ekivotosserver.version.VersionRepository;

import java.util.List;

@RestController
public class VersionController {
    private final VersionRepository versionRepository;

    @Autowired
    public VersionController(VersionRepository versionRepository) {
        this.versionRepository = versionRepository;
    }

    @GetMapping(value = "/versionApi")
    public List<Version> versionJson() {
        return versionRepository.findAll();
    }

}
