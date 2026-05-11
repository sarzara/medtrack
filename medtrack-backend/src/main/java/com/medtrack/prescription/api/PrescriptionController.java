package com.medtrack.prescription.api;

import com.medtrack.prescription.domain.Prescription;
import com.medtrack.prescription.domain.PrescriptionItem;
import com.medtrack.prescription.service.PrescriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping
    public ResponseEntity<Prescription> createPrescription(
            @RequestBody Prescription prescription,
            @RequestParam List<Long> medicationIds) {

        List<PrescriptionItem> items = medicationIds.stream()
                .map(medId -> {
                    PrescriptionItem item = new PrescriptionItem();
                    item.setMedicationId(medId);
                    return item;
                }).toList();

        Prescription saved = prescriptionService.createPrescription(prescription, items);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

}