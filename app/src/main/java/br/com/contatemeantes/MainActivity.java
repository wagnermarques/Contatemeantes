package br.com.contatemeantes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStartService = (Button) findViewById(R.id.btnStartService);
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(MainActivity.this, ContatemeantesService.class);

                PeriodicWorkRequest.Builder geoInfoWorkerBuilder =
                        new PeriodicWorkRequest.Builder(GeoInfoWorker.class, 15,
                                TimeUnit.MINUTES);
                PeriodicWorkRequest geoInfoPeriodicWork = geoInfoWorkerBuilder.build();
                WorkManager.getInstance().enqueue(geoInfoPeriodicWork);
            }//public void onClick(View v) {
        });
    }
}