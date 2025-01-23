package com.amandazaine.carecommerce.service.impl;

import com.amandazaine.carecommerce.client.CarPostClient;
import com.amandazaine.carecommerce.dto.UserDTO;
import com.amandazaine.carecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private CarPostClient carPostClient;

    @Override
    public void createUser(UserDTO userDTO) {
        carPostClient.createUser(userDTO);
    }
}
