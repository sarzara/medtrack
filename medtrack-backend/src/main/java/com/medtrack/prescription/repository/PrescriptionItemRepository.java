package com.medtrack.prescription.repository;

import com.medtrack.prescription.domain.PrescriptionItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionItemRepository extends JpaRepository<PrescriptionItem, Long> {

}