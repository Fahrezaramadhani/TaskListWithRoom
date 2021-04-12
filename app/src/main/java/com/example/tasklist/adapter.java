package com.example.tasklist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {
    Context context;
    private listTask[] listdata;

    // RecyclerView recyclerView;
    public adapter(listTask[] listdata, Context ct) {
        this.listdata = listdata;
        context = ct;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final listTask myListTugas = listdata[position];
        holder.tv_taskNote.setText(listdata[position].getTaskNote());
        holder.tv_tanggalPengumpulan.setText(listdata[position].getTanggalPengumpulan());
        holder.iv_tanggal.setImageResource(listdata[position].getIv_tanggal());
        holder.tv_jam.setText(listdata[position].getJam());
        holder.iv_jam.setImageResource(listdata[position].getIv_jam());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("namaTugas",listdata[position].getTaskNote().toString());
                bundle.putString("tanggal",listdata[position].getTanggalPengumpulan().toString());
                bundle.putString("jam",listdata[position].getJam().toString());
                Intent intent = new Intent(context,taskDetail.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
                Toast.makeText(view.getContext(),"click on item: "+myListTugas.getTaskNote(),Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.length;
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
