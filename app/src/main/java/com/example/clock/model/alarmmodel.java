package com.example.clock.model;

public class alarmmodel
{
    private int id,statues;
    public String alarmname;
    private int vibrate,snooze;
    private int daytime; //0 am , 1 pm
    private int hour,minues;

    public void setId(int id) {
        this.id = id;
    }

    public void setStatues(int statues) {
        this.statues = statues;
    }

    public void setAlarmname(String alarmname) {
        this.alarmname = alarmname;
    }

    public void setDaytime(int daytime) {
        this.daytime = daytime;
    }

    public void setVibrate(int vibrate) {
        this.vibrate = vibrate;
    }

    public void setSnooze(int snooze) {
        this.snooze = snooze;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinues(int minues) {
        this.minues = minues;
    }

    public int getId() {
        return id;
    }

    public int getStatues() {
        return statues;
    }

    public String getAlarmname() {
        return alarmname;
    }

    public int getDaytime() {
        return daytime;
    }

    public int getVibrate() {
        return vibrate;
    }

    public int getSnooze() {
        return snooze;
    }

    public int getHour() {
        return hour;
    }

    public int getMinues() {
        return minues;
    }
}
