package com.example.pharmacy.entities;

import com.example.pharmacy.entities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Table(name = "tb_pharmacy")
public class Pharmacy extends BaseEntity {
    @Column(name = "name", unique = true)
    String name;
    @Column(name = "address", unique = true)
    String address;
    @JoinColumn(name = "image_id")
    @ManyToOne
    Image image;
}
