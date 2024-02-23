package com.example.pharmacy.entities.base;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "created_date")
    LocalDate createdlDate;
    @Column(name = "updated_date")
    LocalDate updatedDate;
    @Column(name = "deleted_date")
    LocalDate deletedDate;

    @PrePersist
    public void prePersist(){
        createdlDate = LocalDate.now();
    }
    @PreUpdate
    public void preUpdate(){
        updatedDate = LocalDate.now();
    }
    @PreRemove()
    public void preRemove(){
        deletedDate = LocalDate.now();
    }
}
