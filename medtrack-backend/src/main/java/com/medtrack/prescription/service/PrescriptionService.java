package com.medtrack.prescription.service;


import com.medtrack.prescription.domain.Prescription;
import com.medtrack.prescription.domain.PrescriptionItem;
import com.medtrack.prescription.repository.PrescriptionRepository;
import com.medtrack.prescription.repository.PrescriptionItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final PrescriptionItemRepository prescriptionItemRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository,
                               PrescriptionItemRepository prescriptionItemRepository) {
        this.prescriptionRepository = prescriptionRepository;
        this.prescriptionItemRepository = prescriptionItemRepository;
    }
    public Prescription createPrescription(Prescription prescription,
                                           List<PrescriptionItem> items) {

        // Save prescription
        Prescription saved = prescriptionRepository.save(prescription);

        // for each item set id & save it
        for (PrescriptionItem item : items) {
            item.setPrescriptionId(saved.getId());
            prescriptionItemRepository.save(item);
        }

        // return saved prescription
        return saved;
    }
}
