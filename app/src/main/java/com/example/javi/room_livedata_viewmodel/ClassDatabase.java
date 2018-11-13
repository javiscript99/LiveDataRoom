package com.example.javi.room_livedata_viewmodel;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;


@Database(entities = {ClassEntity.class},version = 1)
public abstract class ClassDatabase extends RoomDatabase {

    public abstract ClassDao classDAO();
    private static ClassDatabase INSTANCE;

    static ClassDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ClassDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ClassDatabase.class, " class_database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .addCallback(callbackData)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    static Callback callbackData = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            (new ClassAsyncTask(INSTANCE)).execute();

        }
    };

    private static class ClassAsyncTask extends AsyncTask<Void,Void,Void> {

        public ClassDao classDAO;

        public ClassAsyncTask(ClassDatabase instance) {
            classDAO = instance.classDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {


            ClassEntity one = new ClassEntity(1,"pepe","juan","1C","DAM", "DAM");
            ClassEntity two = new ClassEntity(2,"pepe","juan","1C","Ricardo","DAM");
            ClassEntity three = new ClassEntity(3,"pepe","juan","1C","Julian","DAM");
            ClassEntity four = new ClassEntity(4,"pepe","juan","1C","Juaquin","DAM");
            ClassEntity five = new ClassEntity(5,"pepe","juan","1C","Laura","DAM");
            ClassEntity six = new ClassEntity(6,"pepe","juan","1C","Alberto","DAM");
            ClassEntity sevent = new ClassEntity(7,"pepe","juan","1C","Jaime","DAM");
            ClassEntity eight = new ClassEntity(8,"pepe","juan","1C","Jorge","DAM");
            ClassEntity nine = new ClassEntity(9,"pepe","juan","1C","Carlos","DAM");
            ClassEntity ten = new ClassEntity(10,"pepe","juan","1C","Pedro","DAM");
            List<ClassEntity> data = new ArrayList<>();


            data.add(one);
            data.add(two);
            data.add(three);
            data.add(four);
            data.add(five);
            data.add(six);
            data.add(sevent);
            data.add(eight);
            data.add(nine);
            data.add(ten);

            classDAO.deleteAll();
            classDAO.insertAll(data);
            return null;
        }
    }

}
