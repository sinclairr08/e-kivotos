package sinclairr08.ekivotosserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"https://sinclairr08.github.io", "http://localhost:8008"})
@Controller
public class VersionController {
    private List<Map<String, Object>> versions = new ArrayList<>();
    public VersionController() {
        addVersion("0.1.0", "2023-02-28", new String[]{"인게임 코스트 바 구현", "배속, 자동 스킬 사용, 수동 스킬 사용, 코스트 회복 및 사용 기능 구현"});
        addVersion("0.2.0", "2023-04-01", new String[]{"라우팅 기능 구현, 헤더 추가", "main 페이지 및 cost 페이지 분리", "이름 변경 (mollu-simulator -> e-kivotos)"} );
        addVersion("1.0.0", "2023-04-03", new String[]{"백엔드 서버 추가", "version 페이지 및 API 추가"} );
        addVersion("1.0.1", "2023-04-04", new String[]{"404 문제 임시 해결"} );
    }

    private void addVersion(String version, String releaseDate, String[] texts) {
        Map<String, Object> v = new HashMap<>();
        List<String> w = new ArrayList<>();

        v.put("version", version);
        v.put("releaseDate", releaseDate);

        for (String text: texts) {
            w.add(text);
        }

        v.put("text", w);

        versions.add(v);
    }

    @GetMapping(value = "/versions")
    @ResponseBody
    public List<Map<String, Object>> versionJson() {
        return versions;
    }

}
