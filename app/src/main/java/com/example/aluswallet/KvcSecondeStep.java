package com.example.aluswallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class KvcSecondeStep extends AppCompatActivity {

    Button button;
    ImageView back;
    EditText house, pincode;
    AutoCompleteTextView state, city, country;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kvc_seconde_step);
        button = findViewById(R.id.proceed_addr_button);
        house = findViewById(R.id.house_editText);
        pincode = findViewById(R.id.pincode_editText);
        state = findViewById(R.id.state_editText);
        city = findViewById(R.id.city_editText);
        country = findViewById(R.id.country_editText);



        button = findViewById(R.id.proceed_addr_button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RemainingKyc.class);
                startActivity(intent);
            }
        });

        ArrayAdapter<String> adapterDestrict = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources()
                .getStringArray(R.array.Desrict));
        AutoCompleteTextView textViewDestrict = (AutoCompleteTextView)
                findViewById(R.id.city_editText);
        textViewDestrict.setAdapter(adapterDestrict);
        textViewDestrict.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
                // TODO Auto-generated method stub
                textViewDestrict.showDropDown();
                textViewDestrict.requestFocus();
                return false;
            }
        });
        //for back

        back = findViewById(R.id.backArrow_kvc_seconde_step);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KvcSecondeStep.super.onBackPressed();
            }
        });


        ArrayAdapter<String> adapterRelation = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources()
                .getStringArray(R.array.States));
        AutoCompleteTextView textViewStates = (AutoCompleteTextView)
                findViewById(R.id.state_editText);
        textViewStates.setAdapter(adapterRelation);
        textViewStates.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
                // TODO Auto-generated method stub
                textViewStates.showDropDown();
                textViewStates.requestFocus();
                return false;
            }
        });


        ArrayAdapter<String> adapterCountry = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, getResources()
                .getStringArray(R.array.country));
        AutoCompleteTextView textViewCountry = (AutoCompleteTextView)
                findViewById(R.id.country_editText);
        textViewCountry.setAdapter(adapterCountry);
        textViewCountry.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
                // TODO Auto-generated method stub
                textViewCountry.showDropDown();
                textViewCountry.requestFocus();
                return false;
            }
        });


        house.addTextChangedListener(textWatcher);
        pincode.addTextChangedListener(textWatcher);
        state.addTextChangedListener(textWatcher);
        city.addTextChangedListener(textWatcher);
        country.addTextChangedListener(textWatcher);
    }
    TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String houseNo=house.getText().toString().trim();
            String pincodeT=pincode.getText().toString().trim();
            String stateT=state.getText().toString().trim();
            String cityT=city.getText().toString().trim();
            String countryT=country.getText().toString().trim();
            button.setEnabled(!houseNo.isEmpty() && !pincodeT.isEmpty() && !stateT.isEmpty() && !cityT.isEmpty() && !countryT.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    }

