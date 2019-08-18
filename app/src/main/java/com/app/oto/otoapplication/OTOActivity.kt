package com.app.oto.otoapplication

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.view.WindowManager
import kotlinx.android.synthetic.main.home_activity_transport.*
import kotlinx.android.synthetic.main.navigation_layout.view.*

class OTOActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity_transport)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

//        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//        }
        transport_home_navigation.apply {
            btn_transport.background = ResourcesCompat.getDrawable(resources,R.mipmap.transport_clicked,null)
        }
    }
}
