package com.example.tasklist;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static android.app.Activity.RESULT_OK;

public class HomeFragment extends Fragment {
    private TaskViewModel tugasViewModel;
    private Adapter.ViewHolder mWordViewModel;

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.ListHome);
        Adapter adapter = new Adapter(new Adapter.WordDiff());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        tugasViewModel = new ViewModelProvider(this,new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(TaskViewModel.class);
        tugasViewModel.getAllWords().observe(getViewLifecycleOwner(),myListTugas ->{
            adapter.submitList(myListTugas);
        } );

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener( View -> {
            Intent intent = new Intent(getContext(), AddTask.class);
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
        });
        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        int iv_tanggal = R.drawable.pngegg;
        int iv_jam = R.drawable.clock;

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
             ListTask tugas = new ListTask(data.getStringExtra(AddTask.EXTRA_REPLY)
                    ,data.getStringExtra("tanggal")
                     ,iv_tanggal
                    ,data.getStringExtra("jam")
                     ,iv_jam);
            tugasViewModel.insert(tugas);
        } else {
            Toast.makeText(
                    getContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }


    }
}
