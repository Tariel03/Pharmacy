package com.example.pharmacy.dto.response;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
public class MedicineResponse {
    @Column(name = "name")
    String name;
    @Column(name = "price")
    int price;
    @Column(name = "form", columnDefinition = "TEXT")
    String form;
    @Column(name = "address")
    String address;

}
