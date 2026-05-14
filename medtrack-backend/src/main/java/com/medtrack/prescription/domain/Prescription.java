package com.medtrack.prescription.domain;

@Entity
@Table(name = "prescriptions")

public class Prescription{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long patientId;
    private Long doctorId;
    private Long visitId;
    private String status;
    private LocalDateTime issueDate;
    private String notes;


    @PrePersist
    protected void onCreate(){
        createdAt = LocaldateTime.now();
        updatedAt = LocalDateTime.now();
    }
    @PreUpdate =
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Long getPatient() {
        return patient;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPatient(Long patient) {
        this.patient = patient;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}