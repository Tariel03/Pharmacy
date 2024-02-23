package com.example.pharmacy.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
public class PharmacyResponse {
    String name;
    String address;
}
