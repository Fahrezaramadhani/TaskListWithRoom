package com.example.tasklist;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddTask extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    EditText TaskName;
    EditText Tanggal;
    EditText Jam;
    Button submit;
    CheckBox Prioritas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        TaskName = findViewById(R.id.isi_namaTugas);
        Tanggal = findViewById(R.id.isi_tanggal);
        Jam = findViewById(R.id.isi_jam);
        submit = findViewById(R.id.button);



        submit.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(TaskName.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String tugas = TaskName.getText().toString();
                String tanggal = Tanggal.getText().toString();
                String jam = Jam.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, tugas);
                replyIntent.putExtra("tanggal", tanggal);
                replyIntent.putExtra("jam", jam);

                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}
