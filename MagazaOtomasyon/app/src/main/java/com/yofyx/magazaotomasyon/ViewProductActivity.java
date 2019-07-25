package com.yofyx.magazaotomasyon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ViewProductActivity extends AppCompatActivity {

    ListView lv_View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_product);
        //FULL SCREEN CODES ------------------------------------------------------------------------
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //------------------------------------------------------------------------------------------

        lv_View = findViewById(R.id.lv_View);

        Listele();

    }

    public void Listele(){
        DataBase db = new DataBase(ViewProductActivity.this);
        List<String> view = db.SelectData();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ViewProductActivity.this,
                android.R.layout.simple_list_item_1,android.R.id.text1,view);
        lv_View.setAdapter(adapter);
    }

}
