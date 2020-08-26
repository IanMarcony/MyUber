package com.ianmarcony.myuber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListUberAdapter extends ArrayAdapter<CarUberItem> {
    private Context context;
    private List<CarUberItem> items;

    public ListUberAdapter( Context context, List<CarUberItem> items) {
        super(context, R.layout.layout_list, items);
        this.context=context;
        this.items=items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.layout_list,parent,false);

        ImageView imageUber = rowView.findViewById(R.id.image_uber_list);
        TextView textDescription = rowView.findViewById(R.id.text_description_uber_list);
        TextView textCash = rowView.findViewById(R.id.text_value_uber_list);


        imageUber.setImageResource(items.get(position).getImageCar());
        textDescription.setText(items.get(position).getTextDescription());
        textCash.setText(items.get(position).getCash());

        return rowView;

    }
}
