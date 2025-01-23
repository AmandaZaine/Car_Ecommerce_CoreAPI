package com.amandazaine.carecommerce.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude
public class CarPostDTO {

    private String model;
    private String brand;
    private Double price;
    private String description;
    private String engineVersion;
    private String city;
    private String createdDate;
    private Long ownerId;

    public static List<List<String>> toListOfString(List<CarPostDTO> carPostDTOList) {
        return carPostDTOList
                .stream()
                .map(carPostDTO -> List.of(
                        carPostDTO.model,
                        carPostDTO.brand,
                        carPostDTO.price.toString(),
                        carPostDTO.description,
                        carPostDTO.engineVersion,
                        carPostDTO.city,
                        carPostDTO.createdDate,
                        carPostDTO.ownerId.toString())
                )
                .toList();
    }

    public CarPostDTO(String model, String brand, Double price, String description, String engineVersion, String city, String createdDate, Long ownerId) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.engineVersion = engineVersion;
        this.city = city;
        this.createdDate = createdDate;
        this.ownerId = ownerId;
    }

    public CarPostDTO() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEngineVersion() {
        return engineVersion;
    }

    public void setEngineVersion(String engineVersion) {
        this.engineVersion = engineVersion;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

