package com.example.tasklist;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class TaskDetail extends AppCompatActivity {
    private TaskViewModel taskViewModel;
    String namaTugas, tanggal, jam;
    TextView kolomNama;
    TextView kolomTanggal;
    TextView kolomJam;
    Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        kolomNama =  findViewById(R.id.isi_namaTugas);
        kolomTanggal =  findViewById(R.id.isi_tanggal);
        kolomJam =  findViewById(R.id.isi_jam);

        delete = findViewById(R.id.delete);

        getData();
        setData();

        taskViewModel = new ViewModelProvider(this,new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(TaskViewModel.class);
        delete.setOnClickListener(View->{
            taskViewModel.delete(namaTugas);
            finish();
        });
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
