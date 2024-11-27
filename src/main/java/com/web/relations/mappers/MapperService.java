package com.web.relations.mappers;

import com.web.relations.dtos.EmployeeDTO;
import com.web.relations.models.oTo.uni.Employee;

import java.util.List;

public interface MapperService {
    List<EmployeeDTO> convertEntityToDto(List<Employee> empList);

    Employee convertToEntity(EmployeeDTO employeeDTO);

    EmployeeDTO convertToDTO(Employee employee);

    List<EmployeeDTO> convertToDTOList(List<Employee> empList);
}
