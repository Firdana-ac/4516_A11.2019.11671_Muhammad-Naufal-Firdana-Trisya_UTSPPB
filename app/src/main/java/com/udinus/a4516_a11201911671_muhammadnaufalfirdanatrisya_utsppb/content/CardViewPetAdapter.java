package com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.content;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.R;
import com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.models.Pet;
import com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.view.DetailPetActivity;

import java.util.ArrayList;

public class CardViewPetAdapter extends RecyclerView.Adapter<CardViewPetAdapter.CardViewViewHolder> {
    public CardViewPetAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    public ArrayList<Pet> getListPet() {
        return listPet;
    }

    public void setListPet(ArrayList<Pet> listPet) {
        this.listPet = listPet;
    }

    private ArrayList<Pet> listPet;


    @NonNull
    @Override
    public CardViewPetAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_pet, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewPetAdapter.CardViewViewHolder cardViewViewHolder, int i) {
        final Pet p = getListPet().get(i);

        Glide.with(context)
                .load(p.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.imgPhoto);

        cardViewViewHolder.tvName.setText(p.getName());
        cardViewViewHolder.tvRemarks.setText(p.getRemarks());

        cardViewViewHolder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Suka "+getListPet().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

        cardViewViewHolder.btnShare.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share "+getListPet().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

        cardViewViewHolder.imgPhoto.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent intent = new Intent(context, DetailPetActivity.class);
                intent.putExtra(DetailPetActivity.EXTRA_NAMA, getListPet().get(position).getName());
                intent.putExtra(DetailPetActivity.EXTRA_REMARK, getListPet().get(position).getRemarks());
                intent.putExtra(DetailPetActivity.EXTRA_FOTO, getListPet().get(position).getPhoto());
                intent.putExtra(DetailPetActivity.EXTRA_DETAIL, getListPet().get(position).getDeskripsi());
                intent.putExtra(DetailPetActivity.EXTRA_LOKASI, getListPet().get(position).getLokasi());
                context.startActivity(intent);
            }
        }));

    }

    @Override
    public int getItemCount() {
        return getListPet().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnFavorite, btnShare;

        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);

        }
    }
}
