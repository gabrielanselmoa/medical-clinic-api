package com.medicalclinic.api.controllers;

import com.medicalclinic.api.domain.address.Address;
import com.medicalclinic.api.domain.address.AddressDTO;
import com.medicalclinic.api.exceptions.EntityNotFoundException;
import com.medicalclinic.api.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private AddressService service;

    @Autowired
    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> findById(@PathVariable Long id) throws EntityNotFoundException {
        AddressDTO addressDTO = service.findById(id);
        return ResponseEntity.ok().body(addressDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping
//    public ResponseEntity<Page<ProductMinDTO>> findAllProducts(
//            @RequestParam(name = "name", defaultValue = "") String name,
//            @RequestParam(name = "category", defaultValue = "") String category,
//            @PageableDefault(size = 20) Pageable pageable)
//    {
//        Page<ProductMinDTO> productMinDTOS = productService.findAllProducts(name, category, pageable);
//
//        return ResponseEntity.ok(productMinDTOS);
//    }


}
