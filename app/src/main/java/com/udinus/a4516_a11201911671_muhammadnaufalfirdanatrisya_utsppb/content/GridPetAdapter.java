package com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.content;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.R;
import com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.models.Pet;

import java.util.ArrayList;

public class GridPetAdapter extends RecyclerView.Adapter<GridPetAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<Pet> listPet;

    public ArrayList<Pet> getListPet() {
        return listPet;
    }

    public void setListPet(ArrayList<Pet> listPet) {
        this.listPet = listPet;
    }

    public GridPetAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GridPetAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_pet, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridPetAdapter.GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListPet().get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListPet().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}