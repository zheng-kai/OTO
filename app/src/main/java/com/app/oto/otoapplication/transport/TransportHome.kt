package com.app.oto.otoapplication.transport

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import com.app.oto.otoapplication.R
import kotlinx.android.synthetic.main.home_activity_transport.*
import kotlinx.android.synthetic.main.navigation_layout.view.*

class TransportHome :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity_transport)
        transport_home_navigation.apply {
            btn_transport.background = ResourcesCompat.getDrawable(resources,R.mipmap.transport_clicked,null)
        }
        cd_car.setOnClickListener {
            startActivity(Intent(this,TransportCar::class.java))
        }
        cd_crowdsource.setOnClickListener{
            startActivity(Intent(this,TransportCrowdsource::class.java))
        }
    }
}