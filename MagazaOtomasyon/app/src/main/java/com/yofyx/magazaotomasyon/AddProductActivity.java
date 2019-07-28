package com.yofyx.magazaotomasyon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class AddProductActivity extends AppCompatActivity {

    Button btnAddProduct;
    EditText edtProductName;
    Spinner spnProductType,spnProductSize,spnProductColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        //FULL SCREEN CODES ------------------------------------------------------------------------
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                                                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //------------------------------------------------------------------------------------------

        btnAddProduct = findViewById(R.id.btn_addProduct);
        edtProductName = findViewById(R.id.edt_productName);
        spnProductType = findViewById(R.id.spn_productType);
        spnProductSize = findViewById(R.id.spn_productSize);
        spnProductColor = findViewById(R.id.spn_productColor);

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    DataBase db = new DataBase(AddProductActivity.this);
                    String productName = edtProductName.getText().toString();
                    //String productType = spnProductType.getSelectedItem().toString();
                    //String productSize = spnProductSize.getSelectedItem().toString();
                    //String productColor = spnProductColor.getSelectedItem().toString();
                    db.InsertData(productName, "Pantolon", "38", "mavi");
                }catch (Exception e){
                    Log.d("DEBUG", String.valueOf(e));

                }
            }
        });
    }
}