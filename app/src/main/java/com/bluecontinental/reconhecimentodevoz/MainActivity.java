package com.bluecontinental.reconhecimentodevoz;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements SensorEventListener {


    private static final int REQUEST_CODE = 1234;
    private FloatingActionButton speakButton;
    private SensorManager sManager;
    private View view_fundo;
    private static final String TAG  = "VOICE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sManager.registerListener(this, sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), sManager.SENSOR_DELAY_NORMAL);


        // Desabilita o botao caso nao tenha o servico
        PackageManager pm = getPackageManager();
        List<ResolveInfo> activities = pm.queryIntentActivities(
                new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
        if (activities.size() == 0) {
            speakButton.setEnabled(false);
            Toast.makeText(getApplicationContext(), "Reconhecedor de voz nao encontrado", Toast.LENGTH_LONG).show();
        }
        speakButton = (FloatingActionButton) findViewById (R.id.speakButton);
        speakButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startVoiceRecognitionActivity();
            }
        });

        view_fundo = (View) findViewById(R.id.view_fundo);

    }

    private void startVoiceRecognitionActivity() {
        Log.d(TAG,"startVoiceRecognitionActivity()");
        Intent intent = new Intent();
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "AndroidBite Voice Recognition...");
        startActivityForResult(intent, REQUEST_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG,"inicio de reconhecimento!");
        Log.d(TAG,"requestCode: "+requestCode);
        Log.d(TAG,"resultCode: "+resultCode);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            ArrayList<String> matches = data.getStringArrayListExtra( RecognizerIntent.EXTRA_RESULTS);
            for(int i = 0; i < matches.size();i++) {
                Log.d(TAG,"matches ="+(matches.get(i)));

                if(matches.get(i).equalsIgnoreCase("preta") || matches.get(i).equalsIgnoreCase("preto")) {
                    view_fundo.setBackgroundColor(getResources().getColor(R.color.fundo_preto));
                    Log.d(TAG,"Reconheceu a palavra [Preta]");
                    break;
                }
                if(matches.get(i).equalsIgnoreCase("cinza")) {
                    view_fundo.setBackgroundColor(getResources().getColor(R.color.fundo_cinza));
                    Log.d(TAG,"Reconheceu a palavra [Cinza]");
                    break;
                }
                if(matches.get(i).equalsIgnoreCase("azul")) {
                    view_fundo.setBackgroundColor(getResources().getColor(R.color.fundo_azul));
                    Log.d(TAG,"Reconheceu a palavra [Azul]");
                    break;
                }
                if(matches.get(i).equalsIgnoreCase("vermelha") || matches.get(i).equalsIgnoreCase("vermelho")) {
                    view_fundo.setBackgroundColor(getResources().getColor(R.color.fundo_vermelho));
                    Log.d(TAG,"Reconheceu a palavra [Vermelha]");
                    break;
                }
                if(matches.get(i).equalsIgnoreCase("verde")) {
                    view_fundo.setBackgroundColor(getResources().getColor(R.color.fundo_verde));
                    Log.d(TAG,"Reconheceu a palavra [Verde]");
                    break;
                }
                if(matches.get(i).equalsIgnoreCase("amarela") || matches.get(i).equalsIgnoreCase("amarelo")) {
                    view_fundo.setBackgroundColor(getResources().getColor(R.color.fundo_amarela));
                    Log.d(TAG,"Reconheceu a palavra [Amarela]");
                    break;
                }
            }
        }else{
            Toast.makeText(this,"Não reconheceu a palavra!",Toast.LENGTH_SHORT).show();
            Log.d(TAG,"Não reconheceu nada!");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
