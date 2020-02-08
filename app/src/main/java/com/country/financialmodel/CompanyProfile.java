package com.country.financialmodel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class CompanyProfile extends AppCompatActivity {


    private Spinner spinner1;
    private Button btnSubmit;
    ImageView companyimage;
    TextView name,price,website,descrptn,ceo,sector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_profile);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        companyimage=(ImageView) findViewById(R.id.companyimage);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
         name=(TextView)findViewById(R.id.cname);
         price=(TextView)findViewById(R.id.cprice);
         website=(TextView)findViewById(R.id.website);
         descrptn=(TextView)findViewById(R.id.descpt);
         ceo=(TextView)findViewById(R.id.ceo);
         sector=(TextView)findViewById(R.id.sectr);
        btnSubmit=(Button)findViewById(R.id.buttonconvert);
        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Getcompanydata s=new Getcompanydata();
                String companyname=String.valueOf(spinner1.getSelectedItem());
                try {
                    String result=s.companyinfo(companyname);

                    JSONObject jsonObj = new JSONObject(result);
                   String companyprofile = jsonObj.getString("profile");
                   JSONObject jsonObject2=new JSONObject(companyprofile);
                   String Compnayprice=jsonObject2.getString("price");
                   price.setText("Company Price :"+Compnayprice);
                    String companyName=jsonObject2.getString("companyName");
                    name.setText("Company Name :"+companyName);
                    String Website=jsonObject2.getString("website");
                    website.setText("Web :"+Website);
                    String description=jsonObject2.getString("description");
                    descrptn.setText(description);
                    String  Ceo=jsonObject2.getString("ceo");
                     ceo.setText("Ceo :"+Ceo);
                     String Sector=jsonObject2.getString("sector");
                      sector.setText("Sector :"+Sector);
                    String imgurl=jsonObject2.getString("image");
                    Picasso.get().load(imgurl).into(companyimage);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }});
            }
    }

