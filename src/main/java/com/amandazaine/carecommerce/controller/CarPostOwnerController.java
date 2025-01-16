package com.amandazaine.carecommerce.controller;

import com.amandazaine.carecommerce.dto.CarPostOwnerDTO;
import com.amandazaine.carecommerce.service.CarPostOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class CarPostOwnerController {

    @Autowired
    CarPostOwnerService carPostOwnerService;

    @PostMapping
    public ResponseEntity createCarPostOwner(@RequestBody CarPostOwnerDTO carPostOwnerDTO) {
        carPostOwnerService.createCarPostOwner(carPostOwnerDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
