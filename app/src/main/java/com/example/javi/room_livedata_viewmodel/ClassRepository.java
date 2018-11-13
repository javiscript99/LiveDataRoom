package com.example.javi.room_livedata_viewmodel;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class ClassRepository {
    private ClassDao studentDao;
    private LiveData<List<ClassEntity>> allUser;

    public ClassRepository(Application application) {
        ClassDatabase db = ClassDatabase.getDatabase(application);
        studentDao = db.classDAO();
        allUser = studentDao.getAllWords();
    }

    public LiveData<List<ClassEntity>> getAllUser() {
        return allUser;
    }

    public void insert(ClassEntity userEntity) {
        new insertAsyncTask(studentDao).execute(userEntity);
    }

    private static class insertAsyncTask extends AsyncTask<ClassEntity, Void, Void> {

        private ClassDao masynctaskdao;

        insertAsyncTask(ClassDao dao) {
            masynctaskdao = dao;
        }

        @Override
        protected Void doInBackground(final ClassEntity... params) {
            masynctaskdao.insert(params[0]);
            return null;
        }
    }
}
