package com.example.aluswallet;

public class PaymentRequestTwo {
    private String rupees,issuedDateTime,dueDate,admission;


    public PaymentRequestTwo(String rupees, String issuedDateTime, String dueDate,String admission) {
        this.rupees = rupees;
        this.issuedDateTime = issuedDateTime;
        this.dueDate = dueDate;
        this.admission = admission;
    }

    public String getRupees() {
        return rupees;
    }

    public String getIssuedDateTime() {
        return issuedDateTime;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getAdmission() {
        return admission;
    }

}
