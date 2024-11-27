package com.web.relations.services;

import com.web.relations.dtos.EmployeeDTO;
import com.web.relations.mappers.MapperService;
import com.web.relations.models.oTo.uni.pToc.Employee;
import com.web.relations.repos.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final MapperService mapperService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, MapperService mapperService) {
        this.employeeRepository = employeeRepository;
        this.mapperService = mapperService;
    }

    @Override
    public List<EmployeeDTO> getEmployeeList() {
        List<Employee> empList = employeeRepository.findAll();
        return mapperService.convertToDTOList(empList);
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = mapperService.convertToEntity(employeeDTO);
        employee = employeeRepository.save(employee);
        employeeDTO = mapperService.convertToDTO(employee);
        return employeeDTO;
    }
}
