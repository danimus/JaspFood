package com.mc.jaspfood;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<Food> aA;

    public CustomListAdapter(Activity context, ArrayList<Food> a) {
        super(context, R.layout.ranking_item);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.aA=a;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.ranking_item, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(aA.get(position).getDescription());

        extratxt.setText(aA.get(position).getVotes()+"");
        return rowView;

    };
}
