package sinclairr08.ekivotosserver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sinclairr08.ekivotosserver.dto.StudentCostDto;
import sinclairr08.ekivotosserver.dto.StudentRecruitDto;
import sinclairr08.ekivotosserver.service.StudentService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/students")
@Slf4j
public class StudentController {
    private final StudentService studentService;

    @GetMapping(value = "/cost")
    public List<StudentCostDto> studentsCost() {
        return studentService.findAllCost();
    }

}
