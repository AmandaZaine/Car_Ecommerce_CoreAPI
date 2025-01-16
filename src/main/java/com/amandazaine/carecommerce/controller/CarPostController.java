package com.amandazaine.carecommerce.controller;

import com.amandazaine.carecommerce.dto.CarPostDTO;
import com.amandazaine.carecommerce.service.CarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarPostController {

    @Autowired
    private CarPostService carPostService;

    @GetMapping("/posts")
    public ResponseEntity<List<CarPostDTO>> getAllCarPost() {
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostService.getAllCarPost());
    }

    @PutMapping("/id")
    public ResponseEntity updateCarPost(@RequestBody CarPostDTO carPost, @PathVariable("id") String id) {
        carPostService.updateCarPost(carPost, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/id")
    public ResponseEntity deleteCarPost(@PathVariable("id") String id) {
        carPostService.deleteCarPost(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


