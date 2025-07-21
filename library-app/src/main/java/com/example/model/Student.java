package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "students")
public class Student {
    @Id
    private String id;

    private String name;
    private Date joiningDate;
    private Date expiryDate;
    private String paymentMode;
    private String identityProof;
    // Add other fields as needed

    // Constructors
    public Student() {}

    public Student(String name, Date joiningDate, Date expiryDate, String paymentMode, String identityProof) {
        this.name = name;
        this.joiningDate = joiningDate;
        this.expiryDate = expiryDate;
        this.paymentMode = paymentMode;
        this.identityProof = identityProof;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getJoiningDate() { return joiningDate; }
    public void setJoiningDate(Date joiningDate) { this.joiningDate = joiningDate; }

    public Date getExpiryDate() { return expiryDate; }
    public void setExpiryDate(Date expiryDate) { this.expiryDate = expiryDate; }

    public String getPaymentMode() { return paymentMode; }
    public void setPaymentMode(String paymentMode) { this.paymentMode = paymentMode; }

    public String getIdentityProof() { return identityProof; }
    public void setIdentityProof(String identityProof) { this.identityProof = identityProof; }
}