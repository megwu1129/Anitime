package com.example.anitime.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.bumptech.glide.Glide;
import com.example.anitime.Models.PetsModel;
import com.example.anitime.R;

import java.util.ArrayList;

public class PetsRecyclerViewAdapter extends RecyclerView.Adapter<PetsRecyclerViewAdapter.ViewHolder> {
    ArrayList<PetsModel> petsModelArrayList = new ArrayList<>();
    private RecyclerviewOnClickListener mRecyclerviewOnClickListener;

    public PetsRecyclerViewAdapter(ArrayList<PetsModel> petsModelArrayList, RecyclerviewOnClickListener recyclerviewOnClickListener) {
        this.petsModelArrayList = petsModelArrayList;
        this.mRecyclerviewOnClickListener = recyclerviewOnClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_card,parent,false);
        return new PetsRecyclerViewAdapter.ViewHolder(cardView, mRecyclerviewOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.petName.setText(petsModelArrayList.get(position).getPetName());
        holder.ownerName.setText(petsModelArrayList.get(position).getOwnerName());
        holder.breeder.setText(petsModelArrayList.get(position).getBreeder());
        holder.age.setText(petsModelArrayList.get(position).getAge());
        holder.petImage.setImageResource(petsModelArrayList.get(position).getUrlPic());
        holder.genderImage.setImageResource(petsModelArrayList.get(position).getUrlGender());
    }

    @Override
    public int getItemCount() {
        return petsModelArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView petName, ownerName, breeder, age;
        ImageView petImage, genderImage;
        RecyclerviewOnClickListener recyclerviewOnClickListener;
        public ViewHolder(@NonNull View itemView, RecyclerviewOnClickListener recyclerviewOnClickListener) {
            super(itemView);
            petName = itemView.findViewById(R.id.PetName);
            ownerName = itemView.findViewById(R.id.OwnerName);
            breeder = itemView.findViewById(R.id.Breeder);
            age = itemView.findViewById(R.id.age);
            petImage = itemView.findViewById(R.id.card_image);
            genderImage = itemView.findViewById(R.id.genderImage);
            this.recyclerviewOnClickListener = recyclerviewOnClickListener;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            recyclerviewOnClickListener.recyclerviewClick(getAdapterPosition());

        }
    }
    public interface RecyclerviewOnClickListener{
        void recyclerviewClick(int position);
    }

}
