package com.vigneshtraining.assignment62new;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vigneshtraining.assignment62new.model.ItemObject;
import com.vigneshtraining.assignment62new.model.ItemObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyDetailsFragment extends Fragment {

    private ArrayList<ItemObject> data;
    private int selectedIndex;

    public ArrayList<ItemObject> getData() {

        return data;
    }

    public void setData(ArrayList<ItemObject> data) {
        this.data = data;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }
    public MyDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_my_details, container, false);
        TextView titleTxt= (TextView) view.findViewById(R.id.titleTxt1);
        TextView descTxt= (TextView) view.findViewById(R.id.descTxt1);
        try {
            if (selectedIndex>=0) {
                titleTxt.setText(data.get(selectedIndex).getTitle());
                descTxt.setText(data.get(selectedIndex).getDescription());
            }else {
                titleTxt.setText(getResources().getString(R.string.hello_blank_fragment));
                descTxt.setText("");
            }
        }catch (Error er){

        }catch (Exception ex){

        }


        return view;
    }


}
