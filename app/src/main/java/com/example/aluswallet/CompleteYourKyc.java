package com.example.aluswallet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CompleteYourKyc extends AppCompatActivity  {



    Button button;
    ImageView back;
    EditText nameText,number,dob,emailText,c1,c2,c3,c4,c5,c6;
    AutoCompleteTextView gender,relation;

    TextView sendotp,verfied;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_your_kyc);


        button = findViewById(R.id.proceed_button);

        nameText = findViewById(R.id.name_editText);
        number = findViewById(R.id.number);
        gender = findViewById(R.id.linearLayout_gender);
        dob = findViewById(R.id.linearLayout_dob);
        emailText = findViewById(R.id.email_editText);
        relation = findViewById(R.id.relation_db);
        verfied=findViewById(R.id.verifeid);

//DATE PICKKER

        Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                updateCalendar();
            }
            private void updateCalendar(){
                String Formate="mm/dd/yy";
                SimpleDateFormat sdf=new SimpleDateFormat(Formate, Locale.US);
                dob.setText(sdf.format(calendar.getTime()));

            }
        };
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(CompleteYourKyc.this,date,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        // for dialog
        sendotp=findViewById(R.id.send_otp);
        sendotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(CompleteYourKyc.this);
                dialog.requestWindowFeature(Window.FEATURE_LEFT_ICON);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                dialog.setCancelable(false);
                dialog.setContentView(R.layout.dialog_otp);
                Button dialogButton = (Button) dialog.findViewById(R.id.verify_button);
                c1 = (EditText) dialog.findViewById(R.id.code1);
                c2 = (EditText) dialog.findViewById(R.id.code2);
                c3 = (EditText) dialog.findViewById(R.id.code3);
                c4 = (EditText) dialog.findViewById(R.id.code4);
                c5 = (EditText) dialog.findViewById(R.id.code5);
                c6 = (EditText) dialog.findViewById(R.id.code6);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!c1.getText().toString().isEmpty() && !c2.getText().toString().isEmpty() &&
                                !c3.getText().toString().isEmpty() && !c4.getText().toString().isEmpty() &&
                                !c5.getText().toString().isEmpty() && !c6.getText().toString().isEmpty())
                        {
                            Toast.makeText(CompleteYourKyc.this, "verified", Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                            sendotp.setVisibility(View.GONE);
                            verfied.setVisibility(View.VISIBLE);

                        }
                        else {
                            Toast.makeText(CompleteYourKyc.this, "enter OTP", Toast.LENGTH_LONG).show();

                        }


                    }
                });
//for close the dialog
                ImageView closeDialog=(ImageView)dialog.findViewById(R.id.close_img_dialog_otp);
                closeDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            Intent intent = new Intent(getApplicationContext(), KvcSecondeStep.class);
                startActivity(intent);
            }
        });



        back = findViewById(R.id.backArrow_complete_ur_yvc);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CompleteYourKyc.super.onBackPressed();
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources()
                .getStringArray(R.array.Spinner));
        AutoCompleteTextView textViewSpinner = (AutoCompleteTextView)
                findViewById(R.id.linearLayout_gender);
        textViewSpinner.setAdapter(adapter);
        textViewSpinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
                // TODO Auto-generated method stub
                textViewSpinner.showDropDown();
                textViewSpinner.requestFocus();
                return false;
            }
        });

        ArrayAdapter<String> adapterRelation = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources()
                .getStringArray(R.array.Relationship));
        AutoCompleteTextView textViewRelation = (AutoCompleteTextView)
                findViewById(R.id.relation_db);
        textViewRelation.setAdapter(adapterRelation);
        textViewRelation.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
                // TODO Auto-generated method stub
                textViewRelation.showDropDown();
                textViewRelation.requestFocus();
                return false;
            }
        });



        nameText.addTextChangedListener(textWatcher);
        number.addTextChangedListener(textWatcher);
        gender.addTextChangedListener(textWatcher);
        dob.addTextChangedListener(textWatcher);
        emailText.addTextChangedListener(textWatcher);
        relation.addTextChangedListener(textWatcher);


    }
    public TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String name=nameText.getText().toString().trim();
            String noText=number.getText().toString().trim();
            String genderText=gender.getText().toString().trim();
            String dobText=dob.getText().toString().trim();
            String email=emailText.getText().toString().trim();
            String relationText=relation.getText().toString().trim();
            button.setEnabled(!name.isEmpty() && !noText.isEmpty() && !genderText.isEmpty() && !dobText.isEmpty() && !email.isEmpty() && !relationText.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    }

