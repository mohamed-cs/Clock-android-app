package com.example.clock.adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clock.Addnewalarm;
import com.example.clock.activities.MainActivityalarm;
import com.example.clock.R;
import com.example.clock.model.alarmmodel;
import com.example.clock.utils.Databasehandle;

import java.util.List;

public class alarmadapter extends RecyclerView.Adapter<alarmadapter.ViewHolder> {
    private List<alarmmodel> alarmlist;
    private MainActivityalarm activity;
    private Databasehandle dp;

    public alarmadapter(Databasehandle dp, MainActivityalarm activity)
    {
        this.activity=activity;
        this.dp=dp;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.alarm_layout,parent,false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        dp.opendatabase();
       final alarmmodel item=alarmlist.get(position);
        String timeleftformatted= String.format("%02d:%02d ",item.getHour(),item.getMinues());
        holder.note.setText(item.getAlarmname());
        holder.switchbutton.setChecked(toboolen(item.getStatues()));
        String time;
        if(item.getDaytime()==0)
        {
            time="am";
        }
        else
        {
            time="pm";
        }
        holder.alarmtime.setText(timeleftformatted+time);

        holder.switchbutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    dp.updatestats(item.getId(),1);
                }
                else
                {
                    dp.updatestats(item.getId(),0);
                }
            }
        });

    }

    public static boolean toboolen(int n)
    {
        return n!=0;
    }

    @Override
    public int getItemCount() {

        Log.d("logme","size"+alarmlist.size());
        return alarmlist.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView alarmtime,note;
        Switch switchbutton;
        ViewHolder(View view)
        {
            super(view);
            alarmtime=view.findViewById(R.id.timetextview);
            note=view.findViewById(R.id.notetextview);
            switchbutton=view.findViewById(R.id.switchturn);
        }
    }

    public void setalarms(List<alarmmodel> alarmlist)
    {
        this.alarmlist=alarmlist;
        notifyDataSetChanged();//updates the arraylist at runtime
        //in case of an insert or delete
    }
    public void edititem(int position)
    {
        alarmmodel mod=alarmlist.get(position);
        Bundle bundle=new Bundle();
        bundle.putInt("id",mod.getId());
        bundle.putInt("statues",mod.getStatues());
        bundle.putString("alarmname",mod.getAlarmname());
        bundle.putInt("vibrate",mod.getVibrate());
        bundle.putInt("daytime",mod.getDaytime());
        bundle.putInt("hour",mod.getHour());
        bundle.putInt("minues",mod.getMinues());
        bundle.putInt("pos",position);
        Addnewalarm fragment=new Addnewalarm();
        fragment.setArguments(bundle);
        fragment.show(activity.getActivity().getSupportFragmentManager(),Addnewalarm.Tag);
        notifyItemChanged(position);
    }

    public Context getContext()
    {
        return activity.getActivity();
    }

    public void Deletealarm(int position)
    {
        alarmmodel item=alarmlist.get(position);
        dp.deletealarm(item.getId());
        alarmlist.remove(position);
        notifyItemRemoved(position);
    }



}
