package com.example.tasklist;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class taskDetail extends AppCompatActivity {
    String namaTugas, tanggal, jam;
    TextView kolomNama;
    TextView kolomTanggal;
    TextView kolomJam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        kolomNama =  findViewById(R.id.namatugas);
        kolomTanggal =  findViewById(R.id.kolom_tanggal);
        kolomJam =  findViewById(R.id.kolom_jam);

        getData();
        setData();
    }

    public void getData(){
        Bundle bundle = getIntent().getExtras();
        if(getIntent().hasExtra("namaTugas")
                && getIntent().hasExtra("tanggal")
                && getIntent().hasExtra("jam")){

            namaTugas = bundle.getString("namaTugas");
            tanggal = bundle.getString("tanggal");
            jam = bundle.getString("jam");
        }
        else{
            namaTugas = "-";
            tanggal = "-";
            jam = "-";
        }

    }

    public void setData(){
        kolomNama.setText(namaTugas);
        kolomTanggal.setText(tanggal);
        kolomJam.setText(jam);
    }
}
