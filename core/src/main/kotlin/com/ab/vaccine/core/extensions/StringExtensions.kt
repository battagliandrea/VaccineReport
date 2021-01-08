package com.ab.vaccine.core.extensions

import android.content.Context

fun String.getStringResourceByName(context: Context?): String {
    return context?.let {
        val resId: Int = it.resources.getIdentifier(this, "string", it.packageName)
        it.resources.getString(resId)
    } ?: String()
}
