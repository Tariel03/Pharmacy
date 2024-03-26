package com.example.pharmacy.entities;

import com.example.pharmacy.entities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Table(name = "tb_image")
public class Image  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

}
