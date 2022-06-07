package com.rottrak.tracker.ui.notifications;

import android.view.*;
import android.view.ViewGroup;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rottrak.tracker.R;
import com.rottrak.tracker.ui.notifications.notifListData;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<com.rottrak.tracker.ui.notifications.recyclerAdapter.MyViewHolder>{

    private ArrayList<notifListData> itemList;
    private com.rottrak.tracker.ui.notifications.recyclerAdapter.RecyclerViewClickListener clickListener;

    public recyclerAdapter(ArrayList<notifListData> itemList, com.rottrak.tracker.ui.notifications.recyclerAdapter.RecyclerViewClickListener clickListener){
        this.itemList = itemList;
        this.clickListener = clickListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txt_item_name;
        private TextView txt_item_date;

        public MyViewHolder(final View view){
            super(view);
            txt_item_name = view.findViewById(R.id.txt_item_title);
            txt_item_date = view.findViewById(R.id.txt_item_date);

        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public com.rottrak.tracker.ui.notifications.recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.notifs_list_item, parent,  false);
        return new com.rottrak.tracker.ui.notifications.recyclerAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull com.rottrak.tracker.ui.notifications.recyclerAdapter.MyViewHolder holder, int position) {
        String name = itemList.get(position).getName();
        holder.txt_item_name.setText(name);

        String description = itemList.get(position).getDescription();

        holder.txt_item_date.setText(description);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}