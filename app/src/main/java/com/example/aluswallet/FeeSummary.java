package com.example.aluswallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class FeeSummary extends AppCompatActivity {
    TextView textView;

    ArrayList<PaymentRequest> card = new ArrayList<>();
    RecyclerView recyclerView;

    RecyclerView.Adapter cardAdapter;
    RecyclerView.LayoutManager cardLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee_summary);
        textView=findViewById(R.id.view_all_tv_for_fee_summary);

        createCard();
        buildRecyclerView();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               c();
            }
        });

    }

    public void createCard() {
        card = new ArrayList<>();
        card.add(new PaymentRequest("100", "12/12/2021, 03:25 PM","12/12/2021","admission"));
        card.add(new PaymentRequest("100", "12/12/2021, 03:25 PM","12/12/2021","admission"));
        card.add(new PaymentRequest("100", "12/12/2021, 03:25 PM","12/12/2021","admission"));


    }

    public void buildRecyclerView() {
        recyclerView = findViewById(R.id.payment_recycler);
        recyclerView.setHasFixedSize(true);

        cardLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(cardLayoutManager);
        cardAdapter = new PaymentRequestAdapter(card);
        recyclerView.setAdapter(cardAdapter);
        final int radius = getResources().getDimensionPixelSize(androidx.cardview.R.dimen.cardview_default_radius);
        final int dotsHeight = getResources().getDimensionPixelSize(com.google.android.material.R.dimen.abc_action_bar_default_height_material);
        final int color = ContextCompat.getColor(getApplicationContext(), R.color.black);
        recyclerView.addItemDecoration(new DotsIndicatorDecoration(radius, radius * 4, dotsHeight, color, color));
        new PagerSnapHelper().attachToRecyclerView(recyclerView);



    }
public void c(){
    Intent intent=new Intent(getApplicationContext(),ViewAllPaymentRequest.class);
    startActivity(intent);
}


}