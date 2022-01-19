package com.example.aluswallet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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

import java.util.ArrayList;

public class DetailsOfPayment extends AppCompatActivity {
    Button button;
    Dialog mdialog;
    ImageView back;
    EditText c1;
    TextView amount;
    Button pay;
    final int UPI_PAYMNT = 0;


    private TextView upi, other;
    BottomSheetDialog mBottomSheetDialog;
    View sheetView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_of_payment);
        amount = findViewById(R.id.total_amount_rs_tv);


        mdialog = new Dialog(DetailsOfPayment.this);
        mdialog.requestWindowFeature(Window.FEATURE_LEFT_ICON);

        mdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mdialog.setContentView(R.layout.email);
        Button next = mdialog.findViewById(R.id.next);
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

                            String amt = "1";
                            String upitxt = "9901153220@paytm";
                            String upiname = "kishan";
                            String upinote = "kishan";
                            payUsingupi(amt, upitxt, upiname, upinote);


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

        ImageView cancel = (ImageView) mdialog.findViewById(R.id.cancel_imageView_email);
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

        private void payUsingupi(String amt, String upitxt, String upiname, String upinote) {
            Uri uri = Uri.parse("upi://pay").buildUpon().appendQueryParameter("pa", upitxt)
                    .appendQueryParameter("pn", upiname)
                    .appendQueryParameter("tn", upinote)
                    .appendQueryParameter("am", amt)
                    .appendQueryParameter("mc", "")
                    //.appendQueryParameter("tid", "02125412")
                    .appendQueryParameter("tr", "25584584")
                    .appendQueryParameter("cu", "INR").build();
            Intent upi_payment = new Intent(Intent.ACTION_VIEW);
            upi_payment.setData(uri);
            Intent chooser = Intent.createChooser(upi_payment, "pay with");
            if (null != chooser.resolveActivity(getPackageManager())) {
                startActivityForResult(chooser, UPI_PAYMNT);

            } else {
                Toast.makeText(DetailsOfPayment.this, "no upi app found", Toast.LENGTH_SHORT).show();
            }

        }

        private void initialiemethod() {
            upi = (TextView) findViewById(R.id.upi_tv);
            amount = (TextView) findViewById(R.id.total_amount_rs_tv);
        }


        protected void onActivityResult(int requestCode, int resultCode, Intent data) {

            super.onActivityResult(requestCode, resultCode, data);
            switch (requestCode) {
                case UPI_PAYMNT:
                    if ((RESULT_OK == resultCode || (requestCode == 11))) {
                        if (data != null) {
                            String txt = data.getStringExtra("response");
                            Log.d("UPI", "onActivityResults:" + txt);
                            ArrayList<String> dataLst = new ArrayList<>();
                            dataLst.add("Nothing");
                            upipaymentdataoperation(dataLst);

                        } else {
                            Log.d("UPI", "onActivityResults:" + "Return data is null");
                            ArrayList<String> dataLst = new ArrayList<>();
                            dataLst.add("Nothing");
                            upipaymentdataoperation(dataLst);
                        }
                    } else {
                        Log.d("UPI", "onActivityResults:" + "Return data is null");
                        ArrayList<String> dataLst = new ArrayList<>();
                        dataLst.add("Nothing");
                        upipaymentdataoperation(dataLst);
                    }

                    break;

            }
        }

        private void upipaymentdataoperation(ArrayList<String> data) {
            if (isConnectionAvaliable(DetailsOfPayment.this)) {
                String str = data.get(0);
                Log.d("UPIPAY", "upipaymentoperation:" + str);
                String paymentCancel = "";
                if (str == null) str = "discard";
                String status = "";
                String approvalref = "";
                String response[] = str.split("&");
                for (int i = 0; i < response.length; i++) {
                    String equalStr[] = response[i].split("=");
                    if (equalStr.length >= 2) {
                        if (equalStr[0].toLowerCase().equals("Status".toLowerCase())) {
                            status = equalStr[1].toLowerCase();
                        } else if (equalStr[0].toLowerCase().equals("approval Ref".toLowerCase()) ||
                                equalStr[0].toLowerCase().equals("txnRef".toLowerCase())) {
                            approvalref = equalStr[1];
                        }

                    } else {
                        paymentCancel = "payment cancel by user";
                    }
                }
                if (status.equals("success")) {
                    Toast.makeText(getApplicationContext(), "transaction sucess", Toast.LENGTH_SHORT).show();
                    Log.d("UPI", "responsestr:" + approvalref);

                } else if ("payment cancel by user".equals(paymentCancel))

                {
                    mBottomSheetDialog.dismiss();
                    Dialog canceldialog = new Dialog(DetailsOfPayment.this, androidx.appcompat.R.style.Theme_AppCompat_Dialog);
                    canceldialog.requestWindowFeature(Window.FEATURE_LEFT_ICON);
                    canceldialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    canceldialog.setCancelable(false);
                    canceldialog.setContentView(R.layout.payment_cancel);
                    Button tryagain=(Button)canceldialog.findViewById(R.id.tryagain_btn);
                    tryagain.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            canceldialog.dismiss();
                        }
                    });

                    canceldialog.show();
                    Toast.makeText(DetailsOfPayment.this, "payment cancel by user", Toast.LENGTH_SHORT).show();
                } else {

                    mBottomSheetDialog.dismiss();
                    Dialog canceldialog = new Dialog(DetailsOfPayment.this, androidx.appcompat.R.style.Theme_AppCompat_Dialog);
                    canceldialog.requestWindowFeature(Window.FEATURE_LEFT_ICON);
                    canceldialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    canceldialog.setCancelable(false);
                    canceldialog.setContentView(R.layout.transaction_failed);
                    Button tryagain=(Button)canceldialog.findViewById(R.id.tryagain_btn);
                    tryagain.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            canceldialog.dismiss();
                        }
                    });

                    canceldialog.show();
                    Toast.makeText(DetailsOfPayment.this, "transaction failed", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(DetailsOfPayment.this, "internet connection is not avialable", Toast.LENGTH_SHORT).show();
            }
        }

        private boolean isConnectionAvaliable(Context context){
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager != null) {
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected() && networkInfo.isConnectedOrConnecting()
                        && networkInfo.isAvailable()) {
                    return true;
                }

            }
            return false;
        }
    }
