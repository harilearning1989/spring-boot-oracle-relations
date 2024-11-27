package com.web.relations.mappers;

import com.web.relations.dtos.AddressDTO;
import com.web.relations.dtos.EmployeeDTO;
import com.web.relations.models.oTo.uni.Address;
import com.web.relations.models.oTo.uni.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapperServiceImpl implements MapperService {

    @Override
    public List<EmployeeDTO> convertEntityToDto(List<Employee> empList) {
        return List.of();
    }

    @Override
    public Employee convertToEntity(EmployeeDTO employeeDTO) {
        AddressDTO dto = employeeDTO.address();
        Address.AddressBuilder address = Address.builder();
        address.state(dto.state());
        address.city(dto.city());
        address.street(dto.street());
        address.zipcode(dto.zipcode());

        Employee.EmployeeBuilder employeeBuilder = Employee.builder();
        employeeBuilder.name(employeeDTO.name());
        employeeBuilder.department(employeeDTO.department());
        employeeBuilder.address(address.build());
        return employeeBuilder.build();
    }

    @Override
    public EmployeeDTO convertToDTO(Employee employee) {
        AddressDTO addressDTO = new AddressDTO(employee.getAddress().getId(),
                employee.getAddress().getStreet(),
                employee.getAddress().getCity(),
                employee.getAddress().getState(),
                employee.getAddress().getZipcode());

        return new EmployeeDTO(employee.getId(),
                employee.getName(),
                employee.getDepartment(),
                addressDTO
        );
    }

    @Override
    public List<EmployeeDTO> convertToDTOList(List<Employee> empList) {
        return empList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
}
