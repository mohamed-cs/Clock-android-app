package com.example.clock.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.clock.model.alarmmodel;

import java.util.ArrayList;
import java.util.List;

public class Databasehandle extends SQLiteOpenHelper {

    private static final int VERSION=1;
    private static final String NAME="alarmdatadatabase";
    private static final String ALARMTABLE="alarm";
    private static final String ID="id";
    private static final String STATUES="statues";
    private static final String ALARMNAME="alarmname";
    private static final String VIBRATE="vibrate";
    private static final String SNOOZE="snooze";
    private static final String DAYTIME="daytime";
    private static final String HOUR="hour";
    private static final String MINUTES="minues";
    private static final String CREATEALARMTABLE =" CREATE TABLE "+ ALARMTABLE +
            "( "+ ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ ALARMNAME +" TEXT, "+ VIBRATE +" INTEGR, "+ STATUES +" INTEGR, "+ SNOOZE +" INTEGR, "+ DAYTIME +" INTEGR, "+ HOUR +" INTEGR, "+ MINUTES +" INTEGR ) ";


    private SQLiteDatabase dp;

    public Databasehandle(Context context)
    {
        super(context,NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase dp) {
        dp.execSQL(CREATEALARMTABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase dp, int oldversion, int newversion) {
        dp.execSQL("DROP TABLE IF EXIST"+ALARMTABLE);
        onCreate(dp);
    }

    public void opendatabase()
    {
        dp=this.getWritableDatabase();
    }

    public void insertalarm(alarmmodel model)
    {
        Log.d("logme","new alarm before adding");
        ContentValues cv = new ContentValues();
        cv.put(ALARMNAME,model.getAlarmname());
        cv.put(STATUES,model.getStatues());
        cv.put(VIBRATE,model.getVibrate());
        cv.put(SNOOZE,model.getSnooze());
        cv.put(DAYTIME,model.getDaytime());
        cv.put(HOUR,model.getHour());
        cv.put(MINUTES,model.getMinues());
        dp.insert(ALARMTABLE,null,cv);

        Log.d("logme","new alarm adding");
    }

    public List<alarmmodel> getallalarm(){
        List<alarmmodel> modelslist=new ArrayList<>();
        Cursor cur = null;
        dp.beginTransaction();
        try{
            cur = dp.query(ALARMTABLE, null, null, null, null, null, null, null);
            if(cur != null){
                if(cur.moveToFirst()){
                    do{
                        alarmmodel model=new alarmmodel();
                        model.setId(cur.getInt(cur.getColumnIndex(ID)));
                        model.setAlarmname(cur.getString(cur.getColumnIndex(ALARMNAME)));
                        model.setStatues(cur.getInt(cur.getColumnIndex(STATUES)));
                        model.setDaytime(cur.getInt(cur.getColumnIndex(DAYTIME)));
                        model.setSnooze(cur.getInt(cur.getColumnIndex(SNOOZE)));
                        model.setVibrate(cur.getInt(cur.getColumnIndex(VIBRATE)));
                        model.setHour(cur.getInt(cur.getColumnIndex(HOUR)));
                        model.setMinues(cur.getInt(cur.getColumnIndex(MINUTES)));
                        modelslist.add(model);
                    } while(cur.moveToNext());
                }
            }
        }
        finally {
            dp.endTransaction();
            assert cur != null;
            cur.close();
        }
        Log.d("logmee","insert"+modelslist.size());
        return modelslist;
    }

    public void updatestatues(int id, int statues, String alarmname,
                                int vibrate,int snooze, int daytime,
                                        int hour,int minues)
    {
        ContentValues cv =new ContentValues();
        cv.put(STATUES,statues);
        cv.put(ALARMNAME,alarmname);
        cv.put(VIBRATE,vibrate);
        cv.put(SNOOZE,snooze);
        cv.put(DAYTIME,daytime);
        cv.put(HOUR,hour);
        cv.put(MINUTES,minues);
        dp.update(ALARMTABLE,cv,ID+"=?",new String[]{String.valueOf(id)});
    }
    public void updatestats(int id,int statues)
    {
        ContentValues cv =new ContentValues();
        cv.put(STATUES,statues);
        dp.update(ALARMTABLE,cv,ID+"=?",new String[]{String.valueOf(id)});
    }

    public void deletealarm(int id)
    {
        dp.delete(ALARMTABLE,ID+"=?",new String[]{String.valueOf(id)});
    }


}
