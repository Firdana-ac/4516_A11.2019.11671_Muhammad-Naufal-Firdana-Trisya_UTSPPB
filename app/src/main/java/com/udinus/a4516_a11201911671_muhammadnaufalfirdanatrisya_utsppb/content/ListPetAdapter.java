package com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.content;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.R;
import com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.models.Pet;

import java.util.ArrayList;

public class ListPetAdapter extends RecyclerView.Adapter<ListPetAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Pet> listPet;

    public ArrayList<Pet> getListPet() {
        return listPet;
    }

    public void setListPet(ArrayList<Pet> listPet) {
        this.listPet = listPet;
    }

    public ListPetAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public ListPetAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_pet, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ListPetAdapter.CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvName.setText(getListPet().get(position).getName());
        categoryViewHolder.tvRemarks.setText(getListPet().get(position).getRemarks());

        Glide.with(context)
                .load(getListPet().get(position).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);

    }

    @Override
    public int getItemCount() {
        return getListPet().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;


        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}