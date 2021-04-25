package com.example.tasklist;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends ListAdapter<ListTask, Adapter.ViewHolder> {

    // RecyclerView recyclerView;
    public Adapter(DiffUtil.ItemCallback<ListTask> diffCallback) {
        super(diffCallback);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListTask myListTugas = getItem(position) ;
        holder.tv_taskNote.setText(myListTugas.getTaskName());
        holder.tv_tanggalPengumpulan.setText(myListTugas.getTanggalPengumpulan());
        holder.iv_tanggal.setImageResource(myListTugas.getIv_tanggal());
        holder.tv_jam.setText(myListTugas.getJam());
        holder.iv_jam.setImageResource(myListTugas.getIv_jam());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("namaTugas",myListTugas.getTaskName().toString());
                bundle.putString("tanggal",myListTugas.getTanggalPengumpulan().toString());
                bundle.putString("jam",myListTugas.getJam().toString());
                Intent intent = new Intent(view.getContext(), TaskDetail.class);
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);
            }
        });
    }

    static class WordDiff extends DiffUtil.ItemCallback<ListTask> {
        @Override
        public boolean areItemsTheSame(@NonNull ListTask oldItem, @NonNull ListTask newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ListTask oldItem, @NonNull ListTask newItem) {
            return oldItem.getTaskName().equals(newItem.getTaskName());
        }
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_taskNote;
        public ImageView iv_jam;
        public TextView tv_jam;
        public ImageView iv_tanggal;
        public TextView tv_tanggalPengumpulan;
        public CardView cardView;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.tv_taskNote = (TextView) itemView.findViewById(R.id.TaskNote);
            this.tv_tanggalPengumpulan = (TextView) itemView.findViewById(R.id.TanggalPengumpulan);
            this.iv_tanggal = (ImageView) itemView.findViewById(R.id.ivtanggal);
            this.tv_jam = (TextView) itemView.findViewById(R.id.jam);
            this.iv_jam = (ImageView) itemView.findViewById(R.id.ivjam);
            cardView = (CardView)itemView.findViewById(R.id.TaskCard);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativelayout);
        }
    }
}
