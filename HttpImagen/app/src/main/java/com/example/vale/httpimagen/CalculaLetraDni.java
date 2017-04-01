package com.example.vale.httpimagen;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by formador on 1/4/17.
 */

public class CalculaLetraDni extends AsyncTask<Void, Void, String> {

    @Override
    protected String doInBackground(Void... params) {
        String letra_dni = null;
        HttpURLConnection httpURLConnection = null;
        URL url = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader br = null;
        int letra_char = 0;

        try {

            url = new URL("http://femxa-ebtm.rhcloud.com/CalcularLetraDni?dni=53130984");
            httpURLConnection = (HttpURLConnection) url.openConnection();

            if (httpURLConnection.getResponseCode()== HttpURLConnection.HTTP_OK)
            {
                //Leer bytes en crudo.
                InputStream is = httpURLConnection.getInputStream();
                letra_char = is.read();


                //Permite leer texto
                //InputStreamReader isr = new InputStreamReader(is);
                //br = new BufferedReader(isr);

                //letra_dni = br.readLine();

                is.close();
            }

        } catch (Throwable t)
        {
            Log.e("MENSAJE", "ERROR", t);
        }
        finally {
            httpURLConnection.disconnect();
        }


        return letra_dni;

    }
}
