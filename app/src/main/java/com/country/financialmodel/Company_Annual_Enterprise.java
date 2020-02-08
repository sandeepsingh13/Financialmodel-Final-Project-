package com.country.financialmodel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Company_Annual_Enterprise extends AppCompatActivity {

    private Spinner spinner1;
    private Button btnSubmit;
     TextView entr,stp,ns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company__annual__enterprise);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        entr=(TextView)findViewById(R.id.enterpriseValues);
        stp=(TextView)findViewById(R.id.StockPrice);
        ns=(TextView)findViewById(R.id.NumberofShares);
        spinner1 = (Spinner) findViewById(R.id.spinner1);


        btnSubmit=(Button)findViewById(R.id.buttonconvert);
        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Annual_Enterprise s=new Annual_Enterprise();
                String companyname=String.valueOf(spinner1.getSelectedItem());


                try {
                    String result=s.Annual_Enterprise(companyname);

                    JSONObject jsonObj = new JSONObject(result);



                  //  System.out.println(jsonObject2);
                    JSONArray entrs = jsonObj.getJSONArray("enterpriseValues");
                    for(int i = 0; i < entrs.length();i++) {
                        JSONObject elem = entrs.getJSONObject(i);

                        String Compnaystock = elem.getString("Stock Price");
                        stp.setText("Company Stock :" + Compnaystock);
                        String companyshare = elem.getString("Number of Shares");
                        ns.setText("Company No Of Share :" + companyshare);
                        String Companyentrp = elem.getString("Enterprise Value");
                        entr.setText("Enterprise Value :" + Companyentrp);

                        break;
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }});
    }
}

