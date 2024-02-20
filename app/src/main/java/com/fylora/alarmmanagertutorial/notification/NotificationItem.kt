package com.fylora.alarmmanagertutorial.notification

import androidx.annotation.DrawableRes

data class NotificationItem(
    val id: Int,
    val title: String,
    val content: String,
    @DrawableRes val icon: Int,
)