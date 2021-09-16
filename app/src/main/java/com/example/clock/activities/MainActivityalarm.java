package com.example.clock.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clock.Addnewalarm;
import com.example.clock.DialogCloseListener;
import com.example.clock.R;
import com.example.clock.ReccycleItemtouchhelper;
import com.example.clock.adapter.alarmadapter;
import com.example.clock.model.alarmmodel;
import com.example.clock.utils.Databasehandle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivityalarm extends Fragment implements DialogCloseListener {

    private static RecyclerView alramrecycleview;
    private static alarmadapter adapter;
    private FloatingActionButton fab;
    private static List<alarmmodel> alarmmodelList;
    private static Databasehandle dp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_main_alarm,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dp=new Databasehandle(getActivity());
        dp.opendatabase();
        alarmmodelList=new ArrayList<>();
        alramrecycleview=view.findViewById(R.id.recycleview);
        fab=view.findViewById(R.id.actionbutton);
        alramrecycleview.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter=new alarmadapter(dp, this);
        alramrecycleview.setAdapter(adapter);
        alarmmodelList=dp.getallalarm();
        Collections.reverse(alarmmodelList);
        adapter.setalarms(alarmmodelList);
        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(new ReccycleItemtouchhelper(adapter));
        itemTouchHelper.attachToRecyclerView(alramrecycleview);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Addnewalarm.newInstance().show(getChildFragmentManager(),Addnewalarm.Tag);
            }
        });

    }

    @Override
    public void handleDialogClose(DialogInterface dialog) {
        alarmmodelList=dp.getallalarm();
        Collections.reverse(alarmmodelList);
        adapter.setalarms(alarmmodelList);
        adapter.notifyDataSetChanged();
    }

    public static void update(int pos)
    {
        alarmmodelList=dp.getallalarm();
        Collections.reverse(alarmmodelList);
        adapter.setalarms(alarmmodelList);
        adapter.notifyItemChanged(pos);
    }

    public static void insert()
    {
        alarmmodelList=dp.getallalarm();
        Collections.reverse(alarmmodelList);
        adapter.setalarms(alarmmodelList);
        adapter.notifyDataSetChanged();
    }

}