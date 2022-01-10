package com.example.aluswallet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class DetailsOfPayment extends AppCompatActivity {
    Button button;
    Dialog mdialog;
    ImageView back;
    EditText c1;


    private TextView upi, other;
    BottomSheetDialog mBottomSheetDialog;
    View sheetView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_of_payment);


        mdialog=new Dialog(DetailsOfPayment.this);
        mdialog.requestWindowFeature(Window.FEATURE_LEFT_ICON);

        mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mdialog.setContentView(R.layout.email);
        Button next=mdialog.findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c1 = (EditText) mdialog.findViewById(R.id.editTextTextPersonEmail);

                if (c1.getText().toString().isEmpty()) {
                    Toast.makeText(DetailsOfPayment.this, "email", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(DetailsOfPayment.this, ":)", Toast.LENGTH_LONG).show();


                    mdialog.dismiss();
                    mBottomSheetDialog = new BottomSheetDialog(DetailsOfPayment.this, androidx.appcompat.R.style.Base_Theme_AppCompat);
                    sheetView = getLayoutInflater().inflate(R.layout.payment_option, null);
                    mBottomSheetDialog.setContentView(sheetView);
                    upi = sheetView.findViewById(R.id.upi_tv);
                    other = sheetView.findViewById(R.id.other_tv);
                    upi.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Dialog dialog = new Dialog(DetailsOfPayment.this);
                            dialog.requestWindowFeature(Window.FEATURE_LEFT_ICON);
                            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                            dialog.setCancelable(false);
                            dialog.setContentView(R.layout.payment_succesfull_dialog);
                            Button dialogButton = (Button) dialog.findViewById(R.id.back_to_home_button);
                            dialogButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    
                                    Intent intent = new Intent(getApplicationContext(), AlusAdmissionFee.class);
                                    startActivity(intent);
                                }
                            });
                            dialog.show();
                        }
                    });
                    other.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mBottomSheetDialog.dismiss();
                        }
                    });
                    mBottomSheetDialog.setContentView(sheetView);
                    mBottomSheetDialog.show();
                }

            }
        });

        ImageView cancel=(ImageView)mdialog.findViewById(R.id.cancel_imageView_email);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdialog.dismiss();
            }
        });


        button = findViewById(R.id.pay_now_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdialog.show();
            }
        });


    }
}