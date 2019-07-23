package com.yofyx.magazaotomasyon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_AddProduct,btn_DeleteProduct,btn_UpdateProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //FULL SCREEN CODES ------------------------------------------------------------------------
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //------------------------------------------------------------------------------------------

        //BUTTONS ----------------------------------------------------------------------------------
        btn_AddProduct = findViewById(R.id.btn_AddProduct);
        btn_DeleteProduct = findViewById(R.id.btn_DeleteProduct);
        btn_UpdateProduct = findViewById(R.id.btn_UpdateProduct);
        //------------------------------------------------------------------------------------------

        btn_AddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        

        btn_DeleteProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        btn_UpdateProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,UpdateProductActivity.class);
                startActivity(i);
            }
        });



    }
}
