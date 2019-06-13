package com.example.sports;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import db.Record;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder> {

    private List<Record> recordList;
    private int color = Color.rgb(17, 16,16);

    static class ViewHolder	extends	RecyclerView.ViewHolder	{

        View recordView;
        TextView sport;
        TextView distance;
        TextView duration;
        TextView recordTime;

        public ViewHolder(View view)	{
            super(view);
            recordView = view;
            sport = view.findViewById(R.id.sports);
            distance = view.findViewById(R.id.distance);
            duration = view.findViewById(R.id.duration);
            recordTime = view.findViewById(R.id.recordTime);
        }
    }

    public RecordAdapter(List<Record> recordList){
        this.recordList = recordList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        View view =	LayoutInflater.from(context)
                .inflate(R.layout.record_item,	viewGroup,	false);
        ViewHolder holder = new ViewHolder(view);
        // 点击删除事件
        holder.recordView.setOnClickListener(e->{
            System.out.println("clicked...");
            int position = holder.getAdapterPosition();
            Record record = recordList.get(position);
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Message").setMessage("Delete this record ?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            record.delete();
                            recordList.remove(position);
                            notifyDataSetChanged();
                            Toast.makeText(context, "delete record successfully", Toast.LENGTH_LONG).show();
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).show();
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        Record r = recordList.get(i);
        Log.d("bind...",  r.toString());
        holder.sport.setText(r.getSport());
        holder.sport.setTextColor(color);
        holder.duration.setText(r.getDuration());
        holder.duration.setTextColor(color);
        holder.distance.setText(r.getDistance());
        holder.distance.setTextColor(color);
        holder.recordTime.setText(r.getRecordTime());
        holder.recordTime.setTextColor(color);
    }

    @Override
    public int getItemCount() {
        return recordList.size();
    }
}
