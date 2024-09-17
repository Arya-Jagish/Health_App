package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1=
            {
                    {"Doctor Name : Dr Ramnath","Hospital Address : KIMS","Exp : 8 yrs","Mobile No:7302510860","500"},
                    {"Doctor Name : Dr Devjith","Hospital Address : Medical Mission","Exp : 6 yrs","Mobile No:7312510860","200"},
                    {"Doctor Name : Dr Sabitha","Hospital Address : Amritha","Exp : 5 yrs","Mobile No:7302510860","500"},
                    {"Doctor Name : Dr Raghuram","Hospital Address : KIMS","Exp : 12 yrs","Mobile No:7302510860","300"},
                    {"Doctor Name : Dr Rishikesh","Hospital Address : PRS","Exp : 4 yrs","Mobile No:7302510860","200"}
            };

    private String[][] doctor_details2=
            {
                    {"Doctor Name : Dr Manu","Hospital Address : KIMS","Exp : 8 yrs","Mobile No:8302510860","500"},
                    {"Doctor Name : Dr Mahesh","Hospital Address : Medical Mission","Exp : 6 yrs","Mobile No:7303510860","500"},
                    {"Doctor Name : Dr Devipriya","Hospital Address : Amritha","Exp : 5 yrs","Mobile No:7302512860","200"},
                    {"Doctor Name : Dr Gayathri","Hospital Address : KIMS","Exp : 12 yrs","Mobile No:7302510870","300"},
                    {"Doctor Name : Dr Amitha","Hospital Address : PRS","Exp : 4 yrs","Mobile No:7302510865","500"}
            };

    private String[][] doctor_details3=
            {
                    {"Doctor Name : Dr Devika","Hospital Address : KIMS","Exp : 8 yrs","Mobile No:7302510860","500"},
                    {"Doctor Name : Dr Praveen","Hospital Address : Medical Mission","Exp : 6 yrs","Mobile No:7302510860","500"},
                    {"Doctor Name : Dr Manoj","Hospital Address : Amritha","Exp : 5 yrs","Mobile No:7302510860","250"},
                    {"Doctor Name : Dr Ashutosh","Hospital Address : KIMS","Exp : 12 yrs","Mobile No:7302510860","500"},
                    {"Doctor Name : Dr Renjith","Hospital Address : PRS","Exp : 4 yrs","Mobile No:7302510860","300"}
            };

    private String[][] doctor_details4=
            {
                    {"Doctor Name : Dr Amal","Hospital Address : KIMS","Exp : 8 yrs","Mobile No:7302510860","500"},
                    {"Doctor Name : Dr Kalyani","Hospital Address : Medical Mission","Exp : 6 yrs","Mobile No:7302510860","400"},
                    {"Doctor Name : Dr Madhavi","Hospital Address : Medical Mission","Exp : 6 yrs","Mobile No:7302510860","500"},
                    {"Doctor Name : Dr Aman","Hospital Address : KIMS","Exp : 12 yrs","Mobile No:7302510860","100"},
                    {"Doctor Name : Dr Nithin","Hospital Address : PRS","Exp : 4 yrs","Mobile No:7302510860","500"}
            };

    private String[][] doctor_details5=
            {
                    {"Doctor Name : Dr Aishwarya","Hospital Address : KIMS","Exp : 8 yrs","Mobile No:7302510860","500"},
                    {"Doctor Name : Dr Bindu","Hospital Address : Medical Mission","Exp : 6 yrs","Mobile No:7302510860","200"},
                    {"Doctor Name : Dr Jitha","Hospital Address : Amritha","Exp : 5 yrs","Mobile No:7302510860","300"},
                    {"Doctor Name : Dr Sherly","Hospital Address : KIMS","Exp : 12 yrs","Mobile No:7302510860","150"},
                    {"Doctor Name : Dr Meenakshi","Hospital Address : PRS","Exp : 4 yrs","Mobile No:7302510860","300"},
            };
    TextView tv;
    Button btn;
    String[][] doctor_details={};
    ArrayList list;
    HashMap<String,String> item;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewBuyMCartDetails);
        btn=findViewById(R.id.ButtonDDBack);

        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physician")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));

            }
        });

        list=new ArrayList();
        for(int i=0;i< doctor_details.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Consultant Fees: "+doctor_details[i][4] +"/-");
            list.add(item);

        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst=findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });


    }
}