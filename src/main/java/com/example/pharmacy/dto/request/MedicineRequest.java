package com.example.pharmacy.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
public class MedicineRequest {

    private String name;
    private int price;
    private String form;
}
