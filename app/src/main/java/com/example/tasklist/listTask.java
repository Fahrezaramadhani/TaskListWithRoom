package com.example.tasklist;

public class listTask {
    private String taskNote;
    private String tanggalPengumpulan;
    private String jam;
    private int iv_jam;
    private int iv_tanggal;
    public listTask(String taskNote, String tanggalPengumpulan, int iv_tanggal, String jam, int iv_jam) {
        this.taskNote = taskNote;
        this.tanggalPengumpulan = tanggalPengumpulan;
        this.iv_tanggal = iv_tanggal;
        this.jam = jam;
        this.iv_jam = iv_jam;
    }
    public String getTaskNote() {
        return taskNote;
    }
    public void setTaskNote(String taskNote) {
        this.taskNote = taskNote;
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
