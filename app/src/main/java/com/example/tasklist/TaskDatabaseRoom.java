package com.example.tasklist;

import android.content.Context;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.Room;
import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ListTask.class}, version = 1, exportSchema = false)
public abstract class TaskDatabaseRoom extends RoomDatabase {
    public abstract TaskDao taskDao();

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            int iv_tanggal = R.drawable.pngegg;
            int iv_jam = R.drawable.clock;
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                TaskDao dao = INSTANCE.taskDao();

                ListTask tugas1 = new ListTask("AI", "08-04-2021", iv_tanggal, "23:59", iv_jam);
                dao.insert(tugas1);
//
                ListTask tugas = new ListTask("Machine Learning", "08-04-2021", iv_tanggal, "23:59", iv_jam);
                dao.insert(tugas);
            });
        }
    };

    private static volatile TaskDatabaseRoom INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static TaskDatabaseRoom getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TaskDatabaseRoom.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TaskDatabaseRoom.class, "word_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
