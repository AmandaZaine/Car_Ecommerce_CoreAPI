package com.amandazaine.carecommerce.service.impl;

import com.amandazaine.carecommerce.client.CarPostClient;
import com.amandazaine.carecommerce.dto.CarPostOwnerDTO;
import com.amandazaine.carecommerce.service.CarPostOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarPostOwnerServiceImpl implements CarPostOwnerService {

    @Autowired
    private CarPostClient carPostClient;

    @Override
    public void createCarPostOwner(CarPostOwnerDTO ownerPostDTO) {
        carPostClient.createCarPostOwner(ownerPostDTO);
    }
}
