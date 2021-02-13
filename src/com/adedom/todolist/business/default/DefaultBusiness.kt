package com.adedom.todolist.business.default

import java.text.SimpleDateFormat

internal class DefaultBusiness {

    fun getDateTimeLongToString(dateTime: Long?): String {
        return dateTime?.let {
            val timeThai = dateTime + (1_000 * 60 * 60 * 7) // time server
            SimpleDateFormat("dd/MM/yyyy HH:mm").format(timeThai)
        } ?: ""
    }

}
