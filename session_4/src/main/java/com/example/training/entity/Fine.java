package com.example.training.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fine")
public class Fine {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "date_issued")
    private Date dateIssued;

    @Column(name = "date_paid")
    private Date datePaid;

    @Column(name = "cancellation_deadline")
    private Date cancellationDeadline;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private FineStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "officer_id")
    private Officer officer;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;


    public void pay() {
        if (status != FineStatus.CREATED) {
            throw new IllegalStateException(
                    "Cannot pay a fine with status " + status + ". Only CREATED fines can be paid.");
        }
        this.status = FineStatus.PAID;
        this.datePaid = new Date();
    }

    public void cancel() {
        if (status != FineStatus.CREATED) {
            throw new IllegalStateException(
                    "Cannot cancel a fine with status " + status + ". Only CREATED fines can be canceled.");
        }
        this.status = FineStatus.CANCELED;
    }

    public void refund() {
        if (status != FineStatus.PAID) {
            throw new IllegalStateException(
                    "Cannot refund a fine with status " + status + ". Only PAID fines can be refunded.");
        }
        this.status = FineStatus.REFUNDED;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(Date dateIssued) {
        this.dateIssued = dateIssued;
    }

    public FineStatus getStatus() {
        return status;
    }

    public void setStatus(FineStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Officer getOfficer() {
        return officer;
    }

    public void setOfficer(Officer officer) {
        this.officer = officer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public enum FineStatus {
        CREATED, PAID, CANCELED, REFUNDED
    }
}
