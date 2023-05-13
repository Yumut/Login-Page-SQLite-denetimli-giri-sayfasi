package com.example.login;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adaptor extends RecyclerView.Adapter<adaptor.myholder> {
    private ArrayList<photo> photos;

    public adaptor(ArrayList<photo> photos) {
        this.photos=photos;
    }

    @NonNull
    @Override
    public myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.pht,parent,false);

        return new myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myholder holder, int position) {
            holder.basliktxt.setText(photos.get(position).getBaslik());
            holder.aciklamatxt.setText(photos.get(position).getAciklama());
            holder.imgphoto.setImageResource(photos.get(position).getLogo());


    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class myholder extends RecyclerView.ViewHolder{
        TextView basliktxt,aciklamatxt;
        ImageView imgphoto;



        public myholder(@NonNull View itemView) {
            super(itemView);

            basliktxt = itemView.findViewById(R.id.basliktxt);
            aciklamatxt=itemView.findViewById(R.id.aciklamatxt);
            imgphoto= itemView.findViewById(R.id.imgphoto);
        }
    }
}
