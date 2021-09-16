package com.example.clock.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.media.RingtoneManager;
import android.net.Uri;

import com.example.clock.R;

import java.text.SimpleDateFormat;


public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    private  long START_TIME_IN_MILLIS;
    private TextView counter,counterseconds;
    private Button start_pause,pause,restart,cancel;
    private ProgressBar progressBar;
    private ImageView imageView;
    private CountDownTimer mcountdowntimer;
    private boolean mtimerrunning;
    private  long mtimerleftmillis;
    private long progress;
    java.util.Date date;
    SimpleDateFormat formatter;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle=getIntent().getExtras();
        START_TIME_IN_MILLIS=bundle.getLong("timemille");
        mtimerleftmillis=START_TIME_IN_MILLIS;
        progress=mtimerleftmillis;
        long millis = System.currentTimeMillis();
        formatter = new SimpleDateFormat("E, MMM dd yyyy 'at' hh:mm:ss aa");
        date = new java.util.Date(millis + START_TIME_IN_MILLIS);

        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.ticking);

        counter = findViewById(R.id.text_view_countdown);
        counterseconds = findViewById(R.id.text_view_countdown2);
        imageView = findViewById(R.id.imageView);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setMin(0);
        progressBar.setMax((int) (START_TIME_IN_MILLIS));
        progressBar.setProgress((int) (progress));

        pause = findViewById(R.id.start_pause2);
        start_pause = findViewById(R.id.start_pause);
        restart = findViewById(R.id.restart);
        cancel = findViewById(R.id.Cancell);

        start_pause.setOnClickListener(this);
        restart.setOnClickListener(this);
        pause.setOnClickListener(this);
        cancel.setOnClickListener(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("MY notification", "MY notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        switch (getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) {
            case Configuration.UI_MODE_NIGHT_YES: {
                //process
                imageView.setImageDrawable(getDrawable(R.drawable.clock));
            }
                break;
            case Configuration.UI_MODE_NIGHT_NO: {
                // process
                counter.setTextColor(R.color.black);
                imageView.setImageDrawable(getDrawable(R.drawable.clocklight));
            }
                break;
        }

        start_pause.setVisibility(View.INVISIBLE);
        pause.setVisibility(View.INVISIBLE);
        restart.setVisibility(View.INVISIBLE);
        cancel.setVisibility(View.INVISIBLE);

        updatecountdowntext();

        starttimer(START_TIME_IN_MILLIS);
        start_pause.setWidth(135);
        progressBar.setProgressDrawable(getDrawable(R.drawable.circul));
        progressBar.setProgress(0);
        progressBar.setProgress((int)(progress));

    }
    @Override
    public void onDestroy() {
        pause();
        super.onDestroy();
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.start_pause2)
        {
            if(mtimerrunning)
            {
                mediaPlayer.pause();
                pausetimer();
                progressBar.setProgressDrawable(getDrawable(R.drawable.circul2));
                progressBar.setProgress(0);
                progressBar.setProgress((int)(progress)-1000);
            }

        }
        else if(v.getId()==R.id.start_pause)
        {
            if(!mtimerrunning)
            {
                starttimer(mtimerleftmillis);
                start_pause.setWidth(135);
                progressBar.setProgressDrawable(getDrawable(R.drawable.circul));
                progressBar.setProgress(0);
                progressBar.setProgress((int)(progress));
            }
        }
        else if (v.getId()==R.id.restart)
        {
            if(mtimerleftmillis!=START_TIME_IN_MILLIS) {
                restarttimer();
                mediaPlayer.pause();
                progressBar.setProgress(0);
                progressBar.setProgress((int)progress);
                starttimer(START_TIME_IN_MILLIS);
                start_pause.setWidth(135);
                progressBar.setProgressDrawable(getDrawable(R.drawable.circul));
                progressBar.setProgress(0);
                progressBar.setProgress((int)(progress));
            }
            else
            {
                mediaPlayer.pause();
                progressBar.setProgress(0);
                progressBar.setProgress((int)progress);
            }

        }
        else if(v.getId()==R.id.Cancell)
        {
            mediaPlayer.pause();
            finish();
        }
    }
    private void starttimer(long time)
    {
        long millis = System.currentTimeMillis();
        date = new java.util.Date(millis + time);
        Notification.Builder builder = new Notification.Builder(MainActivity2.this,"MY notification");
        builder.setContentTitle("Timer");
        builder.setContentText("Timer will end at "+formatter.format(date));
        Uri uri;
        uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        builder.setSound(uri);
        builder.setSmallIcon(R.mipmap.icons8_alarm_clock_24px_1);
        builder.setAutoCancel(true);

        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(MainActivity2.this);
        managerCompat.notify(2,builder.build());
        start();
        mcountdowntimer=new CountDownTimer(mtimerleftmillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mtimerleftmillis=millisUntilFinished;
                progress=millisUntilFinished;
                updatecountdowntext();
                progressBar.setProgress((int)(progress-1000));
            }

            @Override
            public void onFinish() {
                progressBar.setProgress(0);
                mtimerrunning=false;
                start_pause.setText("start");
//                restarttimer();
                restart.setVisibility(View.INVISIBLE);
                start_pause.setVisibility(View.INVISIBLE);
                pause.setVisibility(View.INVISIBLE);
                Notification.Builder builder = new Notification.Builder(MainActivity2.this,"MY notification");
                builder.setContentTitle("Timer");
                builder.setContentText("Timer finished");
                Uri uri;
                uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
                builder.setSound(uri);
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat=NotificationManagerCompat.from(MainActivity2.this);
                managerCompat.notify(1,builder.build());
                pause();
                finish();
            }

        }.start();

    mtimerrunning=true;
    start_pause.setVisibility(View.INVISIBLE);
    pause.setVisibility(View.VISIBLE);
    restart.setVisibility(View.INVISIBLE);
    cancel.setVisibility(View.VISIBLE);

    }
    private void updatecountdowntext(){
        int minutes=((int)(mtimerleftmillis/1000)/60);
        int seconds=(((int)mtimerleftmillis/1000)%60);
        int hours=minutes/60;
        minutes=minutes%60;
        String timeleftformatted=String.format("%02d:%02d:",hours,minutes);
        String secondleftformatted=String.format("%02d",seconds);
        counter.setText(timeleftformatted);
        counterseconds.setText(secondleftformatted);

    }
    private void pausetimer()
    {
        mcountdowntimer.cancel();
        mtimerrunning=false;
        pause.setVisibility(View.INVISIBLE);
        start_pause.setVisibility(View.VISIBLE);
        restart.setVisibility(View.VISIBLE);
        cancel.setVisibility(View.INVISIBLE);
    }
    private void restarttimer()
    {
        mtimerleftmillis=START_TIME_IN_MILLIS;
        progress=START_TIME_IN_MILLIS;
        updatecountdowntext();
        restart.setVisibility(View.INVISIBLE);
        pause.setVisibility(View.INVISIBLE);
        start_pause.setVisibility(View.INVISIBLE);
        cancel.setVisibility(View.INVISIBLE);

    }
    public void  start()
    {
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
    }
    public  void pause()
    {
        mediaPlayer.stop();
        mediaPlayer.release();
    }

}