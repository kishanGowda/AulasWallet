package com.example.aluswallet;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MyCustomDialog extends DialogFragment implements View.OnClickListener {

    Activity mActivity;


    private TextView mActionOk;


    //vars

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kvc_complete,container);

        mActionOk = view.findViewById(R.id.okay_btn);


        mActionOk.setOnClickListener(new View.OnClickListener() {


    @Override
    public void onClick(View view) {
        Intent i = new Intent(getActivity(), AlusAdmissionFee.class);
        startActivity(i);
    }
        });

        return view;
    }

    @Override
    public void onClick(View view) {

    }
}
