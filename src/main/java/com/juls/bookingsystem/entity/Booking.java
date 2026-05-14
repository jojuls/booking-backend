package com.juls.bookingsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bookings")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String customerName;
    private String email;
    private String phone;
    private String serviceName;
    private String preferredDate;
    private String preferredTime;
    private String message;
    private String status;
}