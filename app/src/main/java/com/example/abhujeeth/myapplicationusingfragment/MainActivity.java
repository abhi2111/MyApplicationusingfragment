package com.example.abhujeeth.myapplicationusingfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.SupportMapFragment;


public class MainActivity extends AppCompatActivity {

    Button button1,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);


    }

   public void getFrag(View view)
    {
        Fragment fragmenta=new FirstFragment();
        Fragment fragmentb=new SecondFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(view == button1)
        {

            SupportMapFragment mapfrag=new SupportMapFragment();

            ft.add(R.id.frag_place,mapfrag,"t");
            ft.addToBackStack("t");
            ft.commit();

        }

        if(view == button2)
        {
            fm.executePendingTransactions();
            Fragment f=fm.findFragmentByTag("t");
            if(f!=null && f.isAdded()) {
                ft.hide(f);
            }
            ft.addToBackStack("g");
            ft.commit();


        }

        if(view == button3)
        {
           if(fragmentb.isAdded())
           {
               ft.hide(fragmentb);
           }

            ft.commit();
        }

    }
    public void onBackPressed()
    {
        if(getFragmentManager().getBackStackEntryCount()>0)
        {
            getFragmentManager().popBackStack();
        }
        else {
        super.onBackPressed();
    }
    }
}
