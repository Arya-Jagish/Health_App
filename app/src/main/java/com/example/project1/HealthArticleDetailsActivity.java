package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthArticleDetailsActivity extends AppCompatActivity {
    TextView tv1;
    ImageView img;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_article_details);

        tv1=findViewById(R.id.titleViewHAtitle);
        img=findViewById(R.id.imageViewHA);
        btnBack=findViewById(R.id.ButtonBackHA);

        Intent intent=getIntent();
        tv1.setText(intent.getStringExtra("text1"));

        Bundle bundle=getIntent().getExtras();
        if(bundle !=null){
            int resId=bundle.getInt("text2");
            img.setImageResource(resId);
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthArticleDetailsActivity.this,HealthArticlesActivity.class));
            }
        });

    }
}