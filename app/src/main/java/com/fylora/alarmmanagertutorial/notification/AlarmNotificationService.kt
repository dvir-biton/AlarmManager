package com.fylora.alarmmanagertutorial.notification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.fylora.alarmmanagertutorial.MainActivity

class AlarmNotificationService (
    private val context: Context
): NotificationService {

    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    override fun showNotification(item: NotificationItem) {
        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            context,
            1,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )
        val notification = NotificationCompat.Builder(context, ALARM_CHANNEL_ID)
            .setSmallIcon(item.icon)
            .setContentTitle(item.title)
            .setContentText(item.content)
            .setContentIntent(pendingIntent)
            .build()

        notificationManager.notify(item.id, notification)
    }

    companion object {
        const val ALARM_CHANNEL_ID = "alarm_channel"
    }
}