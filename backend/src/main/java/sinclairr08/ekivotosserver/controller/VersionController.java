package sinclairr08.ekivotosserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sinclairr08.ekivotosserver.version.Version;
import sinclairr08.ekivotosserver.version.VersionRepository;

import java.util.List;

@CrossOrigin(origins = {"https://sinclairr08.github.io", "http://localhost:23908"})
@Controller
public class VersionController {
    private final VersionRepository versionRepository;

    @Autowired
    public VersionController(VersionRepository versionRepository) {
        this.versionRepository = versionRepository;
    }

    @GetMapping(value = "/versions")
    @ResponseBody
    public List<Version> versionJson() {
        return versionRepository.findAll();
    }

}
