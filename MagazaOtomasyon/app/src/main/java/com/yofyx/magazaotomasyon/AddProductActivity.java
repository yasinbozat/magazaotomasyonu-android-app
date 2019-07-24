package com.yofyx.magazaotomasyon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class AddProductActivity extends AppCompatActivity implements


        AdapterView.OnItemSelectedListener {
    String[] urunturu = { " ","Pantolon", "Tişört", "Gömlek", "Şort", "Mont"};
    String[] beden = { " ","a", "b", "c", "d", "e"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        //FULL SCREEN CODES ------------------------------------------------------------------------
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it


        Spinner spin2 = (Spinner) findViewById(R.id.bedenSpın) ;
        //-----------------------------------------------------------------------------
        spin2.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter bb = new ArrayAdapter(this,android.R.layout.simple_spinner_item,beden);
          bb.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //Setting the ArrayAdapter data on the Spinner
        spin2.setAdapter(bb);
       //-----------------------------------------------------------------------------
        Spinner spin = (Spinner) findViewById(R.id.urunTuruSpın);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa =
                new ArrayAdapter(this,android.R.layout.simple_spinner_item,urunturu);
        aa.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position , long id) {


    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}


