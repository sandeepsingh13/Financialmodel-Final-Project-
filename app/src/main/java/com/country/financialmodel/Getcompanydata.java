package com.country.financialmodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

public class Getcompanydata {

    String companyinfo(String name)
    {
    String jk="";

        URL url = null;
        try {
            url = new URL("https://financialmodelingprep.com/api/v3/company/profile/"+name);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
            for (String line; (line = reader.readLine()) != null; ) {
                jk += line;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jk;
    }

}

