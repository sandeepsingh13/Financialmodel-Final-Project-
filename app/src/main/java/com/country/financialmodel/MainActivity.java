package com.country.financialmodel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView compnayprofile,compnyanu,compnayrtng,compnayentr,exitss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        compnayprofile=(ImageView)findViewById(R.id.img2);
        compnayrtng=(ImageView)findViewById(R.id.img3);
        compnayentr=(ImageView)findViewById(R.id.img4);
        exitss=(ImageView)findViewById(R.id.exts);
        compnayprofile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                startActivity(new Intent(getApplicationContext(), CompanyProfile.class));
            }

        });

        compnyanu=(ImageView)findViewById(R.id.anul);
        compnyanu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                startActivity(new Intent(getApplicationContext(),company_Annual_Income.class));
            }

        });

        compnayrtng.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                startActivity(new Intent(getApplicationContext(),Company_Rating.class));
            }

        });

        compnayentr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                startActivity(new Intent(getApplicationContext(),Company_Annual_Enterprise.class));
            }

        });
        exitss.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                finish();
                System.exit(0);
            }

        });
    }
}
