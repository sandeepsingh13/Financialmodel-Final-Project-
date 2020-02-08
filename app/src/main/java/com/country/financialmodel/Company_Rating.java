package com.country.financialmodel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class Company_Rating extends AppCompatActivity {

    private Spinner spinner1;
    private Button btnSubmit;
    TextView Ratings,scores,recmnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company__rating);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Ratings=(TextView)findViewById(R.id.Rating);
        scores=(TextView)findViewById(R.id.Score);
        recmnd=(TextView)findViewById(R.id.recommendation);
        spinner1 = (Spinner) findViewById(R.id.spinner1);


        btnSubmit=(Button)findViewById(R.id.buttonconvert);
        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Annual_Rating s=new Annual_Rating();
                String companyname=String.valueOf(spinner1.getSelectedItem());


                try {
                    String result=s.Annual_Rating(companyname);

                    JSONObject jsonObj = new JSONObject(result);
                    String companyrateg = jsonObj.getString("rating");
                    JSONObject jsonObject2=new JSONObject(companyrateg);
                    String Compnayscore=jsonObject2.getString("score");
                    Ratings.setText("Company Score :"+Compnayscore);
                    String companyrating=jsonObject2.getString("rating");
                    scores.setText("Company Rating :"+companyrating);
                    String Companyrecommendation=jsonObject2.getString("recommendation");
                    recmnd.setText("Recommendation :"+Companyrecommendation);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }});
    }
}
