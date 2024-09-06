package com.medicalclinic.api.domain.address;

import jakarta.persistence.Column;

public class AddressDTO {

    private Long id;
    private String postalCode;
    private String streetAddress;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String ibgeCode;
    private String areaCode;

    public AddressDTO(){}

    public AddressDTO(Long id, String postalCode, String streetAddress, String complement, String neighborhood, String city, String state, String ibgeCode, String areaCode) {
        this.id = id;
        this.postalCode = postalCode;
        this.streetAddress = streetAddress;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.ibgeCode = ibgeCode;
        this.areaCode = areaCode;
    }

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.postalCode = address.getPostalCode();
        this.streetAddress = address.getStreetAddress();
        this.complement = address.getComplement();
        this.neighborhood = address.getNeighborhood();
        this.city = address.getCity();
        this.state = address.getState();
        this.ibgeCode = address.getIbgeCode();
        this.areaCode = address.getAreaCode();
    }
}
