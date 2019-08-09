package com.example.graficos1;
import android.hardware.Sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
// import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int indice = 0;
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
    // sensor
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pimg = (ImageView) findViewById(R.id.imageView);
        nomImg = (TextView) findViewById(R.id.textView );
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (sensor == null) finish();

        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float x = sensorEvent.values[0];
                System.out.println("valor de giro " + x);
                if (x < 1 && x > -1) contador = 1;
                if (x > 5 && contador==1) {
                    indice--;
                    if (indice<0) indice=10;
                    nomImg.setText(textos[indice]);
                    pimg.setImageResource(imagenes[indice]);
                    contador = 0;
                } else if (x < -5 && contador==1) {
                    indice++;
                    if (indice>10) indice=0;
                    nomImg.setText(textos[indice]);
                    pimg.setImageResource(imagenes[indice]);
                    contador = 0;
                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        start();
    }

    public void start() {
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
    public void stop() {
        sensorManager.unregisterListener(sensorEventListener);
     }

    @Override
    protected void onPause() {
        stop();
        super.onPause();
    }

    @Override
    protected void onResume() {
        start();
        super.onResume();
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
