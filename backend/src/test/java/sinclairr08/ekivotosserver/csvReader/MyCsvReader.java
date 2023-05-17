package sinclairr08.ekivotosserver.csvReader;

import com.opencsv.CSVReader;
import org.springframework.core.io.ClassPathResource;
import sinclairr08.ekivotosserver.domain.Pickup;
import sinclairr08.ekivotosserver.domain.Student;
import sinclairr08.ekivotosserver.domain.Version;
import sinclairr08.ekivotosserver.repository.JpaPickupRepository;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MyCsvReader {
    public static List<String[]> readData(String filePath) throws Exception {
        ClassPathResource resource = new ClassPathResource(filePath);
        CSVReader csvReader = new CSVReader(new InputStreamReader(resource.getInputStream()));
        String[] line = csvReader.readNext();

        List<String[]> result = new ArrayList<String[]>();

        while ((line = csvReader.readNext()) != null) {
            result.add(line);
        }

        csvReader.close();
        return result;
    }
}
