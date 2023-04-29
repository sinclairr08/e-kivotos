package sinclairr08.ekivotosserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sinclairr08.ekivotosserver.domain.Version;
import sinclairr08.ekivotosserver.dto.VersionDto;
import sinclairr08.ekivotosserver.repository.VersionRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VersionService {
    private final VersionRepository versionRepository;

    private List<String> parseUpdates(String s) {
        return Arrays.asList(s.split("\n"));
    }

    private String sumUpdates(List<String> updates) {
        StringBuilder sb = new StringBuilder();
        for (String update: updates) {
            sb.append(update);
            sb.append("\n");
        }

        return sb.toString();
    }

    @Transactional(readOnly = true)
    public List<VersionDto> findAll() {
        List<Version> versionList = versionRepository.findAll();
        List<VersionDto> results = new ArrayList<>();

        for(Version v: versionList) {
            results.add(new VersionDto(v.getVersionString(), v.getReleaseDate(), parseUpdates(v.getUpdates())));
        }

        return results;
    }

    @Transactional
    public void save(VersionDto versionDto) {
        Version version = new Version();
        version.setVersion(versionDto.getVersionString(), versionDto.getReleaseDate(), sumUpdates(versionDto.getUpdates()));
        versionRepository.save(version);
    }
}
