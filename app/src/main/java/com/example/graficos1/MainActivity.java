package com.example.graficos1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int indice = -1;
    int imagenes[] = {
            R.drawable.aries,
            R.drawable.tauro,
            R.drawable.cancer,
            R.drawable.leo,
            R.drawable.virgo,
            R.drawable.libra,
            R.drawable.escorpion,
            R.drawable.sagitario,
            R.drawable.capricornio,
            R.drawable.acuario,
            R.drawable.piscis
    };
    String textos[] = {
            "Aries",
            "Tauro",
            "Cancer",
            "Leo",
            "Virgo",
            "Libra",
            "Escorpion",
            "Sagitario",
            "Capricornio",
            "Acuario",
            "Piscis"
    };
    private ImageView pimg;
    private TextView nomImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pimg = (ImageView) findViewById(R.id.imageView);
        nomImg = (TextView) findViewById(R.id.textView );
    }

    public void antes(View vista) {
        indice--;
        if (indice<0) indice=10;
        nomImg.setText(textos[indice]);
        pimg.setImageResource(imagenes[indice]);
    }

    public void ocultar(View vista) {

    }

    public void siguiente(View vista) {
        indice++;
        if (indice>10) indice=0;
        nomImg.setText(textos[indice]);
        pimg.setImageResource(imagenes[indice]);
    }
}
