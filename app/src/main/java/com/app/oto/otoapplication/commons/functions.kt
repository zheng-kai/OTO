package com.app.oto.otoapplication.commons

import android.content.Context
import android.content.Intent
import android.view.View
import com.app.oto.otoapplication.OTOActivity
import kotlinx.android.synthetic.main.navigation_layout.view.*

fun View.setNavigationClickListener(packageContext: Context){
    val intent = Intent(packageContext, OTOActivity::class.java)
    img_home.setOnClickListener {

    }
    img_transport.setOnClickListener {
        intent.putExtra("intentFlag", OTOActivity.INTENT_TRANSPORT_FLAG)
        packageContext.startActivity(intent)
    }
    img_personal.setOnClickListener {
        intent.putExtra("intentFlag", OTOActivity.INTENT_PERSONAL_FLAG)
        packageContext.startActivity(intent)
    }
}