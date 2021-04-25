package com.example.tasklist;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskRepository {
    private TaskDao mTaskDao;
    private LiveData<List<ListTask>> mAllTask;


    TaskRepository(Application application){
        TaskDatabaseRoom dbTask =TaskDatabaseRoom.getDatabase(application);
        mTaskDao = dbTask.taskDao();
        mAllTask =mTaskDao.getAlphabetizedTugas();
    }

    LiveData<List<ListTask>> getAllTugas() {
        return mAllTask;
    }

    void insert(ListTask task) {
        TaskDatabaseRoom.databaseWriteExecutor.execute(() -> {
            mTaskDao.insert(task);
        });
    }

    void delete(String Dnama) {
        TaskDatabaseRoom.databaseWriteExecutor.execute(() -> {
            mTaskDao.delete(Dnama);
        });

    }
}
