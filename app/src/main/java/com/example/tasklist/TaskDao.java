package com.example.tasklist;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

@Dao
public interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ListTask tugas);

    @Query("DELETE FROM DataTugas Where TaskName = :Dnama")
    void delete(String Dnama);

    @Query("SELECT * FROM DataTugas ORDER BY Tanggal, jam ASC ")
    LiveData<List<ListTask>> getAlphabetizedTugas();
}
