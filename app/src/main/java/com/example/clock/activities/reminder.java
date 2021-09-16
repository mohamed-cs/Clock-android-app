package com.example.clock.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.clock.AlarmReceiver;
import com.example.clock.R;

import java.util.Calendar;

public class reminder extends Fragment implements View.OnClickListener {


    private int notificationId = 1;
    private View view;
    private EditText editText;
    private TimePicker timePicker;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.activity_reminder,container,false);
        view.findViewById(R.id.setBtn).setOnClickListener(this);
        view.findViewById(R.id.cancelBtn).setOnClickListener(this);
        editText=view.findViewById(R.id.editText);
        timePicker=view.findViewById(R.id.timePicker);
        return view;
    }

    @Override
    public void onClick(View view) {

        // Intent
        Intent intent = new Intent(getActivity(), AlarmReceiver.class);
        intent.putExtra("notificationId", notificationId);
        intent.putExtra("message", editText.getText().toString());

        // PendingIntent
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                getContext(), 0, intent, PendingIntent.FLAG_CANCEL_CURRENT
        );

        // AlarmManager
        AlarmManager alarmManager = (AlarmManager)getActivity().getApplicationContext().getSystemService(getContext().ALARM_SERVICE);

        switch (view.getId()) {
            case R.id.setBtn:
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();

                // Create time.
                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, hour);
                startTime.set(Calendar.MINUTE, minute);
                startTime.set(Calendar.SECOND, 0);
                long alarmStartTime = startTime.getTimeInMillis();

                // Set Alarm
                alarmManager.set(AlarmManager.RTC_WAKEUP, alarmStartTime, pendingIntent);
                Toast.makeText(getContext(), "Done!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.cancelBtn:
                alarmManager.cancel(pendingIntent);
                Toast.makeText(getContext(), "Canceled.", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}