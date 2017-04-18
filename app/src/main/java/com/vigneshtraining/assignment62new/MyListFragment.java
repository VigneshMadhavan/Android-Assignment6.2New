package com.vigneshtraining.assignment62new;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.vigneshtraining.assignment62new.adapter.ItemAdapter;
import com.vigneshtraining.assignment62new.model.ItemObject;

import java.util.ArrayList;


public class MyListFragment extends ListFragment {

    public static String NAME="MyListFragment";

    private ListView listHolder;
    private ItemAdapter adapter;
    public static ArrayList<ItemObject> dataArrayList;
    private FragmentListener myListener;
    private int selectedIndex;



    private String[] titleArr={"Blogger","Facebook","Google","Microsoft","Yahoo","YouTube"};
    private String[] descArr={"Blogger decription..","Facebook decription..","Google decription..","Microsoft decription..","Yahoo decription..","YouTube decription.."};

    public MyListFragment() {
        // Required empty public constructor
    }








    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        myListener=(FragmentListener) context;
        dataArrayList= new ArrayList<ItemObject>();
        for (int i=0;i<titleArr.length;i++){
            ItemObject itemObj=new ItemObject();

            itemObj.setTitle(titleArr[i]);
            itemObj.setDescription(descArr[i]);

            dataArrayList.add(itemObj);
        }
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        adapter=new ItemAdapter(dataArrayList,getContext());
        setListAdapter(adapter);


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_list, container, false);





        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.d("onItemClick", "----------------"+position);
        v.setSelected(true);
        myListener.onItemClicked(position);
        super.onListItemClick(l, v, position, id);
    }


}
