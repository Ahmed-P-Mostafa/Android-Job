package com.example.androidjob

import com.evernote.android.job.Job
import com.evernote.android.job.JobCreator

class DemoJobCreator :JobCreator {
    override fun create(tag: String): Job? {
        return when(tag){
            HourlyJob.TAG->{
                HourlyJob()
            }
            DailyJob.TAG->{
                DailyJob()
            }
            QuarterJob.TAG->{
                QuarterJob()
            }
            else -> {
                null
            }
        }
    }
}