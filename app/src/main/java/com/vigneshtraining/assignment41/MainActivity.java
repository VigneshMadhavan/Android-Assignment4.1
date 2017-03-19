package com.vigneshtraining.assignment41;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends ListActivity implements View.OnClickListener {
    private Button asBtn;
    private Button decBtn;
    private ArrayAdapter adapter;
    private  Toast toast;
    private String[] months=new String[]{"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        asBtn = (Button) findViewById(R.id.ascendBtn);
        decBtn = (Button) findViewById(R.id.decendBtn);

        asBtn.setOnClickListener(this);
        decBtn.setOnClickListener(this);

        Arrays.sort(months);

        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,months);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if(toast!=null){
            toast.cancel();
        }

        toast= Toast.makeText(this,months[position], Toast.LENGTH_SHORT);
        toast.show();

    }

    @Override
    public void onClick(View v) {
        //Toast.makeText(this,"Clicked", Toast.LENGTH_SHORT).show();
        switch (v.getId()){

            case R.id.ascendBtn:
                Arrays.sort(months);
                adapter.notifyDataSetChanged();
                break;

            case R.id.decendBtn:
                Arrays.sort(months,Collections.<String>reverseOrder());
                adapter.notifyDataSetChanged();
                break;

        }
    }
}
