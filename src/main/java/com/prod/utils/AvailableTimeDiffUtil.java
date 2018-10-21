package com.prod.utils;

public class AvailableTimeDiffUtil {


    public static int getAvailableTimeDiffMinutes(String startTime, String endTime)
    {
        int minutes = 0;

        if(startTime.length() > 0 && endTime.length() > 0)
        {
            String[] startSplit = startTime.split(":");
            int startHour = Integer.parseInt(startSplit[0]);
            int startMinutes = Integer.parseInt(startSplit[1]);

            String[] endSplit = endTime.split(":");
            int endHour = Integer.parseInt(endSplit[0]);
            int endMinutes = Integer.parseInt(endSplit[1]);

            //Need logic for time like: 4:00am to next day 3:00am, but for now it will suffice
            minutes = ((endHour - startHour) * 60) + Math.abs((endMinutes-startMinutes));
        }

        return minutes;
    }


    public static int getStaffAvailableTimeDiffMinutes(String startTime, String endTime, int breakMinutes, int lunch, int additionalTime)
    {
        int minutes = 0;

        if(startTime.length() > 0 && endTime.length() > 0)
        {
            String[] startSplit = startTime.split(":");
            int startHour = Integer.parseInt(startSplit[0]);
            int startMinutes = Integer.parseInt(startSplit[1]);

            String[] endSplit = endTime.split(":");
            int endHour = Integer.parseInt(endSplit[0]);
            int endMinutes = Integer.parseInt(endSplit[1]);

            //Need logic for time like: 4:00am to next day 3:00am, but for now it will suffice
            minutes = ((endHour - startHour) * 60) + Math.abs((endMinutes-startMinutes)) - breakMinutes - lunch - additionalTime;
        }

        return minutes;
    }



}
