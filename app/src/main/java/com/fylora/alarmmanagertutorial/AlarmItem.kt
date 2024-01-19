package com.fylora.alarmmanagertutorial

import java.time.LocalDateTime

data class AlarmItem(
    val time: LocalDateTime,
    val message: String,
    val title: String
)
