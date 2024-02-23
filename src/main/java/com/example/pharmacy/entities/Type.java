package com.example.pharmacy.entities;

import com.example.pharmacy.entities.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Table(name = "tb_type")
public class Type extends BaseEntity {
    @Column(name = "type")
    String type;
}
