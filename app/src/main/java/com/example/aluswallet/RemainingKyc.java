package com.example.aluswallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RemainingKyc extends AppCompatActivity {

    Button button,ypay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remaining_kyc);

        button=findViewById(R.id.continue_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),RemainingKycStepOne.class);
                startActivity(intent);
            }
        });
        ypay=findViewById(R.id.ypay_button2);
        ypay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market:com.android.app"));
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.android.app"));
                }
                startActivity(intent);
            }
            });
    }
}