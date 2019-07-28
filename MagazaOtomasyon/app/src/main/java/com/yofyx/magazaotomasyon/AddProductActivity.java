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

import java.util.List;

public class AddProductActivity extends AppCompatActivity {

    private List<String> list_productType;//Spinnerlara sqlden çekilen verileri tutmak için.

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
        ProductTypeSpinnerValues();




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
    private void ProductTypeSpinnerValues()
    {


        list_productType = db.getProductType();
        ArrayAdapter<String> spinner_adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item, list_productType);
        spinner_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spnProductType.setAdapter(spinner_adapter);

    }


}