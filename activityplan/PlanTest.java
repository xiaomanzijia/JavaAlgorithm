package com.suanfa.activityplan;

import java.util.*;

/**
 * Created by licheng on 21/1/16.
 */
public class PlanTest {
    public static void main(String[] args) {
        Set<Plan>  plans = new TreeSet<Plan>();
        plans.add(new Plan("9:30","10:30"));
        plans.add(new Plan("10:40","11:30"));
        plans.add(new Plan("8:00","10:30"));
        plans.add(new Plan("11:00","14:30"));
        plans.add(new Plan("13:44","15:30"));
        plans.add(new Plan("11:33","11:40"));
        plans.add(new Plan("8:30","11:40"));
        plans.add(new Plan("10:30","12:30"));

        for (Plan key : plans){
            System.out.println(key);
        }

        List<Plan> result = new ArrayList<Plan>();
        Stack<String> planStack = new Stack<String>();
        planStack.push("0:0");

        for(Plan plan : plans){
            int startTimeHour = Integer.parseInt(plan.getStartTime().split(":")[0]);
            int startTimeMinute = Integer.parseInt(plan.getStartTime().split(":")[1]);
            int endTimeHourTarget = Integer.parseInt(planStack.peek().split(":")[0]);
            int endTimeMinuteTarget = Integer.parseInt(planStack.peek().split(":")[1]);
            if(startTimeHour > endTimeHourTarget || (startTimeHour == endTimeHourTarget && startTimeMinute > endTimeMinuteTarget)){
                result.add(plan);
            }
            planStack.push(plan.getEndTime());
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
