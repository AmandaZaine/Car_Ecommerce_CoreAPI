package com.amandazaine.carecommerce.service;

import com.amandazaine.carecommerce.dto.CarPostDTO;

import java.util.List;

public interface CarPostService {
    List<CarPostDTO> getAllCarPost();
    void updateCarPost(CarPostDTO carPost, String id);
    void deleteCarPost(String id);
}
