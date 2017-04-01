package com.example.vale.httpimagen;

import android.graphics.Bitmap;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;


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

       CalculaLetraDni cl = new CalculaLetraDni();


        try
        {
            cl.execute();
        }
        catch (Throwable t)
        {
            Log.e(getClass().getCanonicalName(), "Error", t);
        }


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
