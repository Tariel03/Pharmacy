package com.example.pharmacy.repositories;

import com.example.pharmacy.entities.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
    Optional<Pharmacy> findByName(String name);
    Optional<Pharmacy>findByAddress(String address);
}
