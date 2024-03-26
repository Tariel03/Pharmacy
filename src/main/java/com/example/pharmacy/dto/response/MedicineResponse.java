package com.example.pharmacy.dto.response;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Data
@Getter
@Setter
public class MedicineResponse {
    private String name;
    private int price;
    private String form;
    private String address;
    @Column(name = "url")
    private String url;
}

