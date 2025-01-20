package com.amandazaine.carecommerce.service.impl;

import com.amandazaine.carecommerce.client.CarPostClient;
import com.amandazaine.carecommerce.dto.CarPostDTO;
import com.amandazaine.carecommerce.service.CarPostService;
import com.amandazaine.carecommerce.ssh.SFTPBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPostServiceImpl implements CarPostService {

    @Autowired
    CarPostClient carPostStoreClient;

//    @Autowired
//    SFTPBuilder sftpBuilder;

    @Override
    public List<CarPostDTO> getAllCarPost() {
        return carPostStoreClient.getAllCarPost();
    }

    @Override
    public void updateCarPost(CarPostDTO carPost, String id) {
        carPostStoreClient.updateCarPost(carPost, id);
    }

    @Override
    public void deleteCarPost(String id) {
        carPostStoreClient.deleteCarPost(id);
    }

    @Override
    public Object generateAllCarPostReport() {



        return null;
    }
}
