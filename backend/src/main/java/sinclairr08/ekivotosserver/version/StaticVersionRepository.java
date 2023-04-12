package sinclairr08.ekivotosserver.version;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class StaticVersionRepository implements VersionRepository {
    private JSONParser parser;
    private JSONArray jsonArray;

    public StaticVersionRepository() throws Exception {
        this.parser = new JSONParser();

        ClassPathResource resource = new ClassPathResource("versionDB.json");
        Reader reader = new FileReader(resource.getFile());

        this.jsonArray = (JSONArray) parser.parse(reader);
    }

    @Override
    public List<Version> findAll() {
        List<Version> versionList = new ArrayList<>();

        for (var arrayElement : this.jsonArray) {
            JSONObject obj = (JSONObject) arrayElement;

            String versionString = (String) obj.get("versionString");
            String releaseDate = (String) obj.get("releaseDate");
            JSONArray updateArr = (JSONArray) obj.get("updates");

            List<String> updates = new ArrayList<>();

            for (var updateArrElement: updateArr) {
                updates.add((String) updateArrElement);
            }

            Version version = new Version(versionString, releaseDate, updates);

            versionList.add(version);
        }

        return versionList;
    }
}
