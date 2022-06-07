package com.rottrak.tracker.ui.home;

import android.view.*;
import android.view.ViewGroup;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rottrak.tracker.R;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder>{

    private ArrayList<expiryListData> itemList;
    private RecyclerViewClickListener clickListener;

    public recyclerAdapter(ArrayList<expiryListData> itemList, RecyclerViewClickListener clickListener){
        this.itemList = itemList;
        this.clickListener = clickListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txt_item_name;
        private TextView txt_item_category;

        public MyViewHolder(final View view){
            super(view);
            txt_item_name = view.findViewById(R.id.txt_item_title);
            txt_item_category = view.findViewById(R.id.txt_item_category);

        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expiry_list_item, parent,  false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String name = itemList.get(position).getName();
        holder.txt_item_name.setText(name);

        String date = itemList.get(position).getDate();

        String category = itemList.get(position).getCategory();
        holder.txt_item_category.setText(category);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public interface RecyclerViewClickListener {
        void onClick(View v, int position);
    }
}
