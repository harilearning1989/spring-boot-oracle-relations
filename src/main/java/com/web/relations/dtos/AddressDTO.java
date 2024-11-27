package com.web.relations.dtos;

public record AddressDTO(
        Long id,
        String street,
        String city,
        String state,
        String zipcode
) {
}
