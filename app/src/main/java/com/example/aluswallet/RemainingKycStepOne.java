package com.example.aluswallet;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.IOException;

public class RemainingKycStepOne extends AppCompatActivity {
    BottomSheetDialog bottomSheetDialog;

    ImageView imageView,back;
    private static int image_pick = 1;
    TextView textView;
    Dialog dialog;
    Button button;
    ConstraintLayout adhar,voter,passport,driving,front;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remaining_kyc_step_one);
        adhar=findViewById(R.id.aadhar_proof_constraint);
        voter=findViewById(R.id.voter_proof_constraint);
        passport=findViewById(R.id.passport_proof_constraint);
        driving=findViewById(R.id.drving_proof_constraint);




        imageView = findViewById(R.id.option_for_proof);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog = new BottomSheetDialog(RemainingKycStepOne.this, androidx.appcompat.R.style.Base_Theme_AppCompat);
                View sheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.options, null);
                bottomSheetDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                bottomSheetDialog.setContentView(sheetView);
                TextView aadhar=(TextView) bottomSheetDialog.findViewById(R.id.aadhar_tv);
                TextView voterr=(TextView) bottomSheetDialog.findViewById(R.id.voter_tv);
                TextView drivingr=(TextView) bottomSheetDialog.findViewById(R.id.driving_tv);
                TextView passportr=(TextView) bottomSheetDialog.findViewById(R.id.passport_tv);
                TextView a1=(TextView) bottomSheetDialog.findViewById(R.id.aadhar_tv);
                TextView a2=(TextView) bottomSheetDialog.findViewById(R.id.aadhar_tvv);
                TextView b1=(TextView) bottomSheetDialog.findViewById(R.id.voter_tv);
                TextView b2=(TextView) bottomSheetDialog.findViewById(R.id.voter_tvv);
                TextView c1=(TextView) bottomSheetDialog.findViewById(R.id.passport_tv);
                TextView c2=(TextView) bottomSheetDialog.findViewById(R.id.passport_tvv);
                TextView d1=(TextView) bottomSheetDialog.findViewById(R.id.driving_tv);
                TextView d2=(TextView) bottomSheetDialog.findViewById(R.id.driving_tvv);


                aadhar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       voter.setVisibility(View.GONE);
                       adhar.setVisibility(View.VISIBLE);
                       passport.setVisibility(View.GONE);
                       driving.setVisibility(View.GONE);
                        a1.setVisibility(View.GONE);
                        a2.setVisibility(View.VISIBLE);
                        b2.setVisibility(View.GONE);
                        c2.setVisibility(View.GONE);
                        d2.setVisibility(View.GONE);
                        b1.setVisibility(View.VISIBLE);
                        c1.setVisibility(View.VISIBLE);
                        d1.setVisibility(View.VISIBLE);

                    }

                });
                voterr.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        voter.setVisibility(View.VISIBLE);
                        adhar.setVisibility(View.GONE);
                        passport.setVisibility(View.GONE);
                        driving.setVisibility(View.GONE);


                        b1.setVisibility(View.GONE);
                        b2.setVisibility(View.VISIBLE);
                        c1.setVisibility(View.VISIBLE);
                        a1.setVisibility(View.VISIBLE);
                        d1.setVisibility(View.VISIBLE);
                        a2.setVisibility(View.GONE);
                        c2.setVisibility(View.GONE);
                        d2.setVisibility(View.GONE);



                    }
                });

                passportr.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        voter.setVisibility(View.GONE);
                        adhar.setVisibility(View.GONE);
                        passport.setVisibility(View.VISIBLE);
                        driving.setVisibility(View.GONE);

                        a1.setVisibility(View.VISIBLE);
                        a2.setVisibility(View.GONE);

                        b1.setVisibility(View.VISIBLE);
                        b2.setVisibility(View.GONE);
                        c1.setVisibility(View.GONE);
                        c2.setVisibility(View.VISIBLE);
                        d1.setVisibility(View.VISIBLE);
                        d2.setVisibility(View.GONE);


                    }
                });

                drivingr.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        voter.setVisibility(View.GONE);
                        adhar.setVisibility(View.GONE);
                        passport.setVisibility(View.VISIBLE);
                        driving.setVisibility(View.GONE);

                        a1.setVisibility(View.VISIBLE);
                        a2.setVisibility(View.GONE);
                        b1.setVisibility(View.VISIBLE);
                         b2.setVisibility(View.GONE);
                        c1.setVisibility(View.VISIBLE);
                        c2.setVisibility(View.GONE);
                        d1.setVisibility(View.GONE);
                        d2.setVisibility(View.VISIBLE);

                    }
                });

                bottomSheetDialog.show();
            }

        });


        front = findViewById(R.id.aadhar_front_image_layout);
        front.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(gallery,
                                "select picture"),
                        image_pick);


            }
        });
        button = findViewById(R.id.proceed_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(RemainingKycStepOne.this);
                dialog.requestWindowFeature(Window.FEATURE_LEFT_ICON);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.kvc_complete);
                Button dialogButton = (Button) dialog.findViewById(R.id.okay_btn);
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

        back = findViewById(R.id.backArrow_remaing_kvc_step_one);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RemainingKycStepOne.super.onBackPressed();
            }
        });
    }
}



