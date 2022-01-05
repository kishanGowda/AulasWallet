package com.example.aluswallet;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PaymentRequestAdapterTwo extends RecyclerView.Adapter<PaymentRequestAdapterTwo.CardViewHolder> {
Context context;
ArrayList<PaymentRequestTwo> card;

    public PaymentRequestAdapterTwo(ArrayList<PaymentRequestTwo> card, Context context) {
        this.card=card;
        this.context=context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_request_recyclerviewtwo,parent,false);
        CardViewHolder cardViewHolder = new CardViewHolder(view);
        return cardViewHolder;

    }
    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        PaymentRequestTwo payment = this.card.get(position);



        holder.rupees.setText(payment.getRupees());
        holder.dueDate.setText(payment.getDueDate());
        holder.issuedDateTime.setText(payment.getIssuedDateTime());
        holder.admission.setText(payment.getAdmission());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,DetailsOfPayment.class);
                context.startActivity(intent);
            }
        });



    }
    @Override
    public int getItemCount() {
        return card.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        public TextView rupees;
        public TextView issuedDateTime;
        public TextView dueDate;
         public TextView admission;


        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            rupees = itemView.findViewById(R.id.rs_100_);
            issuedDateTime = itemView.findViewById(R.id.issued_date_time_tv_);
            dueDate = itemView.findViewById(R.id.due_date_tv_);
            admission=itemView.findViewById(R.id.admission_fee_tvv);


        }
    }




}
