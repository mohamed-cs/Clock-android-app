package com.example.clock;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.clock.activities.MainActivityalarm;
import com.example.clock.adapter.alarmadapter;
import com.example.clock.model.alarmmodel;
import com.example.clock.utils.Databasehandle;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Addnewalarm extends BottomSheetDialogFragment {
    public static  final String Tag="ActionBottomDialog";
    private TextView dialogtext;
    private EditText alramname;
    private FloatingActionButton addbutton,exitbutton;
    private NumberPicker hour ,mintue,timezone;
    private Switch snozze;
    private Switch vibratee;
    private Databasehandle dp;
    boolean isupdate;

    public static com.example.clock.Addnewalarm newInstance ()
    {
        return new com.example.clock.Addnewalarm();
    }

    @NonNull
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL,R.style.Dialogstyle);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.new_alarmlayout,container,false);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dialogtext=view.findViewById(R.id.textView2);
        alramname=view.findViewById(R.id.editTextTextPersonName);
        addbutton=view.findViewById(R.id.floatingActionButton2);
        exitbutton=view.findViewById(R.id.floatingActionButton);
        hour=view.findViewById(R.id.number_picker);
        mintue=view.findViewById(R.id.number_picker2);
        timezone=view.findViewById(R.id.number_picker4);
        snozze=view.findViewById(R.id.switch1);
        vibratee=view.findViewById(R.id.switch2);
        setpickertime();

        isupdate=false;
        final Bundle bundle=getArguments();
        if(bundle!=null)
        {   addbutton.setEnabled(true);
            dialogtext.setText("Edit alarm");
             isupdate=true;
             int id,statues;
             String alarmname;
             int vibrate,snooze;
             int daytime; //0 am , 1 pm
             int hours,minues;
          alarmname=bundle.getString("alarmname");
          vibrate=bundle.getInt("vibrate");
          snooze=bundle.getInt("snooze");
          daytime=bundle.getInt("daytime");
          hours=bundle.getInt("hour");
          minues=bundle.getInt("minues");

          alramname.setText(alarmname);
          snozze.setChecked(alarmadapter.toboolen(snooze));
          vibratee.setChecked(alarmadapter.toboolen(vibrate));
          hour.setValue(hours-1);
          mintue.setValue(minues);
          timezone.setValue(daytime);

        }
        else
        {
            dialogtext.setText("New alarm");
        }

        dp=new Databasehandle(getActivity().getApplicationContext());
        dp.opendatabase();

        alramname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                 if(charSequence.toString().equals(""))
                 {
                     addbutton.setEnabled(false);
                     Toast.makeText(getActivity(),"Enter Alarm name", Toast.LENGTH_LONG).show();
                 }
                 else
                 {
                     addbutton.setEnabled(true);
                 }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        final boolean finalIsUpdate = isupdate;

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String alarmnamee;
                int vibrate,snooze;
                int daytime; //0 am , 1 pm
                int hours,minues;
                Log.d("logmee","insertion");
                alarmnamee=alramname.getText().toString();

                vibrate=convertboolen(vibratee.isChecked());

                snooze=convertboolen(snozze.isChecked());

                daytime=timezone.getValue();

                hours=hour.getValue()+1;
                minues=mintue.getValue();

                if(finalIsUpdate)
                {
                    dp.updatestatues(bundle.getInt("id"),
                            bundle.getInt("statues"),alarmnamee,vibrate,snooze,daytime,hours,minues);
                    MainActivityalarm.update(bundle.getInt("pos"));
                }
                else
                {
                    Log.d("logme","insertion2");
                    alarmmodel modell=new alarmmodel();
                    modell.setAlarmname(alarmnamee);
                    modell.setHour(hours);
                    modell.setMinues(minues);
                    modell.setVibrate(vibrate);
                    modell.setSnooze(snooze);
                    modell.setDaytime(daytime);
                    modell.setStatues(1);
                    dp.insertalarm(modell);
                    Log.d("logme","insertionfinish");
                    MainActivityalarm.insert();
                }
                dismiss();
            }
        });
        exitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().cancel();
            }
        });

    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        Activity activity=getActivity();

        if(activity instanceof com.example.clock.DialogCloseListener)
        {
             ((com.example.clock.DialogCloseListener) activity).handleDialogClose(dialog);
        }

    }


    private void setpickertime()
    {
        String[] data_hour = getResources().getStringArray(R.array.spinner_hour_alarm);
        String[] data_minutes = getResources().getStringArray(R.array.spinner_minutes_seconds);
        String[] data_timezone= getResources().getStringArray(R.array.spinner_timezone);
        hour.setMinValue(0);
        mintue.setMinValue(0);
        timezone.setMinValue(0);
        hour.setMaxValue(data_hour.length-1);
        mintue.setMaxValue(data_minutes.length-1);
        timezone.setMaxValue(data_timezone.length-1);
        hour.setDisplayedValues(data_hour);
        mintue.setDisplayedValues(data_minutes);
        timezone.setDisplayedValues(data_timezone);
    }

    public int convertboolen(boolean check)
    {
        if(check)
            return 1;
        else
            return 0;
    }




}
