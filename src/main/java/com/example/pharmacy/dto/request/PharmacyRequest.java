package com.example.pharmacy.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
public class PharmacyRequest {
    String name;
    String address;
}
