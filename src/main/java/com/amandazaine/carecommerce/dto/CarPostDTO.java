package com.amandazaine.carecommerce.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

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

    public CarPostDTO(
            String model,
            String brand,
            String price,
            String description,
            String engineVersion,
            String city,
            String createdDate,
            Long ownerId,
            String ownerName,
            String ownerType,
            String contact) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.engineVersion = engineVersion;
        this.city = city;
        this.createdDate = createdDate;
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.ownerType = ownerType;
        this.contact = contact;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}

