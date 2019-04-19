package com.example.giuaky;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends ArrayAdapter<So> {

    private final List<So> objects;

    private final int resource;

    private final Activity context;

    {
        Activity context;
        int resource;
        List<So> objects;

        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;






        @NonNull
        @Override
        public View getView (int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource,null);

        TextView itemKQ = row.findViewById(R.id.txt_kq);

        So so = this.objects.get(position);

        itemKQ.setText(so.getKq());

        return row;
    }


    }

    public Adapter(List<So> objects) {
        this.objects = objects;
    }

    public void notifyDataSetChanged() {
    }
}