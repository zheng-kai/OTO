package com.app.oto.otoapplication.personal.base

import android.content.Context
import android.content.Intent
import android.util.Log

fun test() {
    Log.e("Logcat", "The method is called successfully!")
}

const val KEY = "ClassName"

fun getMyIntent(context: Context, cls: Class<*>): Intent {
    val intent = Intent(context, cls)
    intent.putExtra(KEY, context.javaClass.name)
    return intent
}

fun getCallClass(intent: Intent): String {
    return intent.getStringExtra(KEY)
}