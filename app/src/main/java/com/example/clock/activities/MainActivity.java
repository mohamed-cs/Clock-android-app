package com.example.clock.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.clock.R;

public class MainActivity extends Fragment implements NumberPicker.OnValueChangeListener ,View.OnClickListener{
    private NumberPicker pickerhour,pickerminutes,pickerseconds;
    private TextView textView;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.activity_main2,container,false);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pickerhour=view.findViewById(R.id.number_picker);
        pickerminutes=view.findViewById(R.id.number_picker2);
        pickerseconds=view.findViewById(R.id.number_picker4);
        textView=view.findViewById(R.id.textView2);
        button=view.findViewById(R.id.start_default);
        pickerhour.setOnValueChangedListener(this::onValueChange);
        button.setOnClickListener(this::onClick);
        setpickertime();

    }

    @Override
    public void onClick(View v) {
      if(v.getId()==R.id.start_default)
      {
          int hour;
          int minutes;
          int seconds;
          long timemillisseconds=0;
          hour=pickerhour.getValue();
          minutes=pickerminutes.getValue();
          seconds=pickerseconds.getValue();

          timemillisseconds=(hour*60*60)+(minutes*60)+seconds;
          timemillisseconds*=1000;

          if(timemillisseconds!=0) {
              Intent intent = new Intent(getActivity(), MainActivity2.class);
              intent.putExtra("timemille", timemillisseconds);
              startActivity(intent);
          }
      }

    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        if(picker.getDisplayedValues()[newVal].compareTo("01")==0)
        {
            textView.setText("hour");
        }
        else
        {
            textView.setText("hours");
        }
    }


    private void setpickertime()
    {
        String[] data_hour = getResources().getStringArray(R.array.spinner_hour);
        String[] data_minutes = getResources().getStringArray(R.array.spinner_minutes_seconds);
        String[] data_seconds = getResources().getStringArray(R.array.spinner_minutes_seconds);
        pickerhour.setMinValue(0);
        pickerminutes.setMinValue(0);
        pickerminutes.setMinValue(0);
        pickerhour.setMaxValue(data_hour.length-1);
        pickerminutes.setMaxValue(data_minutes.length-1);
        pickerseconds.setMaxValue(data_seconds.length-1);
        pickerhour.setDisplayedValues(data_hour);
        pickerminutes.setDisplayedValues(data_minutes);
        pickerseconds.setDisplayedValues(data_seconds);
    }


}

