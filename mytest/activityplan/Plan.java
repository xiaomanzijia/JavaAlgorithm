package com.suanfa.activityplan;

/**
 * Created by licheng on 21/1/16.
 */
public class Plan implements Comparable<Plan> {
    private String startTime;
    private String endTime;

    public Plan(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }



    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return startTime+"~"+endTime;
    }

    @Override
    public int compareTo(Plan o) {
        String endTime = o.getEndTime();
        int endTimeHourTarget = Integer.parseInt(endTime.split(":")[0]);
        int endTimeMinuteTarget = Integer.parseInt(endTime.split(":")[1]);
        int endTimeHour = Integer.parseInt(this.endTime.split(":")[0]);
        int endTimeMinute = Integer.parseInt(this.endTime.split(":")[1]);
        if(endTimeHourTarget > endTimeHour){
            return -1;
        }else if(endTimeHour == endTimeHourTarget && endTimeMinuteTarget > endTimeMinute){
            return -1;
        }else if(endTimeHour == endTimeHourTarget && endTimeMinute == endTimeMinuteTarget){
            return 0;
        }else {
            return 1;
        }
    }
}
