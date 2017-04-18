package com.vigneshtraining.assignment62new;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements FragmentListener {


    private Toast myToast;


    private int selectedIndex=-1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Log.d("Debug:onCreate::", selectedIndex+"==ORIENTATION_LANDSCAPE==Layout=="+getResources().getConfiguration().orientation);

        if(savedInstanceState!=null){
            selectedIndex=savedInstanceState.getInt("selected");
        }



        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE ){
            FragmentManager frgMng=getSupportFragmentManager();
            FragmentTransaction frgTxn=frgMng.beginTransaction();
            MyDetailsFragment myDetailFragment=new MyDetailsFragment();
            myDetailFragment.setData(MyListFragment.dataArrayList);
            myDetailFragment.setSelectedIndex(selectedIndex);
            if(frgMng.getFragments().size()>0){
                frgTxn.add(R.id.fragmentContainer,myDetailFragment);
            }else{
                frgTxn.replace(R.id.fragmentContainer,myDetailFragment);
            }

            frgTxn.commit();
        }






    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("selected",selectedIndex);
    }

    /*private int getSizeName(Context context) {
        int screenLayout = context.getResources().getConfiguration().screenLayout;
        screenLayout &= Configuration.SCREENLAYOUT_SIZE_MASK;
        //Log.d("Debug:onCreate::", screenLayout+"====getSizeName=="+context.getResources().getConfiguration().orientation);
        return screenLayout;

        *//*switch (screenLayout) {
            case Configuration.SCREENLAYOUT_SIZE_SMALL:
                return "small";
            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                return "normal";
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
                return "large";
            case Configuration.SCREENLAYOUT_SIZE_XLARGE :
                return "xlarge";
            default:
                return "undefined";
        }*//*
    }*/



    @Override
    public void onItemClicked(int Index) {
        selectedIndex=Index;
        //Log.d("MAIN", "===Layout=="+getResources().getConfiguration().orientation+"---MM---"+MyListFragment.dataArrayList.get(selectedIndex).getTitle());
        if(myToast!=null){
            myToast.cancel();

        }

       if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
            myToast= Toast.makeText(MainActivity.this,"Change the Fragment---"+MyListFragment.dataArrayList.get(selectedIndex).getTitle(),Toast.LENGTH_LONG);
            myToast.show();
            FragmentManager frgMng=getSupportFragmentManager();
            FragmentTransaction frgTxn=frgMng.beginTransaction();
            MyDetailsFragment myDetailFragment=new MyDetailsFragment();
            myDetailFragment.setData(MyListFragment.dataArrayList);
            myDetailFragment.setSelectedIndex(selectedIndex);

            frgTxn.replace(R.id.fragmentContainer,myDetailFragment);
            frgTxn.commit();
        }else{
            myToast= Toast.makeText(MainActivity.this,"Launch tha Activity---"+MyListFragment.dataArrayList.get(selectedIndex).getTitle(),Toast.LENGTH_LONG);
            myToast.show();
            Intent detailIntent=new Intent(MainActivity.this,DetailActivity.class);
            detailIntent.putExtra(DetailActivity.TITLE,MyListFragment.dataArrayList.get(selectedIndex).getTitle());
            detailIntent.putExtra(DetailActivity.DECRIPTION,MyListFragment.dataArrayList.get(selectedIndex).getDescription());
            detailIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(detailIntent);


        }

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        finish();
        return;
    }
}
