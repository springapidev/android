package com.coderbd.jobschedularforsilentpro.services;

import android.app.job.JobParameters;
import android.app.job.JobService;

/**
 * Created by Rajail Islam on 11/8/2017.
 */

public class MyJobService extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
