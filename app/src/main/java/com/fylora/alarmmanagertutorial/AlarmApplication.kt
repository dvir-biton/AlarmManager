package com.fylora.alarmmanagertutorial

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.fylora.alarmmanagertutorial.notification.AlarmNotificationService
import com.fylora.alarmmanagertutorial.notification.NotificationService

class AlarmApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        notificationService = AlarmNotificationService(this)
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.O)
            return

        val channel = NotificationChannel(
            AlarmNotificationService.ALARM_CHANNEL_ID,
            "Alarm",
            NotificationManager.IMPORTANCE_HIGH
        )
        channel.description = "Used to show the alarm"

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    companion object {
        lateinit var notificationService: NotificationService
    }
}