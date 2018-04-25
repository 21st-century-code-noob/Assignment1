package com.example.pengxiaocheng.assignment1;

import java.util.Calendar;

/**
 * Created by pengxiaocheng on 2018/4/23.
 */

public class UsageGenerator {
    private boolean dishWasherUsed;
    private boolean dishWasherBreak;
    private int aCUsedHours;
    private int dishWasherUsedTime;
    private boolean aCLastHourUsed;

    public void UsageGenerator(){
        dishWasherUsed = false;
        aCUsedHours = 0;
        dishWasherUsedTime = 0;
        aCLastHourUsed =  false;
        dishWasherBreak = false;
    }

    public boolean getDishWasherUsed()
    {
        return dishWasherUsed;
    }

    public void setDishWasherUsed(boolean dishWasherUsed){
        this.dishWasherUsed = dishWasherUsed;
    }

    public int getACUsedHours(){
        return aCUsedHours;
    }

    public void setaCUsedHours(int aCUsedHours){
     this.aCUsedHours = aCUsedHours;
    }

    public int getDishWasherUsedTime(){
        return dishWasherUsedTime;
    }

    public void setDishWasherUsedTime(int time){
        dishWasherUsedTime = time;
    }

    public double generateRandom(double max, double min){
        return (Math.random() * (max - min) + min);

    }

    public double generateACUsage(){
        Calendar cal = Calendar.getInstance();
        double usageNumber = 0;

        if(cal.get(Calendar.HOUR_OF_DAY)<=9 ||cal.get(Calendar.HOUR_OF_DAY)>=23||aCUsedHours >=10){
            usageNumber = 0;
        }
        else if (aCLastHourUsed == true){
            if(generateRandom(10,0) < 2){
                usageNumber = 0;
                aCLastHourUsed = false;
            }
            else{
                usageNumber = generateRandom(2,1);
                aCLastHourUsed = true;
                aCUsedHours++;
            }
        }
        else{
            if(generateRandom(10,0) >= 3){
                usageNumber = 0;
                aCLastHourUsed = false;
            }
            else{
                usageNumber = generateRandom(2,1);
                aCLastHourUsed = true;
                aCUsedHours++;
            }
        }
        return (double)Math.round(usageNumber*100)/100;
    }

    public double generateDWUsage(){
        Calendar cal = Calendar.getInstance();
        double usageNumber = 0;

        if(cal.get(Calendar.HOUR_OF_DAY)<=6 ||cal.get(Calendar.HOUR_OF_DAY)>=21) {
            usageNumber = 0;
        }
        else
        {
            if(dishWasherUsed == false && generateRandom(10,0) < 2) {
                usageNumber = generateRandom(1, 0);
                dishWasherUsed = true;
                dishWasherBreak = false;
                dishWasherUsedTime = cal.get(Calendar.HOUR_OF_DAY);
            }
            else if(dishWasherUsed == true && cal.get(Calendar.HOUR_OF_DAY) - dishWasherUsedTime <3
                    && generateRandom(10,0) < 5 && dishWasherBreak == false){
                usageNumber = generateRandom(1,0.6);
            }
            else {
                usageNumber = 0;
                dishWasherBreak = true;
            }
        }
        return (double)Math.round(usageNumber*100)/100;
    }

    public double generateFridgeUsage(){
        double usageNumber = generateRandom(0.1,0.07);
        return (double)Math.round(usageNumber*100)/100;
    }
}
