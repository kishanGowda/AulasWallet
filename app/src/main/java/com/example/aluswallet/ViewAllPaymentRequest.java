package com.example.aluswallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

public class ViewAllPaymentRequest extends AppCompatActivity {




    ArrayList<PaymentRequestTwo> card = new ArrayList<>();
    RecyclerView recyclerView;

    RecyclerView.Adapter cardAdapter;
    RecyclerView.LayoutManager cardLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_all_payment_request);
       createCard();
        buildRecyclerView();
    }

    public void createCard() {
        card = new ArrayList<>();
        card.add(new PaymentRequestTwo("100", "12/12/2021, 03:25 PM", "12/12/2021", "admission"));
        card.add(new PaymentRequestTwo("100", "12/12/2021, 03:25 PM", "12/12/2021", "admission"));
        card.add(new PaymentRequestTwo("100", "12/12/2021, 03:25 PM", "12/12/2021", "admission"));
        card.add(new PaymentRequestTwo("100", "12/12/2021, 03:25 PM", "12/12/2021", "admission"));
        card.add(new PaymentRequestTwo("100", "12/12/2021, 03:25 PM", "12/12/2021", "admission"));
        card.add(new PaymentRequestTwo("100", "12/12/2021, 03:25 PM", "12/12/2021", "admission"));
        card.add(new PaymentRequestTwo("100", "12/12/2021, 03:25 PM", "12/12/2021", "admission"));


    }

    public void buildRecyclerView() {
        recyclerView = findViewById(R.id.payment_request_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);

        cardLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(cardLayoutManager);

        cardAdapter = new PaymentRequestAdapterTwo(card,getApplicationContext());

        recyclerView.setAdapter(cardAdapter);
    }
}