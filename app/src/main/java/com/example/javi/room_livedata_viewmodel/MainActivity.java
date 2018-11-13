package com.example.javi.room_livedata_viewmodel;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ClassRepository classRepository = new ClassRepository(getApplication());
        classRepository.getAllUser().observe(this, new Observer<List<ClassEntity>>() {
            @Override
            public void onChanged(@Nullable List<ClassEntity> classEntities) {
                if(classEntities!=null){
                    Log.d("Base de datos", "Listado: "+classEntities.toString());
                }
            }
        });
    }
}
