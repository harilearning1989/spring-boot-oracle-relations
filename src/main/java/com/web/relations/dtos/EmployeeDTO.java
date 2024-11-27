package com.web.relations.dtos;

public record EmployeeDTO(
        Long id,
        String name,
        String department,
        AddressDTO address
) {
}
