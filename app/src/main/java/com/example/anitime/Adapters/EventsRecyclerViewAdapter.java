package com.example.anitime.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anitime.Models.EventModel;
import com.example.anitime.R;

import java.util.ArrayList;

public class EventsRecyclerViewAdapter extends RecyclerView.Adapter<EventsRecyclerViewAdapter.ViewHolder> {
    ArrayList<EventModel> eventModelArrayList = new ArrayList<>();
    private RecyclerviewOnClickListener mRecyclerviewOnClickListener;

    public EventsRecyclerViewAdapter(ArrayList<EventModel> eventModelArrayList, RecyclerviewOnClickListener recyclerviewOnClickListener) {
        this.eventModelArrayList = eventModelArrayList;
        this.mRecyclerviewOnClickListener = recyclerviewOnClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_card,parent,false);
        return new EventsRecyclerViewAdapter.ViewHolder(cardView, mRecyclerviewOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.date.setText(eventModelArrayList.get(position).getDay());
        holder.month.setText(eventModelArrayList.get(position).getMonth());
        holder.title.setText(eventModelArrayList.get(position).getTitle());
        holder.location.setText(eventModelArrayList.get(position).getLocation());
        holder.count.setText(eventModelArrayList.get(position).getCount());
        holder.imageView.setImageResource(eventModelArrayList.get(position).getImageView());
    }

    @Override
    public int getItemCount() {
        return eventModelArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView date, month, title, location, count;
        RecyclerviewOnClickListener recyclerviewOnClickListener;
        public ViewHolder(@NonNull View itemView, RecyclerviewOnClickListener recyclerviewOnClickListener) {
            super(itemView);
            date = itemView.findViewById(R.id.day);
            month = itemView.findViewById(R.id.month);
            title = itemView.findViewById(R.id.eventTitle);
            location = itemView.findViewById(R.id.location);
            count = itemView.findViewById(R.id.count);
            imageView = itemView.findViewById(R.id.event_card_image);
            this.recyclerviewOnClickListener = recyclerviewOnClickListener;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            recyclerviewOnClickListener.recyclerviewClick(getAbsoluteAdapterPosition());
        }
    }
    public interface RecyclerviewOnClickListener{
        void recyclerviewClick(int position);
    }
}
