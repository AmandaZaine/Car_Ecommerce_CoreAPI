package com.amandazaine.carecommerce.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class CarPostDTO {

    private String model;
    private String brand;
    private String price;
    private String description;
    private String engineVersion;
    private String city;
    private String createdDate;
    private Long ownerId;
    private String ownerName;
    private String ownerType;
    private String contact;

    public static List<List<String>> toListOfString(List<CarPostDTO> carPostDTOList) {
        return carPostDTOList
                .stream()
                .map(carPostDTO -> List.of(
                        carPostDTO.model,
                        carPostDTO.brand,
                        carPostDTO.price,
                        carPostDTO.description,
                        carPostDTO.engineVersion,
                        carPostDTO.city,
                        carPostDTO.createdDate,
                        carPostDTO.ownerId.toString(),
                        carPostDTO.ownerName,
                        carPostDTO.ownerType,
                        carPostDTO.contact)
                )
                .toList();
    }
}

