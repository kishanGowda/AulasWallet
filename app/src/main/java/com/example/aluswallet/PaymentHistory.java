package com.example.aluswallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class PaymentHistory extends AppCompatActivity {

    ArrayList<PaymentHistoryClass> card = new ArrayList<>();
    RecyclerView recyclerView;

    RecyclerView.Adapter cardAdapter;
    RecyclerView.LayoutManager cardLayoutManager;

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_history);
        createCard();
        buildRecyclerView();
        createCardOne();
        buildRecyclerViewOne();


        back = findViewById(R.id.backArrow_payment_history);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PaymentHistory.super.onBackPressed();
            }
        });
    }

    public void createCard() {
        card = new ArrayList<>();
        card.add(new PaymentHistoryClass("100", "12/12/2021, 03:25 PM"));
        card.add(new PaymentHistoryClass("100", "12/12/2021, 03:25 PM"));
        card.add(new PaymentHistoryClass("100", "12/12/2021, 03:25 PM"));


    }

    public void buildRecyclerView() {
        recyclerView = findViewById(R.id.payment_history_recyclerview);
        recyclerView.setHasFixedSize(true);
        cardLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(cardLayoutManager);
        cardAdapter = new PaymentHistoryAdapter(card);
        recyclerView.setAdapter(cardAdapter);
    }

    public void createCardOne() {
        card = new ArrayList<>();
        card.add(new PaymentHistoryClass("100", "12/12/2021, 03:25 PM"));
        card.add(new PaymentHistoryClass("100", "12/12/2021, 03:25 PM"));
        card.add(new PaymentHistoryClass("100", "12/12/2021, 03:25 PM"));
        card.add(new PaymentHistoryClass("100", "12/12/2021, 03:25 PM"));
        card.add(new PaymentHistoryClass("100", "12/12/2021, 03:25 PM"));
        card.add(new PaymentHistoryClass("100", "12/12/2021, 03:25 PM"));
        card.add(new PaymentHistoryClass("100", "12/12/2021, 03:25 PM"));
        card.add(new PaymentHistoryClass("100", "12/12/2021, 03:25 PM"));



    }

    public void buildRecyclerViewOne() {
        recyclerView = findViewById(R.id.payment_history_recyclerview_month);
        recyclerView.setHasFixedSize(true);
        cardLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(cardLayoutManager);
        cardAdapter = new PaymentHistoryAdapter(card);
        recyclerView.setAdapter(cardAdapter);
    }
}