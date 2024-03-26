package com.example.pharmacy.entities.base;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Date;

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
    @CreationTimestamp
    @Column(name = "created_time")
    private LocalDate createdTime;

    @UpdateTimestamp
    @Column(name = "updated_time")
    private LocalDate updatedTime;
    @Column(name = "deleted_date")
    LocalDate deletedDate;

    @PrePersist
    public void prePersist(){
        createdTime = LocalDate.now();
    }
    @PreUpdate
    public void preUpdate(){
        updatedTime = LocalDate.now();
    }
    @PreRemove()
    public void preRemove(){
        deletedDate = LocalDate.now();
    }
}
