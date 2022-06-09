package com.rottrak.tracker.ui.cart;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.*;
import android.widget.*
;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.rottrak.tracker.R;

import java.util.ArrayList;

class ListViewAdapter extends ArrayAdapter<String> {
    ArrayList<String> list;
    Context context;

    public ListViewAdapter(Context context, ArrayList<String> items){
        super(context, R.layout.list_grocery_item, items);
        this.context = context;
        list = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_grocery_item, null);

            TextView text = convertView.findViewById(R.id.txt_quantity);
            text.setText("1 Pc.");

            CheckBox name = convertView.findViewById(R.id.chk_item);
            name.setText(list.get(position));



        }
        return convertView;
    }

}