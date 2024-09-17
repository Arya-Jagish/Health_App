package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuyMedicineBookActivity extends AppCompatActivity {
    EditText edName,edAddress,edContact,edPin;
    Button btnBooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_book);

        edName=findViewById(R.id.editTextBMBUserName);
        edAddress=findViewById(R.id.editTextBMBAddress);
        edContact=findViewById(R.id.editTextBMBContactNo);
        edPin=findViewById(R.id.ediTextBMBPinCode);
        btnBooking=findViewById(R.id.buttonBMBBookAppointment);

        Intent intent=getIntent();
        String[] price=intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date=intent.getStringExtra("date");

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username=sharedPreferences.getString("username","").toString();

                Database db=new Database(getApplicationContext(),"healthcare",null,1);
                db.addOrder(username,edName.getText().toString(),edAddress.getText().toString(),edContact.getText().toString(),Integer.parseInt(edPin.getText().toString()),date.toString(),"",Float.parseFloat(price[1].toString()),"medicine");
                db.removeCart(username,"medicine");
                startActivity(new Intent(BuyMedicineBookActivity.this,HomeActivity.class));
                Toast.makeText(getApplicationContext(), " Booking is done successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}