package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages =
            {
                    {"Acetaminophen","","","","50"},
                    {"Azithromycin","","","","300"},
                    {"Ibuprofen","","","","425"},
                    {"Amlodipine","","","","350"},
                    {"Trazodone","","","","100"},
                    {"Paracetamol","","","","123"},
                    {"Amoxicillin","","","","250"},
                    {"Dolo","","","","200"},
                    {"Lexapro","","","","140"}
            };
    private String[] package_details = {
            "Antipyretic agent used to treat fever and mild to moderate pain\n" +
                    "It is a widely used over the counter medication \n" +
                    "common brand names include Tylenol and Panadol.\n ",

            "Paracetamol (acetaminophen or para-hydroxyacetanilide) is a non-opioid analgesic\n " +
                    "and antipyretic agent used to treat fever and\n " +
                    "mild to moderate pain.\n",

            "Ibuprofen is a nonsteroidal anti-inflammatory drug that is used to relieve pain, fever, and inflammation.\n " +
                    "This includes painful menstrual periods, migraines, and rheumatoid arthritis.\n " +
                    "It may also be used to close a patent ductus arteriosus in a premature baby.\n ",

            "Amlodipine, sold under the brand name Norvasc among others, is a calcium channel blocker medication used \n" +
                    "to treat high blood pressure, coronary artery disease and variant angina. \n" +
                    "It is taken orally. Common side effects include swelling, feeling tired, abdominal pain, and nausea. \n",

            "Trazodone, sold under many brand names, is an antidepressant medication.\n " +
                    "It is used to treat major depressive disorder, anxiety disorders, and difficulties with sleep.\n " +
                    "The medication is taken orally. Common side-effects include dry mouth, feeling faint, vomiting, and headache.\n ",

            "Paracetamol (Panadol, Calpol, Alvedon) is an analgesic and antipyretic drug \n" +
                    "that is used to temporarily relieve mild-to-moderate pain and fever. \n" +
                    "It is commonly included as an ingredient in cold and flu medications and is also used on its own.\n ",

            "It is used to treat bacterial infections, such as chest infections (including pneumonia) and dental abscesses. \n" +
                    "It can also be used together with other antibiotics and medicines to treat stomach ulcers.\n " +
                    "It's often prescribed for children, to treat ear infections and chest infections.\n",

            "Dolo 650 can be used for headaches, mild to high fevers, and any other type of bodily aches. \n" +
                    "It is usually prescribed by doctors in case of recurrent high fevers. \n" +
                    "Dolo 650 medicine can also be used for toothaches and certain types of inner or middle ear pains.\n",

            "Escitalopram, sold under the brand names Lexapro and Cipralex, among others,\n" +
                    " is an antidepressant of the selective serotonin reuptake inhibitor class. \n" +
                    "Escitalopram is mainly used to treat major depressive disorder and generalized anxiety disorder. \n"

            };

    HashMap<String,String > item;
    ArrayList list;
    SimpleAdapter sa;
    ListView listView;
    Button btnBack,btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        listView=findViewById(R.id.listViewHA);
        btnBack=findViewById(R.id.ButtonBuyMedicinesBack);
        btnGoToCart=findViewById(R.id.buttonBuyMCartBack);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicinesActivity.class));
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost:"+packages[i][4]+"/-");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });

    }
}