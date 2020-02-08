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

public class company_Annual_Income extends AppCompatActivity {

    private Spinner spinner1;
    private Button btnSubmit;
    TextView invs,Tsh,Tlib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company__annual__income);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        invs=(TextView)findViewById(R.id.CompnayInvestments);
        Tsh=(TextView)findViewById(R.id.CompnayTotalshareholdersequity);
        Tlib=(TextView)findViewById(R.id.CompanyTotalliabilities);


        btnSubmit=(Button)findViewById(R.id.buttonconvert);
        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Anuual_Income s=new Anuual_Income();
                String companyname=String.valueOf(spinner1.getSelectedItem());


                try {

                    String result=s.Anuual_Income(companyname);
                    JSONObject jsonObj = new JSONObject(result);

                    JSONArray companyrateg = jsonObj.getJSONArray("financials");
                //    JSONObject jsonObject2=new JSONObject(companyrateg);
                    for(int i = 0; i < companyrateg.length();i++) {
                        JSONObject elem = companyrateg.getJSONObject(i);
                      //  System.out.println(elem);
                       // String h=elem.getString("Gross Profit");
                        String Compnayinv=elem.getString("Gross Profit");
                        invs.setText("Compnay Profit :"+Compnayinv);
                        String companyeq=elem.getString("Net Income");
                        Tsh.setText("Net Income:"+companyeq);
                        String Companylb=elem.getString("Earnings before Tax");
                        Tlib.setText("Earnings before Tax :"+Companylb);
                        break;
                    }
               /*
              */
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }});
    }
}
