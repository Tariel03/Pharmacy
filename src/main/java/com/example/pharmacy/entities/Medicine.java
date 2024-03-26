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
@Table(name = "tb_medicine")
public class Medicine extends BaseEntity {
    @Column(name = "name")
    String name;
    @Column(name = "price")
    int price;
    @Column(name = "form", columnDefinition = "TEXT")
    String form;
    @Column(name = "address")
    String address;
    @JoinColumn(name = "pharmacy_id")
    @ManyToOne
    Pharmacy pharmacy;
    @JoinColumn(name = "type_id")
    @ManyToOne
    Type type;
    @JoinColumn(name = "image_id")
    @ManyToOne
    Image image;





}
