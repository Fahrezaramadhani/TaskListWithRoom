package com.example.tasklist;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {
    private TaskRepository mRepository;

    private final LiveData<List<ListTask>> mAllTask;

    public TaskViewModel (Application application) {
        super(application);
        mRepository = new TaskRepository(application);
        mAllTask = mRepository.getAllTugas();
    }

    LiveData<List<ListTask>> getAllWords() { return mAllTask; }
    public void insert(ListTask tugas) { mRepository.insert(tugas); }
    public void delete(String Dnama){mRepository.delete(Dnama);}
}
