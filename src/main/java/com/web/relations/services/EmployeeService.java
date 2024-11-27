package com.web.relations.services;

import com.web.relations.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getEmployeeList();

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
}
