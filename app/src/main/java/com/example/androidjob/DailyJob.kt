package com.example.androidjob

import android.R
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.evernote.android.job.Job
import java.util.*

class DailyJob:Job() {

    companion object{
        const val TAG = "DailyJob"
    }
    override fun onRunJob(p0: Params): Result {

        val pendingIntent = PendingIntent.getActivity(
            context, 3, Intent(
                context,
                MainActivity::class.java
            ), PendingIntent.FLAG_ONE_SHOT
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                TAG,
                TAG,
                NotificationManager.IMPORTANCE_HIGH
            )
            channel.description = "Job Daily job"
            context.getSystemService(NotificationManager::class.java)
                .createNotificationChannel(channel)
        }

        val notification: Notification =
            NotificationCompat.Builder(context, TAG)
                .setContentTitle("Daily Job")
                .setContentText(Calendar.getInstance().time.toString())
                .setAutoCancel(true)
                .setChannelId(TAG)
                .setSound(null)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_lock_idle_alarm)
                .setShowWhen(true)
                .setColor(Color.GREEN)
                .setLocalOnly(true)
                .build()

        NotificationManagerCompat.from(context).notify(Random().nextInt(), notification)
        return Result.SUCCESS
    }
}