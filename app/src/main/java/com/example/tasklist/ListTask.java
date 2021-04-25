package com.example.tasklist;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "DataTugas")
public class ListTask {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "TaskName")
    private String taskName;
    @ColumnInfo(name = "Tanggal")
    private String tanggalPengumpulan;
    private String jam;
    private int iv_jam;
    private int iv_tanggal;
    public ListTask(String taskName, String tanggalPengumpulan, int iv_tanggal, String jam, int iv_jam) {
        this.taskName = taskName;
        this.tanggalPengumpulan = tanggalPengumpulan;
        this.iv_tanggal = iv_tanggal;
        this.jam = jam;
        this.iv_jam = iv_jam;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskNote) {
        this.taskName = taskName;
    }
    public String getTanggalPengumpulan() {
        return tanggalPengumpulan;
    }
    public void setTanggalPengumpulan(String tanggalPengumpulan) {
        this.tanggalPengumpulan = tanggalPengumpulan;
    }

    public int getIv_jam() {
        return iv_jam;
    }

    public void setIv_jam(int iv_jam) {
        this.iv_jam = iv_jam;
    }

    public int getIv_tanggal() {
        return iv_tanggal;
    }

    public void setIv_tanggal(int iv_tanggal) {
        this.iv_tanggal = iv_tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }
}
