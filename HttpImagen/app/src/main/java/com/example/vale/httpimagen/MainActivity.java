package com.example.vale.httpimagen;

import android.graphics.Bitmap;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.google.gson.Gson;


public class MainActivity extends AppCompatActivity {

    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
        if(savedInstanceState!=null){
            //Se tiene guardado el bitmap en el bundle.
            Bitmap bitmap=savedInstanceState.getParcelable("imagen");
            //Seteamos la imagen.
            setImagen(bitmap);

        }else {

            DescargaImagenes di = new DescargaImagenes(this);

            // GARBAGE COLLECTOR

            try {
                di.execute("http://www.hrsanroque.com/galeria/slider/18.jpg");
            } catch (Throwable t) {
                Log.e(getClass().getCanonicalName(), "Error descargando la imagen", t);
            }

        }

         **/
/*
       CalculaLetraDni cl = new CalculaLetraDni();



        try
        {
            cl.execute();
        }
        catch (Throwable t)
        {
            Log.e(getClass().getCanonicalName(), "Error", t);
        }*/

        Persona persona=new Persona(12,"Fernando");
        //Transformamos un objeto y lo serializamos a JSON
        Gson gson= new Gson();
        String personaJson=gson.toJson(persona);
        Log.d("MENSAJE","Persona en formato JSON: "+personaJson);
        //Para transformar un JSON en objeto Java.
        Persona persona1=gson.fromJson(personaJson,Persona.class);
        Log.d("MENSAJE","Deserializamos el JSON Persona p1 deserializada "+persona1.toString());



    }

    public void setImagen (Bitmap bitmap)
    {

        ImageView img = (ImageView) findViewById(R.id.imageView);
        this.bitmap=bitmap;
        img.setImageBitmap(bitmap);


    }


    /*
    @Override
    public void onSaveInstanceState(Bundle outState) {
        //Guardamos la imagen en el bundle.
        outState.putParcelable("imagen",bitmap);
        super.onSaveInstanceState(outState);
    }*/
}
