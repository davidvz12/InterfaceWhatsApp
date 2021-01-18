package com.example.interfacewhatsapp.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.interfacewhatsapp.Model.Chat;
import com.example.interfacewhatsapp.R;

import java.util.List;

public  class AdapterChat extends RecyclerView.Adapter<AdapterChat.ChatViewHolder> {
    private Context Ctx;
    private List<Chat> lstChat;

    public AdapterChat(Context mCtx, List<Chat> chat) {
        this.lstChat = chat;
        Ctx=mCtx;
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        View view;
        ChatViewHolder chatViewHolder;
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        view = inflater.inflate(R.layout.ly_item_message, null);
        chatViewHolder = new ChatViewHolder(view,viewType);
        return chatViewHolder;
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {


            Chat chat = lstChat.get(position);
            holder.txtUsername.setText(chat.getUsername());
            holder.txtDescription.setText(chat.getDescription());
            holder.txtTime.setText(chat.getTime());
            Glide.with(Ctx)
                    .load(chat.getUrlImage())
                    .into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return lstChat.size();
    }


    class ChatViewHolder extends RecyclerView.ViewHolder {
        int view_type;
        TextView txtUsername,txtDescription,txtTime;
        ImageView imageView;

        public ChatViewHolder(View itemView, int viewType) {
            super(itemView);

            txtUsername= itemView.findViewById(R.id.txtUsername);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            txtTime = itemView.findViewById(R.id.txtTime);
            imageView = itemView.findViewById(R.id.urlImage);

        }
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
