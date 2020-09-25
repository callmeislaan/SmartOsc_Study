package com.fitech;

public class Time {
    private int hours;
    private int minutes;

    public Time() {
    }

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public static boolean check(int hours, int minutes) {
        if (hours >= 0 && hours < 23)
            return true;
        else if (minutes >= 0 && minutes < 60) {
            return true;
        } else
            return false;
    }

    public boolean before(Time other) {
        if (hours < other.hours) {
            return false;
        } else if (hours == other.hours) {
            return minutes >= other.minutes;
        } else {
            return true;
        }
    }

    public int computeTotalMinutes() {
        return hours*60 + minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        return "Time{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                '}';
    }
}
