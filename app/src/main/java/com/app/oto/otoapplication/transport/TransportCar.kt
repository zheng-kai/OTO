package com.app.oto.otoapplication.transport

import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import com.app.oto.otoapplication.R
import kotlinx.android.synthetic.main.navigation_layout.view.*
import kotlinx.android.synthetic.main.transport_car.*

class TransportCar:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transport_car)
        img_car_back.setOnClickListener {
            onBackPressed()
        }
        transport_car_navigation.apply {
            btn_transport.background = ResourcesCompat.getDrawable(resources,R.mipmap.transport_clicked,null)
        }
    }

    override fun onResume() {
        super.onResume()
        map_transport_car.onResume()
    }

    override fun onPause() {
        super.onPause()
        map_transport_car.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        map_transport_car.onDestroy()
    }
}