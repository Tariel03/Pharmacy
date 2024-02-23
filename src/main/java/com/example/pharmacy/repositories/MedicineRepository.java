package com.example.pharmacy.repositories;

import com.example.pharmacy.entities.Medicine;
import com.example.pharmacy.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    List<Medicine> findByType(Type type);
}
