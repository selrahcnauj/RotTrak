package com.rottrak.tracker.ui.notifications;

import android.view.*;
import android.view.ViewGroup;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rottrak.tracker.R;

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
        private TextView txt_item_subtitle;
        private ImageView red_dot;
        private ImageView img_item;
        private LinearLayout layoutParent;

        public MyViewHolder(final View view){
            super(view);
            txt_item_name = view.findViewById(R.id.txt_item_title);
            txt_item_subtitle = view.findViewById(R.id.txt_item_subtitle);
            red_dot = view.findViewById(R.id.red_dot);
            img_item = view.findViewById(R.id.image_item);
            layoutParent = view.findViewById(R.id.layoutParent);
            view.setOnClickListener(this);

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
        boolean isRead = itemList.get(position).isStateRead();

        if(isRead){
            holder.red_dot.setVisibility(View.INVISIBLE);
            holder.layoutParent.setAlpha((float)0.5);
        }

        int image = itemList.get(position).getImageUrl();

        holder.img_item.setImageResource(image);

        String name = itemList.get(position).getName();
        holder.txt_item_name.setText(name);

        String description = itemList.get(position).getDescription();

        holder.txt_item_subtitle.setText(description);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}