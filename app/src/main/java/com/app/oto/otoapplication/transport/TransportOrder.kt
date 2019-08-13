package com.app.oto.otoapplication.transport

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import com.app.oto.otoapplication.R
import kotlinx.android.synthetic.main.home_activity_transport.*
import kotlinx.android.synthetic.main.navigation_layout.view.*
import kotlinx.android.synthetic.main.transport_order.*

class TransportOrder:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transport_order)
        img_order_back.setOnClickListener {
            onBackPressed()
        }
        transport_order_navigation.apply {
            btn_transport.background = ResourcesCompat.getDrawable(resources,R.mipmap.transport_clicked,null)
        }
    }
}