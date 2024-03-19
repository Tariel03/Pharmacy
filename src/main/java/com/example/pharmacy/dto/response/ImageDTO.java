package com.example.pharmacy.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Data
@Setter
@Getter
@ToString
public class ImageDTO {
    private String name;
    private MultipartFile file;
}
