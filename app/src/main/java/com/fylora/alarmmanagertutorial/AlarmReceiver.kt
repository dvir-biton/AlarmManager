package com.fylora.alarmmanagertutorial

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.fylora.alarmmanagertutorial.notification.NotificationItem
import com.fylora.alarmmanagertutorial.notification.NotificationService

class AlarmReceiver(
    private val notificationService: NotificationService = AlarmApplication.notificationService
): BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val message = intent?.getStringExtra("EXTRA_MESSAGE") ?: return
        val title = intent.getStringExtra("EXTRA_TITLE") ?: return

        notificationService.showNotification(
            NotificationItem(
                id = 1,
                title = title,
                content = message,
                icon = R.drawable.baseline_crib_24
            )
        )
    }
}