package com.example.aluswallet;

public class PaymentHistoryClass {
    private String rupees,issuedDateTime;


    public PaymentHistoryClass(String rupees, String issuedDateTime) {
        this.rupees = rupees;
        this.issuedDateTime = issuedDateTime;

    }

    public String getRupees() {
        return rupees;
    }

    public String getIssuedDateTime() {
        return issuedDateTime;
    }



}
