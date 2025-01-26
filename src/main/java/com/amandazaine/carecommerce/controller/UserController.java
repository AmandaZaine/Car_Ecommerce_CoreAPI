package com.amandazaine.carecommerce.controller;

import com.amandazaine.carecommerce.dto.UserDTO;
import com.amandazaine.carecommerce.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserDTO userDTO) {
        LOG.info("Criando usuário via API Rest: {}", userDTO);

        userService.createUser(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
