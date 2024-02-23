package com.example.pharmacy.dto.response;

import lombok.Data;

@Data
public class MedicineResponse {
    String name;
    String form;
    int price;
    String type;
    String address;
    String pharmacy;


}
