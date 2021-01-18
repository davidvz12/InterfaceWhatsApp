package com.example.interfacewhatsapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.interfacewhatsapp.Model.Calls;
import com.example.interfacewhatsapp.R;

import java.util.List;

public class AdapterCalls extends RecyclerView.Adapter<AdapterCalls.CallsViewHolder>{

    private Context Ctx;
    private List<Calls> lstCalls;

    public AdapterCalls(Context mCtx, List<Calls> calls) {
        this.lstCalls = calls;
        Ctx=mCtx;
    }

    @NonNull
    @Override
    public AdapterCalls.CallsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        View view;
        AdapterCalls.CallsViewHolder callsViewHolder;
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        view = inflater.inflate(R.layout.ly_item_calls, null);
        callsViewHolder = new AdapterCalls.CallsViewHolder(view);
        return callsViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCalls.CallsViewHolder holder, int position) {

            Calls calls = lstCalls.get(position);
            holder.txtUsername.setText(calls.getUsername());
            holder.txtTime.setText(calls.getTime());
            Glide.with(Ctx)
                    .load(calls.getUrlIcon())

                    .into(holder.imageViewState);
            Glide.with(Ctx)
                    .load(calls.getUrlImage())
                    .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return lstCalls.size();
    }
    class CallsViewHolder extends RecyclerView.ViewHolder {

        TextView txtUsername,txtTime;
        ImageView imageView,imageViewState;

        public CallsViewHolder(View itemView) {
            super(itemView);
                txtUsername= itemView.findViewById(R.id.txtUsernameCalls);
                txtTime = itemView.findViewById(R.id.txtTimeCalls);
                imageView = itemView.findViewById(R.id.urlImageCalls);
                imageViewState = itemView.findViewById(R.id.urlStateCalls);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
