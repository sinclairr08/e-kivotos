package sinclairr08.ekivotosserver.csvReader;

import com.opencsv.CSVReader;
import org.springframework.core.io.ClassPathResource;
import sinclairr08.ekivotosserver.domain.Student;
import sinclairr08.ekivotosserver.domain.Version;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MyCsvReader {
    public static List<Version> readVersion() throws Exception {
        ClassPathResource resource = new ClassPathResource("csv/versions.csv");
        CSVReader csvReader = new CSVReader(new InputStreamReader(resource.getInputStream()));
        String[] line = csvReader.readNext();

        List<Version> csvResult = new ArrayList<>();

        while ((line = csvReader.readNext()) != null) {
            Version v = new Version();
            v.setVersion(line[0], line[1], line[2]);
            csvResult.add(v);
        }

        csvReader.close();
        return csvResult;
    }

    public static List<Student> readStudent() throws Exception {
        ClassPathResource resource = new ClassPathResource("csv/students.csv");
        CSVReader csvReader = new CSVReader(new InputStreamReader(resource.getInputStream()));
        String[] line = csvReader.readNext();

        List<Student> csvResult = new ArrayList<>();

        while ((line = csvReader.readNext()) != null) {
            Student s = new Student();
            s.setStudent(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]), Boolean.parseBoolean(line[3]));
            csvResult.add(s);
        }

        csvReader.close();
        return csvResult;
    }
}
