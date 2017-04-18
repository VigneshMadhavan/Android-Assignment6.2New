package com.vigneshtraining.assignment62new.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.vigneshtraining.assignment62new.R;
import com.vigneshtraining.assignment62new.model.ItemObject;

import java.util.ArrayList;

/**
 * Created by vimadhavan on 4/6/2017.
 */

public class ItemAdapter extends BaseAdapter {
    private ArrayList<ItemObject> _data;

    private Context _a;



    public ItemAdapter(ArrayList<ItemObject> _data, Context _a) {
        this._data = _data;
        this._a = _a;
    }

    @Override
    public int getCount() {
        return  _data.size();
    }

    @Override
    public Object getItem(int position) {
        return  _data.get(position);
    }





    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;

        if (view == null) {
            LayoutInflater li = (LayoutInflater) _a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.custom_list, parent,false);
            Log.e("Inside", "here--------------------------- In view1");
            holder = new ViewHolder();

            holder.title = (TextView) view.findViewById(R.id.titleTxt);




            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
            Log.e("Inside", "here--------------------------- In view2");
        }



        ItemObject data = (ItemObject) _data.get(position);
        holder.title.setText(data.getTitle());
        //holder.check.setChecked(data.getCheckedBox());




        return view;
    }

    static class ViewHolder {

        TextView title;

    }
}
