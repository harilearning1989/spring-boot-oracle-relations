package com.web.relations.controls;

import com.web.relations.dtos.EmployeeDTO;
import com.web.relations.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("emp")
public class EmployeeRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRestController.class);

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("findAll")
    public List<EmployeeDTO> getEmployeeList(){
        return employeeService.getEmployeeList();
    }

    @PostMapping("saveEmp")
    public EmployeeDTO saveEmp(@RequestBody EmployeeDTO employeeDTO){
        LOGGER.info("saveEmp : {}", employeeDTO);
        return employeeService.saveEmployee(employeeDTO);
    }
}
