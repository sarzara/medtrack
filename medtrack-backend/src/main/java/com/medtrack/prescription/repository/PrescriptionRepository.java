package com.medtrack.prescription.repository;

import com.medtrack.prescription.domain.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

}