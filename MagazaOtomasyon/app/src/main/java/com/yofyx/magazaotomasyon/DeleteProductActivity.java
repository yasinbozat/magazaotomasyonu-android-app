package com.yofyx.magazaotomasyon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class DeleteProductActivity extends AppCompatActivity {

    Button btn_deleteId;
    EditText delete_Id;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_product);
        //FULL SCREEN CODES ------------------------------------------------------------------------
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //------------------------------------------------------------------------------------------
        btn_deleteId = findViewById(R.id.btn_deleteId);
        delete_Id = findViewById(R.id.delete_Id);


        final String stringId = delete_Id.toString();


        btn_deleteId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // VeriTabanı classımızı tanımlıyoruz
               DataBase db = new DataBase(DeleteProductActivity.this);
               Integer intId = Integer.parseInt(stringId);
                db.VeriSil(intId);

            }
        });





    }
}
