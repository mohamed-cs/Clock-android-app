package com.example.clock.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.clock.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity3 extends Fragment implements OnClickListener {

//    COUNT UP TIMER
    MediaPlayer mediaPlayer;
    private TextView counter, counterseconds;
    private Button start_pause, restart, start;
    private ProgressBar progressBar;
    private long progress = 0;

    private boolean mtimerrunning = false;
    private Timer timer;
    private TimerTask timerTask;

    private long time = 0;
    private TableLayout table;
    private String rowstring;
    private long lasttimeinmille=0;
    private int lap_index=1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_main3,container,false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        counter =view.findViewById(R.id.text_view_countdown_timer);
        counterseconds =view.findViewById(R.id.text_view_countdown2_timer);
        progressBar = view.findViewById(R.id.progressBar_timer);
        progressBar.setMin(0);
        progressBar.setMax(60);
        start_pause = view.findViewById(R.id.start_pause_timer);
        restart =view.findViewById(R.id.restart_timer_lap);
        start =view.findViewById(R.id.starttimer);
        table =view.findViewById(R.id.tablelayout);
        timer = new Timer();

        start_pause.setOnClickListener(this::onClick);
        restart.setOnClickListener(this::onClick);
        start.setOnClickListener(this::onClick);

        mediaPlayer= MediaPlayer.create(getActivity(),R.raw.ticking);
        start.setVisibility(View.VISIBLE);
        start_pause.setVisibility(View.INVISIBLE);
        restart.setVisibility(View.INVISIBLE);
    }

    public void onStop() {
        super.onStop();
        mediaPlayer.pause();
        Log.d("logme","stop");
    }

    @Override
    public void onPause() {
        super.onPause();
        mediaPlayer.pause();
        Log.d("logme","pause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        pause();
        Log.d("logme","destroy");
    }
    public void onDestroyView()
    {
        super.onDestroyView();
        pause();
        Log.d("logme","destroyv");
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.starttimer) {
            if(!mtimerrunning) {
                mtimerrunning = true;
                starttimer();
            }

        }
        else if (v.getId() == R.id.restart_timer_lap) {
            if(!mtimerrunning) {
                mediaPlayer.pause();
                Restarttimer();
                start.setVisibility(View.VISIBLE);
                start_pause.setVisibility(View.INVISIBLE);
                restart.setVisibility(View.INVISIBLE);
                mtimerrunning=false;
                removerow();
            }
            else
            {
                addrow(getRowstring());
            }

        }
        else if(v.getId()==R.id.start_pause_timer)
        {
            if(!mtimerrunning)
            {
                mtimerrunning=true;
                starttimer();
            }
            else
            {
                mediaPlayer.pause();
                timerTask.cancel();
                restart.setText("Reset");
                start_pause.setText("Resume");
                mtimerrunning=false;
            }

        }

    }

    private void Restarttimer() {
        timerTask.cancel();
        time = 0;
        progress=0;
        updatecountuptext();
    }

    private void starttimer() {
        start.setVisibility(View.INVISIBLE);
        restart.setVisibility(View.VISIBLE);
        start_pause.setVisibility(View.VISIBLE);
        restart.setText("LAP");
        start_pause.setText("Pause");

        lap_index=1;
        start();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time++;
                        updatecountuptext();
                    }
                });

            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 10);
    }

    private void updatecountuptext() {
        long rounded;
        int minutes;
        int seconds;
        int mille;
        rounded = (time);
        minutes = (int) (rounded / 100 / 60);
        seconds = (int) (rounded / 100 % 60);
        mille = (int) (rounded - (minutes * 60 * 100 + seconds * 100));
        progress = seconds;
        String indexformatted=String.format("%02d",lap_index);
        String timereachformatted = String.format("%02d:%02d:", minutes, seconds);
        String secondreachformatted = String.format("%02d", mille);
        counter.setText(timereachformatted);
        counterseconds.setText(secondreachformatted);
        progressBar.setProgress((int) (progress));
    }

    private void addrow(String row_string)
    {

        TableRow row = new TableRow(getActivity());
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT);
        row.setLayoutParams(lp);
        TextView index = new TextView(getActivity());
        index.setText(row_string);
        index.setTextSize(23);
        row.addView(index);

        table.addView(row, 0);
    }
    private void removerow()
    {
        int count = table.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = table.getChildAt(i);
            if (child instanceof TableRow) ((ViewGroup) child).removeAllViews();
        }
    }

    private String calcdifference(long rounded,long lasttimeinmille)
    {
        long difference=rounded-lasttimeinmille;
        int minutes;
        int seconds;
        int mille;
        minutes = (int) (difference/ 100 / 60);
        seconds = (int) (difference/ 100 % 60);
        mille = (int) (difference- (minutes * 60 * 100 + seconds * 100));
        String timereachformatted = String.format("%02d:%02d:", minutes, seconds);
        String secondreachformatted = String.format("%02d", mille);
        return timereachformatted+secondreachformatted;
    }

    private String getRowstring()
    {
        long rounded;
        int minutes;
        int seconds;
        int mille;
        rounded = (time);
        minutes = (int) (rounded / 100 / 60);
        seconds = (int) (rounded / 100 % 60);
        mille = (int) (rounded - (minutes * 60 * 100 + seconds * 100));
        progress = seconds;
        String indexformatted=String.format("%02d",lap_index);
        String timereachformatted = String.format("%02d:%02d:", minutes, seconds);
        String secondreachformatted = String.format("%02d", mille);
        rowstring="     "+indexformatted+"\t\t\t\t\t\t\t\t\t"+timereachformatted+secondreachformatted+"\t\t\t\t\t"+calcdifference(rounded,lasttimeinmille);
        lap_index+=1;
        lasttimeinmille=rounded;
        return rowstring;
    }

    public void  start()
    {
        mediaPlayer.setLooping(true);
        mediaPlayer.seekTo(0);
        mediaPlayer.start();
    }
    public  void pause()
    {
        mediaPlayer.stop();
        mediaPlayer.release();
    }


}