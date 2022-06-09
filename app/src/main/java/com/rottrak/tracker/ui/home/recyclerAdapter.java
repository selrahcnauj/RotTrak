package com.rottrak.tracker.ui.home;

import android.view.*;
import android.view.ViewGroup;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rottrak.tracker.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder>{

    private ArrayList<expiryListData> itemList;
    private RecyclerViewClickListener clickListener;

    public interface OnItemClickListener {
        void onItemClick();
    }
    public recyclerAdapter(ArrayList<expiryListData> itemList, RecyclerViewClickListener clickListener){
        this.itemList = itemList;
        this.clickListener = clickListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView txt_item_estimated;
        private TextView txt_item_name;
        private TextView txt_item_category;
        private ImageView imgItem;
        private LinearLayout linear_item_category;
        private TextView txt_item_quantity;
        private LinearLayout linear_item_quantity;
        private TextView txt_item_date;
        private LinearLayout linear_item_BG;

        public MyViewHolder(final View view){
            super(view);
            linear_item_BG = view.findViewById(R.id.linear_item_BG);
            txt_item_name = view.findViewById(R.id.txt_item_title);
            txt_item_category = view.findViewById(R.id.txt_item_category);
            imgItem = view.findViewById(R.id.imgItem);
            linear_item_category = view.findViewById(R.id.linear_item_category);
            txt_item_quantity = view.findViewById(R.id.txt_item_quantity);
            linear_item_quantity = view.findViewById(R.id.linear_item_quantity);
            txt_item_date = view.findViewById(R.id.txt_item_subtitle);
            txt_item_estimated = view.findViewById(R.id.txt_item_estimated);
            view.setOnClickListener(this);
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        /*holder.bind(itemList.get(position), clickListener);

            public void bind(final ContentItem item, final OnItemClickListener listener) {
    ...
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }*/
        /*holder.linear_item_BG.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity, R.style.AlertDialog_Fullscreen);
                LayoutInflater i = (LayoutInflater) MainActivity.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
                View mView = i.inflate(R.layout.dialog_new_item_expiry, null);
                builder.setView(mView);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });*/


        /*holder.txt_item_name.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(v., ItemActivity.class);
                v.getContext().startActivity(i);
            }
        });*/

        String name = itemList.get(position).getName();
        holder.txt_item_name.setText(name);

        //Date
        String date = itemList.get(position).getDate();

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        Date expDate = null;


        try {
            expDate = sdf.parse(date);
            //Expiration Date

            String stringDate = sdf.format(expDate);
            holder.txt_item_date.setText("Expires in " + stringDate);


        } catch (ParseException e) {
            holder.txt_item_date.setVisibility(View.GONE);
            e.printStackTrace();
        }

        Date currentDate = null;
        try {
            currentDate = sdf.parse("6/9/2022");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Days
        long diff = expDate.getTime() - currentDate.getTime();
        holder.txt_item_estimated.setText(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)+" Days");



        //Quantity
        int quantity = itemList.get(position).getQuantity();

        holder.txt_item_quantity.setText(quantity+"x");
        if(quantity <= 1){
            holder.linear_item_quantity.setVisibility(View.GONE);
        }

        //Category
        if(itemList.get(position).getCategory().equals("")) {
            holder.linear_item_category.setVisibility(View.GONE);
        } else {
            String category = itemList.get(position).getCategory();
            holder.txt_item_category.setText(category);
        }

        //Image
        int imageUrl = itemList.get(position).getImageUrl();
        holder.imgItem.setImageResource(imageUrl);

    }



    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public interface RecyclerViewClickListener {
        void onClick(View v, int position);
    }
}
