package com.coderbd.ex10_alarm;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by Rajail Islam on 10/19/2017.
 */

public class ScheduledTask extends TimerTask {
    Date now;
    @Override
    public void run() {
now=new Date();
        System.out.println("Time is :" + now); // Display current time
    }
}
