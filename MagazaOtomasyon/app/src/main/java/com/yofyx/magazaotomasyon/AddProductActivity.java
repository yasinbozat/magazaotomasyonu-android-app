package com.yofyx.magazaotomasyon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddProductActivity extends AppCompatActivity implements


    AdapterView.OnItemSelectedListener {

    String[] urunturu = { " ","Pantolon", "Tişört", "Gömlek", "Şort", "Mont"};
    String[] beden = { " ","a", "b", "c", "d", "e"};

    Button btnAddProduct;
    EditText edtProductName;
    Spinner spnProductType,spnProductSize,spnProductColor;
    DataBase db;
    String productName,productType, productSize, productColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        //FULL SCREEN CODES ------------------------------------------------------------------------
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //------------------------------------------------------------------------------------------
         db = new DataBase(AddProductActivity.this);

        btnAddProduct = findViewById(R.id.btn_addProduct);
        edtProductName = findViewById(R.id.edt_productName);
        spnProductType = findViewById(R.id.spn_productType);
        spnProductSize = findViewById(R.id.spn_productColor);
        spnProductColor = findViewById(R.id.spn_productColor);



        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,
                                                                                             beden);

        spnProductSize.setOnItemSelectedListener(this);
        spnProductType.setOnItemSelectedListener(this);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spnProductSize.setAdapter(adapter);
        spnProductType.setAdapter(adapter);


        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String productName = edtProductName.getText().toString();
                String productType = spnProductType.getSelectedItem().toString();
                String productSize = spnProductSize.getSelectedItem().toString();
                String productColor = spnProductColor.getSelectedItem().toString();
                db.InsertData(productName, productType, productSize, productColor);

            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position , long id) {


    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}


