package com.example.androidjob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.evernote.android.job.JobManager
import com.evernote.android.job.JobRequest
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private val TAG = "TAG MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.startButton).setOnClickListener {
            Log.d(TAG, "onCreate: ")

            val day = (60*24).toLong()

            JobRequest.Builder(DailyJob.TAG)
                .setPeriodic(TimeUnit.MINUTES.toMillis(day))
                .build().schedule()



        }

        findViewById<Button>(R.id.stopButton).setOnClickListener {
            JobManager.instance().cancelAll()
        }
    }
}