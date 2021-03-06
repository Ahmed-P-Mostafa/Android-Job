package com.example.androidjob

import android.app.Application
import com.evernote.android.job.JobManager

class MyApplication :Application() {
    override fun onCreate() {
        super.onCreate()
        JobManager.create(this).addJobCreator(DemoJobCreator())
    }
}