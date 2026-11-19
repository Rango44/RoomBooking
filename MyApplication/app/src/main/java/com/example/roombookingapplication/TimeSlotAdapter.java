package com.example.roombookingapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TimeSlotAdapter extends RecyclerView.Adapter<TimeSlotAdapter.SlotViewHolder> {

    private List<TimeSlot> timeSlots;

    public TimeSlotAdapter(List<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }

    @NonNull
    @Override
    public SlotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_slot, parent, false);
        return new SlotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SlotViewHolder holder, int position) {
        TimeSlot currentSlot = timeSlots.get(position); // value ids from timeSlots.java

        holder.timeText.setText(currentSlot.time);

        if (currentSlot.booked) {
            holder.statusText.setText("Booked");
        } else {
            holder.statusText.setText("Available");
        }
    }

    @Override
    public int getItemCount() {
        return timeSlots.size();
    }
    static class SlotViewHolder extends RecyclerView.ViewHolder {
        TextView timeText;
        TextView statusText;

        public SlotViewHolder(@NonNull View itemView) {
            super(itemView);
            timeText = itemView.findViewById(R.id.timeText);
            statusText = itemView.findViewById(R.id.statusText);
        }
    }
}


