package com.example.aluswallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AlusAdmissionFee extends AppCompatActivity {
    TextView viewAll;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alus_admission_fee);

        button=findViewById(R.id.pay_now_bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),DetailsOfPayment.class);
                startActivity(intent);
            }
        });
        viewAll=findViewById(R.id.view_all_tv);

        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),FeeSummary.class);
                startActivity(intent);
            }
        });
    }
}