package com.example.aluswallet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PaymentHistoryAdapter extends RecyclerView.Adapter<PaymentHistoryAdapter.CardViewHolder> {
    ArrayList<PaymentHistoryClass> card;


    public PaymentHistoryAdapter(ArrayList<PaymentHistoryClass> card) {
        this.card=card;

    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_history_recyclerview,parent,false);
        CardViewHolder cardViewHolder = new CardViewHolder(view);
        return cardViewHolder;

    }
    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        PaymentHistoryClass payment = this.card.get(position);



        holder.rupees.setText(payment.getRupees());

        holder.issuedDateTime.setText(payment.getIssuedDateTime());


    }
    @Override
    public int getItemCount() {
        return card.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        public TextView rupees;
        public TextView issuedDateTime;



        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            rupees = itemView.findViewById(R.id.rs);
            issuedDateTime = itemView.findViewById(R.id.time_and_date_payment_history);


        }
    }




}