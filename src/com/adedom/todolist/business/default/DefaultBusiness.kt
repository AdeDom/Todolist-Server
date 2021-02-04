package com.adedom.todolist.business.default

import java.text.SimpleDateFormat
import java.util.*

internal class DefaultBusiness {

    fun getDateTimeLongToString(dateTime: Long?): String {
        return SimpleDateFormat("dd/MM/yyyy HH:mm", Locale("th", "TH")).format(dateTime)
    }

}
