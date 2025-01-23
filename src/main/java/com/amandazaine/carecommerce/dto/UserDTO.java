package com.amandazaine.carecommerce.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude
public class UserDTO {
    private String name;
    private String type;
    private String phone;

    public UserDTO() {
    }

    public UserDTO(String name, String type, String phone) {
        this.name = name;
        this.type = type;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
